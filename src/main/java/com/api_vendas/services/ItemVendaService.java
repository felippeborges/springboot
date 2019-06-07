package com.api_vendas.services;

import java.util.List;

import com.api_vendas.Entity.ItemVenda;

public interface ItemVendaService {

	public List<ItemVenda> findAll();

	public ItemVenda find(Long id);

	public ItemVenda create(ItemVenda itemVenda);

	public ItemVenda update(Long id, ItemVenda itemVenda);

	public void delete(Long id);
}
