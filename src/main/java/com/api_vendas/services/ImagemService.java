package com.api_vendas.services;

import java.util.List;

import com.api_vendas.Entity.Imagem;

public interface ImagemService {

	public List<Imagem> findAll();

	public Imagem find(Long id);

	public Imagem create(Long produtoId, Imagem imagem);

	public Imagem update(Long id, Imagem imagem);

	public void delete(Long id);
}
