package com.api_vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_vendas.Entity.Venda;
import com.api_vendas.Repository.VendasRepository;

@Service
public class VendasServicesImpl implements VendasService {

	@Autowired
	private VendasRepository vendasRepository;

	public VendasServicesImpl(VendasRepository vendasRepository) {
		// TODO Auto-generated constructor stub
		this.vendasRepository = vendasRepository;
	}

	@Override
	public List<Venda> findall() {
		// TODO Auto-generated method stub
		return this.vendasRepository.findAll();
	}

	@Override
	public Venda find(Long id) {
		// TODO Auto-generated method stub
		return this.vendasRepository.findOne(id);
	}

	@Override
	public Venda create(Venda venda) {
		// TODO Auto-generated method stub
		this.vendasRepository.save(venda);
		return venda;
	}

	@Override
	public Venda update(Long id, Venda venda) {
		// TODO Auto-generated method stub
		Venda vendaExiste = this.vendasRepository.findOne(id);

		if (vendaExiste != null) {
			venda.setId(vendaExiste.getId());
			this.vendasRepository.save(venda);
			return venda;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Venda venda = this.vendasRepository.findOne(id);

		if (venda != null) {
			this.vendasRepository.delete(id);
		}

	}

}
