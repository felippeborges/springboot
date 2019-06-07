package com.api_vendas.services;

import java.util.List;

import com.api_vendas.Entity.Produto;

public interface ProdutoService {

	public List<Produto> findAll();

	public Produto find(Long id);

	public Produto create(Produto produto);

	public Produto update(Long id, Produto produto);

	public void delete(Long id);
}
