package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;
public class FuncionarioDAO {

	private Connection connection;
	//construtor
	public FuncionarioDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	//Inserir Funcionário
	public void adicionaFuncionario(Funcionario funcionario){
		//cria comando sql
		String sql = "insert into funcionarios"+
		"(nome, usuario, senha)"+
		"values(?,?,?)";
		
		try {
			//joga no stmt a conexão junta com o comando criado
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//junta os valores da instrução com os valores da entidade e seta no stmt
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			
			//executa e fecha
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//Lista
	public List<Funcionario> getLista(){
		
		try {
			//Lista de funcionários com o nome funcionarioList recebe um novo arrayList
			List<Funcionario> funcionarioList = new ArrayList<>();
			
			PreparedStatement stmt = connection.prepareStatement("select * from funcionarios");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				Funcionario funcionario = new Funcionario();
				//seta a beans com o que vier do resultSet e o que vem do rs vem do bd
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				//adiciona o objeto na lista
				funcionarioList.add(funcionario);
				
			}
			stmt.close();
			rs.close();
			return funcionarioList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//Altera Funcionário
	public void alteraFuncionario(Funcionario funcionario){
		String sql = "update funcionarios set nome=?, usuario=?, senha=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			stmt.execute();
			stmt.close();
			System.out.println("Dados Alterados!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void removeFuncionario(Funcionario funcionario){
		String sql = "delete from funcionarios where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
			System.out.println("Dados removidos!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}










