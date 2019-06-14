package com.api_vendas.Controller;

import java.util.List;

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

import com.api_vendas.Entity.Categoria;
import com.api_vendas.Entity.Produto;
import com.api_vendas.services.CategoriaService;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService catService;

	public CategoriaController(CategoriaService catService) {

		this.catService = catService;
	}

	@GetMapping
	@ResponseBody
	public List<Categoria> findAll() {
		return this.catService.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public Categoria find(@PathVariable(value = "id") Long id) {
		return this.catService.find(id);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categoria create(@RequestBody Categoria categoria) {
		return this.catService.create(categoria);
	}
	
	@PutMapping(value = "{id}")
	@ResponseBody
	public Categoria update(@PathVariable(value = "id") Long id, @RequestBody Categoria categoria) {
		return this.catService.update(id, categoria);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void destroi(@PathVariable(value = "id") Long id) {
		this.catService.delete(id);
	}

}
