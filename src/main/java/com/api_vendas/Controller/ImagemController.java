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

import com.api_vendas.Entity.Imagem;
import com.api_vendas.services.ImagemService;
import com.api_vendas.services.ProdutoService;

@RestController
@RequestMapping(path = "/produtos/{produtoId}/imagens")
public class ImagemController {

	@Autowired
	private ImagemService imgService;
	@Autowired
	private ProdutoService prodService;

	public ImagemController(ImagemService imgService, ProdutoService prodService) {
		this.imgService = imgService;
		this.prodService = prodService;
	}

	@GetMapping
	@ResponseBody
	public List<Imagem> findAll() {
		return this.imgService.findAll();
	}

	@GetMapping(value = "{id}")
	@ResponseBody
	public Imagem find(@PathVariable(value = "id") Long id) {
		return this.imgService.find(id);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Imagem create(@PathVariable("produtoId") Long produtoId, @RequestBody Imagem imagem) {
		return this.imgService.create(produtoId, imagem);
	}

	@PutMapping(value = "{id}")
	@ResponseBody
	public Imagem update(@PathVariable(value = "id") Long id, @RequestBody Imagem imagem) {
		return this.imgService.update(id, imagem);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void destroi(@PathVariable(value = "id") Long id) {
		this.imgService.delete(id);
	}
}
