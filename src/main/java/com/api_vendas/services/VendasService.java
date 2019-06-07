package com.api_vendas.services;

import java.util.List;

import com.api_vendas.Entity.Venda;

public interface VendasService {

	public List<Venda> findall();

	public Venda find(Long id);

	public Venda create(Venda venda);

	public Venda update(Long id, Venda venda);

	public void delete(Long id);

}
