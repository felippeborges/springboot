package com.api_vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_vendas.Entity.Cliente;
import com.api_vendas.Repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {

		this.clienteRepository = clienteRepository;
	}

	@Override
	public List<Cliente> findAll() {

		return this.clienteRepository.findAll();

	}

	@Override
	public Cliente find(Long id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.findOne(id);
	}

	@Override
	public Cliente create(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.save(cliente);
		return cliente;
	}

	@Override
	public Cliente update(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		Cliente cliExiste = this.clienteRepository.findOne(id);

		if (cliExiste != null) {
			cliente.setId(cliExiste.getId());
			this.clienteRepository.save(cliente);
			return cliente;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Cliente cliente = this.clienteRepository.findOne(id);
		
		if(cliente != null) {
			this.clienteRepository.delete(cliente);
		}

	}

}
