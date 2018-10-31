package com.kazale.pontointeligente.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.kazale.pontointeligente.api.entities.Lancamento;
import com.kazale.pontointeligente.api.repository.LancamentoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoServiceTest {
	
	@MockBean
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Before
	public void setUp() {
		BDDMockito.given(this.lancamentoRepository.save(Mockito.any(Lancamento.class))).willReturn( new Lancamento());
		BDDMockito.given(this.lancamentoRepository.findByFuncionarioId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
			.willReturn( new PageImpl<Lancamento>(new ArrayList<Lancamento>()));
		BDDMockito.given(this.lancamentoRepository.findOne(Mockito.anyLong())).willReturn( new Lancamento());
	}
	
	@Test
	public void testBuscarPorFuncionarioId() {
		Page<Lancamento> lanc = this.lancamentoService.buscarPorFuncionarioId(1L, new PageRequest(0, 10));
		
		assertNotNull(lanc);
	}
	
	@Test
	public void testBuscarPorId() {
		Optional<Lancamento> lanc = this.lancamentoService.buscarPorId(1L);
		
		assertTrue(lanc.isPresent());
	}
	
	@Test
	public void testPersistir() {
		Lancamento l = this.lancamentoService.persistir(new Lancamento());
		
		assertNotNull(l);
	}

}
