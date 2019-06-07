package com.api_vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_vendas.Entity.Produto;
import com.api_vendas.Repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return this.produtoRepository.findAll();
	}

	@Override
	public Produto find(Long id) {
		// TODO Auto-generated method stub
		return this.produtoRepository.findOne(id);
	}

	@Override
	public Produto create(Produto produto) {
		// TODO Auto-generated method stub
		this.produtoRepository.save(produto);
		return produto;
	}

	@Override
	public Produto update(Long id, Produto produto) {
		// TODO Auto-generated method stub
		Produto prodExiste = this.produtoRepository.findOne(id);

		if (prodExiste != null) {
			produto.setId(prodExiste.getId());
			this.produtoRepository.save(produto);
			return produto;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Produto produto = this.produtoRepository.findOne(id);

		if (produto != null) {
			this.produtoRepository.delete(produto);
		}

	}

}
