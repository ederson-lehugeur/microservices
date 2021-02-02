package br.com.alura.microservice.loja.controller.dto;

import br.com.alura.microservice.loja.model.Compra;

public class CompraDto {

	private Long pedidoId;
	private Integer tempoDePreparo;
	private String enderecoDestino;

	public CompraDto(Compra compra) {
		pedidoId = compra.getPedidoId();
		tempoDePreparo = compra.getTempoDePreparo();
		enderecoDestino = compra.getEnderecoDestino();
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

}
