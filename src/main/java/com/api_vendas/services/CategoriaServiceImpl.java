package com.api_vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_vendas.Entity.Categoria;
import com.api_vendas.Repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository catRepository;

	public CategoriaServiceImpl(CategoriaRepository catRepository) {
		this.catRepository = catRepository;
	}

	@Override
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return this.catRepository.findAll();
	}

	@Override
	public Categoria find(long id) {
		// TODO Auto-generated method stub
		return this.catRepository.findOne(id);
	}

	@Override
	public Categoria create(Categoria categoria) {
		// TODO Auto-generated method stub
		this.catRepository.save(categoria);
		return categoria;
	}

	@Override
	public Categoria update(Long id, Categoria categoria) {
		// TODO Auto-generated method stub
		Categoria catExiste = this.catRepository.findOne(id);

		if (catExiste != null) {
			categoria.setId(catExiste.getId());
			this.catRepository.save(categoria);
			return categoria;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Categoria categoria = this.catRepository.findOne(id);

		if (categoria != null) {
			this.catRepository.delete(categoria);
		}
	}

}
