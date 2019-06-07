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

import com.api_vendas.Entity.Cliente;
import com.api_vendas.services.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService cliService;

	public ClienteController(ClienteService cliService) {
		this.cliService = cliService;
	}

	@GetMapping
	@ResponseBody
	public List<Cliente> findAll() {
		return this.cliService.findAll();

	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public Cliente find(@PathVariable(value = "id") Long id) {
		return this.cliService.find(id);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return this.cliService.create(cliente);
	}

	@PutMapping(value = "{id}")
	@ResponseBody
	public Cliente update(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {
		return this.cliService.update(id, cliente);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void destroi(@PathVariable(value = "id") Long id) {
		this.cliService.delete(id);
	}
}
