package dao;
/*
 * Nesta classe será gerenciada toda a persistencia de dados para a
 * classe modelo (tabela)
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;
import conexao_jdbc.SingleConnection;

public class UserposDAO {
	private Connection connection;

	//Construtor	
	public UserposDAO(){
		connection = SingleConnection.getConnection();
		
	}
	
	//Para o método 'Insert into' 
	public void salvar(Userposjava userposjava){
		try{
			String sql = "insert into public.userposjava (nome, email)values(?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			//passando os parâmetros
			
			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());
			insert.execute();
			connection.commit(); //salva no banco
		
		}catch(Exception e){
			try{
				connection.rollback(); //reverte a operação caso haja erro
			}catch(SQLException el){
				el.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	//Método insere dados na tabela telefoneuser
	public void salvarTelefone(Telefone telefone){
		try{
			String sql = "insert into public.telefoneuser(numero, tipo, usuariopessoa) values(?,?,?)";
			PreparedStatement preS = connection.prepareStatement(sql);
			preS.setString(1,telefone.getNumero());
			preS.setString(2,telefone.getTipo());
			preS.setLong(3,telefone.getUsuario());
			preS.execute();
			connection.commit();
			
		}catch (Exception e){
			try{
				connection.rollback();
				
			}catch (SQLException el){
				el.printStackTrace();
			}
			
		}
		
		
	}
	//método para deletar dados através do id usando a cláusula where
		public void deletar(Long id){
			try{
				String sql = "delete from userposjava where id = "+id;
				PreparedStatement prepS = connection.prepareStatement(sql);
				prepS.execute();
				connection.commit();
				System.out.println("Dado deletado com sucesso");
				
			}catch(Exception e){
				e.printStackTrace();
				try{
					connection.rollback();
					
				}catch(SQLException el){
					el.printStackTrace();
				}
			}
			
		}
		
		//método do Inner Join 
		public List<BeanUserFone> listaUserFone (Long idUser){
			List<BeanUserFone> beanUserFones = new ArrayList<BeanUserFone>();
			
			String sql = " select * from telefoneuser as fone";
			sql += " inner join userposjava as userpos";
			sql += " on fone.usuariopessoa = userpos.id ";
			sql += "where userpos.id ="+idUser;
			
			try{
				
				PreparedStatement prepS = connection.prepareStatement(sql);
				ResultSet resultSet = prepS.executeQuery();
				
				while(resultSet.next()){								//varre a ArrayList, instancia um objeto BeanUserFone e adiciona na Lista(beanUserFones)
					BeanUserFone userFone = new BeanUserFone();
					userFone.setEmail(resultSet.getString("email"));
					userFone.setNome(resultSet.getString("nome"));
					userFone.setNumero(resultSet.getString("numero"));
					
					beanUserFones.add(userFone);
				}
				
			}catch (Exception e){
				e.printStackTrace();
			}
			
			
			
			return beanUserFones;
			
				
		}
		// Deleta os dados das tabelas relacionadas com chave estrangeira
		public void deleteFonesPorUser(Long idUser){
			try{
				String sqlFone = "delete from telefoneUser where usuariopessoa ="+idUser; //sql deleta dados da tabela filho
				String sqlUser = "delete from userposjava where id ="+idUser; //sql deleta dados da tabela pai
				
				PreparedStatement ps = connection.prepareStatement(sqlFone); //deleta 'filhos'
				ps.executeUpdate();
				connection.commit();
				
				ps = connection.prepareStatement(sqlUser); //deleta 'pai'
				ps.executeUpdate();
				connection.commit();
			}catch (Exception e){
				e.printStackTrace();
			}
		}

}











