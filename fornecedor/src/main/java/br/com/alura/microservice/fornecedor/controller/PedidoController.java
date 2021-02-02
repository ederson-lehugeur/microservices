package br.com.alura.microservice.fornecedor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.fornecedor.controller.dto.PedidoDto;
import br.com.alura.microservice.fornecedor.controller.form.ItemDoPedidoForm;
import br.com.alura.microservice.fornecedor.model.Pedido;
import br.com.alura.microservice.fornecedor.service.PedidoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {

	private static final Logger LOG = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public ResponseEntity<PedidoDto> realizarPedido(@RequestBody List<ItemDoPedidoForm> itens) {
		LOG.info("Pedido recebido");

		final Pedido pedido = pedidoService.realizarPedido(itens);

		return ResponseEntity.status(HttpStatus.CREATED).body(new PedidoDto(pedido));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoDto> getPedidoPorId(@PathVariable Long id) {
		LOG.info("Buscando pedido pelo id {}", id);

		final Pedido pedido = pedidoService.getPedidoPorId(id);

		return ResponseEntity.ok(new PedidoDto(pedido));
	}

}
