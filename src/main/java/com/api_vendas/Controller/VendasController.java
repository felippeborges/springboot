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

import com.api_vendas.Entity.Venda;
import com.api_vendas.services.VendasService;


@RestController
@RequestMapping(path ="/vendas")
public class VendasController {

	@Autowired
	private VendasService vendasService;
	
	public VendasController (VendasService vendasService) {
		this.vendasService = vendasService;
	}
	
	@GetMapping
	@ResponseBody
	public List<Venda> findAll(){
		return vendasService.findall();
	}
	
	@GetMapping(value ="/{id}")
	@ResponseBody
	public Venda find(@PathVariable(value = "id") Long id) {
		return this.vendasService.find(id);
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Venda create(@RequestBody Venda venda) {
		return this.vendasService.create(venda);
	}
	
	@PutMapping
	@ResponseBody
	public Venda update(@PathVariable(value = "id") Long id, @RequestBody Venda venda) {
		return this.vendasService.update(id,venda);
	}
	
	@DeleteMapping(value ="/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void destroi(@PathVariable(value="id") Long id) {
		this.vendasService.delete(id);
	}
}
