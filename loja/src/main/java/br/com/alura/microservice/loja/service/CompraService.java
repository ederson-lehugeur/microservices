package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDto;
import br.com.alura.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.alura.microservice.loja.controller.form.CompraForm;
import br.com.alura.microservice.loja.model.Compra;

@Service
public class CompraService {

	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizarCompra(CompraForm compraForm) {
		final String estado = compraForm.getEndereco().getEstado();

		LOG.info("Buscando informações no fornecedor de {}", estado);
		InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(compraForm.getEndereco().getEstado());

		LOG.info("Realizando um pedido");
		InfoPedidoDto pedido = fornecedorClient.realizarPedido(compraForm.getItens());

		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compraForm.getEndereco().toString());

		return compraSalva;
	}

}
