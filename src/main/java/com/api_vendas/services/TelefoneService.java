package com.api_vendas.services;

import java.util.List;


import com.api_vendas.Entity.Telefone;

public interface TelefoneService {

	public List<Telefone> findAll();

	public Telefone find(Long id);

	public Telefone create(Long clienteId, Telefone telefone);

	public Telefone update(Long id, Telefone telefone);

	public void delete(Long id);

}
