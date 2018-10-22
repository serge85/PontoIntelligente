package com.kazale.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.kazale.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {
	
	/**
	 * 
	 * Find Lancamento by FuncionarioId 
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */
	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Return a Lancamento by Id
	 * 
	 * @param id
	 * @return Optional<Lancamento>
	 */
	Optional<Lancamento> buscarPorId(Long id);
	
	/**
	 * Persist a Lancamento
	 * 
	 * @param l
	 * @return Lancamento
	 */
	Lancamento persistir(Lancamento l);
	
	/**
	 * Remove Lancamento by Id
	 * @param id
	 */
	void remover(Long id);
	

}
