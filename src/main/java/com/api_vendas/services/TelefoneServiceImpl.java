package com.api_vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_vendas.Entity.Cliente;
import com.api_vendas.Entity.Telefone;
import com.api_vendas.Repository.ClienteRepository;
import com.api_vendas.Repository.TelefoneRepository;

@Service
public class TelefoneServiceImpl implements TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public TelefoneServiceImpl(TelefoneRepository telefoneRepository, ClienteRepository clienteRepository) {
		this.telefoneRepository = telefoneRepository;
		this.clienteRepository = clienteRepository;
	}

	@Override
	public List<Telefone> findAll() {
		// TODO Auto-generated method stub
		return this.telefoneRepository.findAll();
	}

	@Override
	public Telefone find(Long id) {
		// TODO Auto-generated method stub
		return this.telefoneRepository.findOne(id);
	}

	@Override
	public Telefone create(Long clienteId, Telefone telefone) {
		// TODO Auto-generated method stub
		Cliente cli = this.clienteRepository.findOne(clienteId);
		telefone.setClienteId(cli);
		return this.telefoneRepository.save(telefone);

	}

	@Override
	public Telefone update(Long id, Telefone telefone) {
		// TODO Auto-generated method stub
		Telefone telExiste = this.telefoneRepository.findOne(id);

		if (telExiste != null) {
			telefone.setId(telExiste.getId());
			this.telefoneRepository.save(telefone);
			return telefone;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Telefone telefone = this.telefoneRepository.findOne(id);

		if (telefone != null) {
			this.telefoneRepository.delete(telefone);
		}

	}

}
