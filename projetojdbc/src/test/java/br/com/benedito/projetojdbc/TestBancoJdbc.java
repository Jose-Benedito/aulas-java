package br.com.benedito.projetojdbc;

import java.util.List;

import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

import org.junit.Test;





//import conexao_jdbc.SingleConnection;
import dao.UserposDAO;

public class TestBancoJdbc {
	@Test 
	public void initBanco(){
		try{
			UserposDAO userposD = new UserposDAO();
			Userposjava userposjava = new Userposjava();
			
			
			userposjava.setNome("Roberto Carlos");
			userposjava.setEmail("robertocarlos@yahoo.com.br");
			
			userposD.salvar(userposjava);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void initDeletar(){
		try{
			UserposDAO dao = new UserposDAO();
			dao.deletar(17L);
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	@Test
	public void testInsertTelefone(){
		try{
			Telefone telefone = new Telefone();
			telefone.setNumero("(45) 9876-3454");
			telefone.setTipo("celular");
			telefone.setUsuario(21L);
			
			UserposDAO dao = new UserposDAO();
			dao.salvarTelefone(telefone);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Test
	public void testaCarregaFoneUser(){
		UserposDAO dao = new UserposDAO();
		List<BeanUserFone> beanUserFones = dao.listaUserFone(2L);
		for (BeanUserFone beanUserFone: beanUserFones){
			System.out.println(beanUserFone);
			System.out.println("------------------------------------");
		}
		
		
		
	}
	@Test
	public void testDeletaUserFone(){
		UserposDAO dao = new UserposDAO();
		dao.deleteFonesPorUser(21L);
	}
	
	
	

}
