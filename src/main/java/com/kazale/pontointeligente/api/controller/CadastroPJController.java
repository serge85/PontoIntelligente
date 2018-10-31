package com.kazale.pontointeligente.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kazale.pontointeligente.api.dtos.CadastroPJDto;
import com.kazale.pontointeligente.api.response.Response;
import com.kazale.pontointeligente.api.services.EmpresaService;
import com.kazale.pontointeligente.api.services.FuncionarioService;

@RestController
@RequestMapping("/api/cadastrar-pj")
@CrossOrigin(origins = "*")
public class CadastroPJController {
	
	private static final Logger log = LoggerFactory.getLogger(CadastroPJController.class);
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private EmpresaService empresaService;
	
	public ResponseEntity<Response<CadastroPJDto>> cadastrar(){
		
		return null;
	}
	

}
