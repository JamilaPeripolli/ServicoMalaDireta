package br.com.maladireta.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.maladireta.dto.Aluno;
import br.com.maladireta.service.MalaDiretaService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/maladireta")
public class MalaDiretaWS {
	
	@Autowired
	private MalaDiretaService service;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Integer notificarAlunos(@RequestBody List<Aluno> alunos) {
		return service.notificarAlunos(alunos);
	}

}
