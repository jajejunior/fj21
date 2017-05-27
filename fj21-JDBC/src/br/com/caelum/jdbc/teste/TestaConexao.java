package br.com.caelum.jdbc.teste;
/*Classe de teste de conex�o*/
import java.sql.Connection;
import java.sql.SQLException;
import br.com.caelum.jdbc.ConnectionFactory; //importando ConnectionFactory

public class TestaConexao {

	public static void main(String[] args) throws SQLException{
		//Conex�o definida fora dos locos para permitir acesso geral
		Connection connection = null;
		try{
			connection = new ConnectionFactory().getConnection();
			System.out.println("Conex�o aberta!");
		}
		
		catch (RuntimeException e) {
			// TODO: handle exception
		}
		
		finally{
			connection.close();
			System.out.println("conex�o fechada!");
		}
	}
}
