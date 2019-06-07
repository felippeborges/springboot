package com.api_vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_vendas.Entity.Imagem;
import com.api_vendas.Entity.Produto;
import com.api_vendas.Repository.ImagemRepository;
import com.api_vendas.Repository.ProdutoRepository;

@Service
public class ImagemServiceImpl implements ImagemService {

	@Autowired
	private ImagemRepository imgRepository;
	@Autowired
	private ProdutoRepository prdRepository;

	public ImagemServiceImpl(ImagemRepository imgRepository, ProdutoRepository prdRepository) {
		this.imgRepository = imgRepository;
		this.prdRepository = prdRepository;
	}

	@Override
	public List<Imagem> findAll() {
		// TODO Auto-generated method stub
		return this.imgRepository.findAll();
	}

	@Override
	public Imagem find(Long id) {
		// TODO Auto-generated method stub
		return this.imgRepository.findOne(id);
	}

	@Override
	public Imagem create(Long produtoId, Imagem imagem) {
		// TODO Auto-generated method stub
		Produto prd = this.prdRepository.findOne(produtoId);
		imagem.setProdutoId(prd);
		return this.imgRepository.save(imagem);
	}

	@Override
	public Imagem update(Long id, Imagem imagem) {
		Imagem imgExiste = this.imgRepository.findOne(id);

		if (imgExiste != null) {
			imagem.setId(imgExiste.getId());
			this.imgRepository.save(imagem);
			return imagem;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Imagem imagem = this.imgRepository.findOne(id);

		if (imagem != null) {
			this.imgRepository.delete(imagem);
		}

	}

}
