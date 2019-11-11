package com.appuf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appuf.model.dto.UnidadeFederativaDTO;
import com.appuf.service.UnidadeFederativaService;

@RestController
@RequestMapping("/uf")
public class UnidadeFederativaRestController {
	
	@Autowired
	private UnidadeFederativaService ufService;
	
	@GetMapping()
	public List<UnidadeFederativaDTO> listar() {
		List<UnidadeFederativaDTO> ufs = ufService.listar();
		return ufs;
	}
	
	/**
	 * Insere uma UF. Consome uma requisicao json (@RequestBody)
	 */
	@PostMapping("/inserir")
	public UnidadeFederativaDTO inserir(@RequestBody @Valid UnidadeFederativaDTO ufDTO) {
		UnidadeFederativaDTO ufInserida = ufService.inserir(ufDTO);
		
		return ufInserida;
	}

}
