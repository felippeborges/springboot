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

import com.api_vendas.Entity.Administrador;
import com.api_vendas.services.AdministradorService;

@RestController
@RequestMapping(path = "/administradores")
public class AdministradorController {

	@Autowired
	private AdministradorService adminService;

	public AdministradorController(AdministradorService adminService) {
		this.adminService = adminService;
	}

	@GetMapping
	@ResponseBody
	public List<Administrador> findAll() {
		return this.adminService.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public Administrador find(@PathVariable(value = "id") Long id) {
		return this.adminService.find(id);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Administrador create(@RequestBody Administrador administrador) {
		return this.adminService.create(administrador);
	}

	@PutMapping(value = "/{id}")
	@ResponseBody
	public Administrador update(@PathVariable(value = "id") Long id, @RequestBody Administrador administrador) {
		return this.adminService.update(id, administrador);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void destroi(@PathVariable(value = "id") Long id) {
		this.adminService.delete(id);
	}

}
