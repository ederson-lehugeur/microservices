package br.com.alura.microservice.fornecedor.controller.dto;

import java.util.List;

import br.com.alura.microservice.fornecedor.model.Pedido;
import br.com.alura.microservice.fornecedor.model.PedidoItem;
import br.com.alura.microservice.fornecedor.model.PedidoStatus;

public class PedidoDto {

	private Long id;
	private Integer tempoDePreparo;
	private PedidoStatus status;
	private List<PedidoItem> itens;

	public PedidoDto(Pedido pedido) {
		id = pedido.getId();
		tempoDePreparo = pedido.getTempoDePreparo();
		status = pedido.getStatus();
		itens = pedido.getItens();
	}

	public Long getId() {
		return id;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

}
