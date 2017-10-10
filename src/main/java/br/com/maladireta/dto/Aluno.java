package br.com.maladireta.dto;

public class Aluno {
	private String documento;
	private String nome;
	private String endereco;
	private String cep;
	private String mensagem;
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getCep() {
		return cep;
	}
	public String getMensagem() {
		return mensagem;
	}
	
	public String getEmail() {
		return "exemplo@email.com";
	}
	
}
