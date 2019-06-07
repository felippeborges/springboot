package com.api_vendas.services;

import java.util.List;

import com.api_vendas.Entity.Cliente;

public interface ClienteService {

	public List<Cliente> findAll();

	public Cliente find(Long id);

	public Cliente create(Cliente cliente);

	public Cliente update(Long id, Cliente cliente);

	public void delete(Long id);

}
