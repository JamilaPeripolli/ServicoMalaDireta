package br.com.maladireta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.maladireta.dto.Aluno;
import br.com.maladireta.dto.NotaAluno;
import br.com.maladireta.ws.AlunoWS;

@Service
public class MalaDiretaService {

	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	private AlunoWS ws;
	
	public Integer notificarAlunos(List<Aluno> alunos) {
		List<Aluno> alunosParaNotificar = buscarAlunosParaNotificar(alunos);
		int quantidadeEmailsEnviados = alunosParaNotificar.size();
		for(Aluno aluno : alunosParaNotificar) {
			try {
				enviarNotificacao(aluno);
			}catch(Exception e) {
				quantidadeEmailsEnviados--;
				e.printStackTrace();
			}
		}
		return quantidadeEmailsEnviados;
	}

	private void enviarNotificacao(Aluno aluno) {
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(aluno.getEmail());
        email.setSubject("Notas baixas");
        email.setText(aluno.getMensagem());
        mailSender.send(email);
	}

	private List<Aluno> buscarAlunosParaNotificar(List<Aluno> alunos) {
		List<Aluno> alunosParaNotificar = new ArrayList<>();
		preencherDocumentoAlunos(alunos);
		for(Aluno a : alunos) {
			if(existeNotaAbaixoDaMedia(NotaAluno.NOTA_MEDIA, a)) {
				alunosParaNotificar.add(a);
			}
		}
		return alunosParaNotificar;
	}
	
	public void preencherDocumentoAlunos(List<Aluno> alunos){
		List<Aluno> todosAlunos = ws.getAlunos();
		for(Aluno aluno : alunos) {
			Stream<Aluno> streamAlunos = todosAlunos.stream();
			Optional<Aluno> alunoComDocumento = streamAlunos.filter(a -> a.getNome().equals(aluno.getNome())).findAny();
			streamAlunos.close();
			if(alunoComDocumento.isPresent()) {
				aluno.setDocumento(alunoComDocumento.get().getDocumento());
			}
		}
	}
	
	private boolean existeNotaAbaixoDaMedia(double notaMedia, Aluno a) {
		NotaAluno notaAluno = ws.getNotaAlunoPorCpf(a.getDocumento());
		return notaAluno.getNotas().values().stream()
											.filter(n -> (n.doubleValue() < notaMedia))
											.findFirst()
											.isPresent();
	}
}
