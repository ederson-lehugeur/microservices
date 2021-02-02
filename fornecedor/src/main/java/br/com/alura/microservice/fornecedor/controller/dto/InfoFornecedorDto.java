package br.com.alura.microservice.fornecedor.controller.dto;

import br.com.alura.microservice.fornecedor.model.InfoFornecedor;

public class InfoFornecedorDto {

	private Long id;
	private String nome;
	private String estado;
	private String endereco;

	public InfoFornecedorDto(InfoFornecedor infoPorEstado) {
		id = infoPorEstado.getId();
		nome = infoPorEstado.getNome();
		estado = infoPorEstado.getEstado();
		endereco = infoPorEstado.getEndereco();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEstado() {
		return estado;
	}

	public String getEndereco() {
		return endereco;
	}

}
