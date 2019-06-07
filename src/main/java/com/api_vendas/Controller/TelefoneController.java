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

import com.api_vendas.Entity.Telefone;
import com.api_vendas.services.ClienteService;
import com.api_vendas.services.TelefoneService;

@RestController
@RequestMapping(path = "/clientes/{clienteId}/telefones")
public class TelefoneController {

	@Autowired
	private TelefoneService telService;
	@Autowired
	private ClienteService cliService;

	public TelefoneController(TelefoneService telService, ClienteService cliService) {
		this.telService = telService;
		this.cliService = cliService;
	}

	@GetMapping
	@ResponseBody
	public List<Telefone> findAll() {
		return telService.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public Telefone find(@PathVariable(value = "id") Long id) {
		return this.telService.find(id);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Telefone create(@PathVariable("clienteId") Long clienteId, @RequestBody Telefone telefone) {
		return this.telService.create(clienteId, telefone);
	}

	@PutMapping(value = "{id}")
	@ResponseBody
	public Telefone update(@PathVariable(value = "id") Long id, @RequestBody Telefone telefone) {
		return this.telService.update(id, telefone);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void destroi(@PathVariable(value = "id") Long id) {
		this.telService.delete(id);
	}
}
