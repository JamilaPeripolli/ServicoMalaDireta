package br.com.maladireta.ws;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.maladireta.dto.Aluno;
import br.com.maladireta.dto.NotaAluno;

@Component
public class AlunoWS {
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<Aluno> getAlunos(){
																			//  "exemplo-cadastro.com/alunos"
		ResponseEntity<Aluno[]> responseEntity = restTemplate.getForEntity("http://www.mocky.io/v2/59dc4c9a1000001c0cccd291", Aluno[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	
	public NotaAluno getNotaAlunoPorCpf(String cpf) {
											//  "exemplo-notas.com/alunos/"+cpf+"/notas"
		return restTemplate.getForObject("http://www.mocky.io/v2/59dc50f31000005d0cccd29d", NotaAluno.class);
	}
}
