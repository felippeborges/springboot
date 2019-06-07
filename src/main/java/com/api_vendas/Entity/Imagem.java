package com.api_vendas.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String patch;
	@OneToOne()
	@JoinColumn(name = "produto_id")
	@JsonBackReference
	private Produto produtoId;

	public Imagem() {
	}

	public Imagem(Long id, String patch, Produto produtoId) {
		this.id = id;
		this.patch = patch;
		this.produtoId = produtoId;
	}

	public Imagem(String patch, Produto produtoId) {
		this.patch = patch;
		this.produtoId = produtoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatch() {
		return patch;
	}

	public void setPatch(String patch) {
		this.patch = patch;
	}

	public Produto getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}

}