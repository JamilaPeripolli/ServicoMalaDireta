package br.com.maladireta.ws;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MalaDiretaController {
	
	@RequestMapping("/")
	@ResponseBody
	public String oi() {
		return "Olá Mundo!";
	}

}
