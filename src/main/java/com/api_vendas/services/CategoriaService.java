package com.api_vendas.services;

import java.util.List;

import com.api_vendas.Entity.Categoria;

public interface CategoriaService {

	public List<Categoria> findAll();
	
	public Categoria find(long id);
	
	public Categoria create(Categoria categoria);
	
	public Categoria update(Long id, Categoria categoria);
	
	public void delete(Long id);
}
