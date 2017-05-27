package br.com.caelum.jdbc;
//importar as classes do SQL
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {
	private Connection connection;
	
	//construtor com uma conexão
	public ContatoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	//método adicionar
	public void adicionaContato(Contato contato){
		String sql = "insert into contatos" +
				"(nome, email, endereco, dataNascimento)" +
				"values(?,?,?,?)";
		
		try {
			//PreparedStatement: usado para montar o comando sql
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//seta
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			
			//aqui ele vai como uma data
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			//executa
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//método listar util.list que retorna uma lista de Contato
	public List<Contato> getLista(){
		
		try {
			List<Contato> contatoList = new ArrayList<>();
			//prepara o comando sql para ser executado
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();//executeQuery retorna uma lista e rs é um ponteiro
			
			while (rs.next()){// ponteiro que percorre os registros
				// Criando o obj contato
				Contato contato = new Contato();
				//seta o objeto com o valor do ponteiro
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));
				
				//Montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				//seta a data com o valor do db
				data.setTime(rs.getDate("dataNascimento"));
				//seta a entidade
				contato.setDataNascimento(data);
				
				contatoList.add(contato);
			}
			rs.close();
			stmt.close();
			return contatoList;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//Alterar contato
	public void alteraContato(Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=? ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			//seta os valores na instrução sql
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			System.out.println("Dados alterados!");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//Remover contato
	public void removeContato(Contato contato){
		String sql = "delete from contatos where id=? ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			System.out.println("Dados removidos!");
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
