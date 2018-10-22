package com.kazale.pontointeligente.api.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.kazale.pontointeligente.api.entities.Empresa;
import com.kazale.pontointeligente.api.entities.Funcionario;
import com.kazale.pontointeligente.api.enums.PerfilEnum;
import com.kazale.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {
	
	private static final String EMAIL = "email@gmail.com";
	private static final String CPF = "0123456789";
	
	@Autowired
	private FuncionarioRepository funcionarioRepository ;
	
	@Autowired
	private EmpresaRepository empresaRepository ;
	
	
	
	@Before
	public void setUp() {
		Empresa e = this.empresaRepository.save(obterDadosEmpresa());
		this.funcionarioRepository.save(obterDadosFuncionario(e));
	}
	
	@After
	public final void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarFuncionarioPorEmail() {
		Funcionario f = this.funcionarioRepository.findByEmail(EMAIL);
		
		assertEquals(EMAIL, f.getEmail());
	}
	
	@Test
	public void testBuscarFuncionarioPorCpf() {
		Funcionario f = this.funcionarioRepository.findByCpf(CPF);
		
		assertEquals(CPF, f.getCpf());
	}
	
	private Funcionario obterDadosFuncionario(Empresa e) {
		Funcionario f = new Funcionario();
		f.setNome("Serge");
		f.setPerfil(PerfilEnum.ROLE_USUARIO);
		f.setSenha(PasswordUtils.gerarBCrypt("123456"));
		f.setCpf(CPF);
		f.setEmail(EMAIL);
		f.setEmpresa(e);
		return f;
	}
	
	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj("51463645000100");
		return empresa;
	}
}
