package com.api_vendas.Controller;

import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api_vendas.Entity.Produto;
import com.api_vendas.services.ProdutoService;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoService prodService;

	public ProdutosController(ProdutoService prodService) {
		this.prodService = prodService;
	}

	@GetMapping
	@ResponseBody
	public List<Produto> findAll() {
		return this.prodService.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public Produto find(@PathVariable(value = "id") Long id) {
		return this.prodService.find(id);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto create(@RequestBody Produto produto) {
		return this.prodService.create(produto);
	}

	@PutMapping(value = "{id}")
	@ResponseBody
	public Produto update(@PathVariable(value = "id") Long id, @RequestBody Produto produto) {
		return this.prodService.update(id, produto);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void destroi(@PathVariable(value = "id") Long id) {
		this.prodService.delete(id);
	}

}
