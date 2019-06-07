package com.api_vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_vendas.Entity.Administrador;
import com.api_vendas.Repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;

	public AdministradorServiceImpl(AdministradorRepository administradorRepository) {

		this.administradorRepository = administradorRepository;
	}

	@Override
	public List<Administrador> findAll() {
		// TODO Auto-generated method stub
		return this.administradorRepository.findAll();
	}

	@Override
	public Administrador find(Long id) {

		return this.administradorRepository.findOne(id);
	}

	@Override
	public Administrador create(Administrador administrador) {

		this.administradorRepository.save(administrador);
		return administrador;
	}

	@Override
	public Administrador update(Long id, Administrador administrador) {
		Administrador adminExiste = this.administradorRepository.findOne(id);

		if (adminExiste != null) {
			administrador.setId(adminExiste.getId());
			this.administradorRepository.save(administrador);
			return administrador;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Administrador administrador = this.administradorRepository.findOne(id);

		if (administrador != null) {
			this.administradorRepository.delete(administrador);
		}
	}

}
