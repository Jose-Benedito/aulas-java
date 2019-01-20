package conexao_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	//permite chamar o método conectar em qualquer lugar do progranma sem precisar instanciá-lo
	static{
		conectar();
	}
	
	//Construtor
	public SingleConnection(){
		conectar();
		
	}
	
	private static void conectar(){
		try{
			
	//Verifica se já existe uma conexão e sendo nula carrega o Drive do banco com 'Class.forName' e faz a conexão		
			if(connection == null){
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url,user,password);
				connection.setAutoCommit(false);
				System.out.println("Conexão realizada com sucesso");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//o método é público para que possa ser acessado por toda a classe
	public static Connection getConnection(){
		return connection;
	}
	
	
}
