package com.api_vendas.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@JsonBackReference
	private Cliente clienteId;

	public Telefone() {
	}

	public Telefone(Long id, String telefone, Cliente clienteId) {
		this.id = id;
		this.telefone = telefone;
		this.clienteId = clienteId;
	}

	public Telefone(String telefone, Cliente clienteId) {
		this.telefone = telefone;
		this.clienteId = clienteId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

}
