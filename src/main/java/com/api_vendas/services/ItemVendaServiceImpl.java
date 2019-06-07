package com.api_vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_vendas.Entity.ItemVenda;
import com.api_vendas.Repository.ItemVendaRepository;

@Service
public class ItemVendaServiceImpl implements ItemVendaService {

	@Autowired
	private ItemVendaRepository itemvendaRepository;

	public ItemVendaServiceImpl(ItemVendaRepository itemvendaRepository) {
		// TODO Auto-generated constructor stub
		this.itemvendaRepository = itemvendaRepository;
	}

	@Override
	public List<ItemVenda> findAll() {
		// TODO Auto-generated method stub
		return this.itemvendaRepository.findAll();

	}

	@Override
	public ItemVenda find(Long id) {
		// TODO Auto-generated method stub
		return this.itemvendaRepository.findOne(id);
	}

	@Override
	public ItemVenda create(ItemVenda itemVenda) {
		// TODO Auto-generated method stub
		this.itemvendaRepository.save(itemVenda);
		return itemVenda;
	}

	@Override
	public ItemVenda update(Long id, ItemVenda itemVenda) {
		// TODO Auto-generated method stub
		ItemVenda itemvendaExiste = this.itemvendaRepository.findOne(id);

		if (itemvendaExiste != null) {
			this.itemvendaRepository.save(itemVenda);
			return itemVenda;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ItemVenda itemVenda = this.itemvendaRepository.findOne(id);

		if (itemVenda != null) {
			this.itemvendaRepository.delete(itemVenda);
		}

	}

}
