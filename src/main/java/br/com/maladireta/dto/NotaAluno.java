package br.com.maladireta.dto;

import java.util.Map;

public class NotaAluno {
	public static final double NOTA_MEDIA = 7.0;
	
	private String cpf;
	private Map<String, Double> notas;
	
	public String getCpf() {
		return cpf;
	}
	public Map<String, Double> getNotas() {
		return notas;
	}
	
}
