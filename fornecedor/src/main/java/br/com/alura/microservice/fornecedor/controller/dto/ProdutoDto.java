package br.com.alura.microservice.fornecedor.controller.dto;

import java.math.BigDecimal;

import br.com.alura.microservice.fornecedor.model.Produto;

public class ProdutoDto {

	private Long id;
	private String nome;
	private String estado;
	private String descricao;
	private BigDecimal preco;

	public ProdutoDto(Produto produto) {
		id = produto.getId();
		nome = produto.getNome();
		estado = produto.getEstado();
		descricao = produto.getDescricao();
		preco = produto.getPreco();
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

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

}
