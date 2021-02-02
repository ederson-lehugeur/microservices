package br.com.alura.microservice.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.fornecedor.controller.dto.ProdutoDto;
import br.com.alura.microservice.fornecedor.model.Produto;
import br.com.alura.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> getProdutosPorEstado(String estado) {
		return produtoRepository.findByEstado(estado);
	}

	public List<ProdutoDto> fromEntityToDto(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}

}
