package br.com.alura.microservice.fornecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.fornecedor.controller.dto.ProdutoDto;
import br.com.alura.microservice.fornecedor.model.Produto;
import br.com.alura.microservice.fornecedor.service.ProdutoService;

@RestController
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/{estado}")
	public ResponseEntity<List<ProdutoDto>> getProdutosPorEstado(@PathVariable("estado") String estado) {
		final List<Produto> produtos = produtoService.getProdutosPorEstado(estado);

		return ResponseEntity.ok(produtoService.fromEntityToDto(produtos));
	}

}
