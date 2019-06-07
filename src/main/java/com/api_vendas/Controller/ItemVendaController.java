package com.api_vendas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api_vendas.Entity.ItemVenda;
import com.api_vendas.services.ItemVendaService;

@RestController
@RequestMapping(path = "/itemvendas")
public class ItemVendaController {

	@Autowired
	private ItemVendaService itemvendasService;



	public ItemVendaController(ItemVendaService itemvendasService) {
		this.itemvendasService = itemvendasService;
	}

	@GetMapping
	@ResponseBody
	public List<ItemVenda> findAll() {
		return this.itemvendasService.findAll();
	}

	@GetMapping(value = "{/id}")
	@ResponseBody
	public ItemVenda find(@PathVariable(value = "id") Long id) {
		return this.itemvendasService.find(id);
	}

	@PostMapping
	@ResponseBody
	public ItemVenda create(@RequestBody ItemVenda itemvenda) {
		return this.itemvendasService.create(itemvenda);
	}

	@PutMapping
	@ResponseBody
	public ItemVenda update(@PathVariable(value = "id") Long id, @RequestBody ItemVenda itemVenda) {
		return this.itemvendasService.update(id, itemVenda);
	}

	@DeleteMapping(value = "{id}")
	@ResponseBody
	public void destroi(@PathVariable(value = "id") Long id) {
		this.itemvendasService.delete(id);
	}
}
