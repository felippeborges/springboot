package com.api_vendas.services;

import java.util.List;

import com.api_vendas.Entity.Administrador;

public interface AdministradorService {
	 
	public List<Administrador> findAll();

	public Administrador find(Long id);

	public Administrador create(Administrador administrador);

	public Administrador update(Long id, Administrador administrador);

	public void delete(Long id);


}
