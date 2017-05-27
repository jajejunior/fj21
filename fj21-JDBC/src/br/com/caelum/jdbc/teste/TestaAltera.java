package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

//Testa Altera Funcionário
public class TestaAltera {
	public static void main(String[] args) {
		
		//Instancie um funcionario, sete tudo e jogue o objeto no dao
		Funcionario funcionario= new Funcionario();
		
		funcionario.setNome("Beatriz Marques da Silva");
		funcionario.setUsuario("Biaques");
		funcionario.setSenha("********");
		funcionario.setId((long) 1 );
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.alteraFuncionario(funcionario);
	}
}


/*Testa Altera Contato
public class TestaAltera {

	public static void main(String[] args) {
		Contato contato = new Contato();
		
		contato.setNome("");
		contato.setEndereco("");
		contato.setEmail("");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId((long) 2);
		
		ContatoDAO dao = new ContatoDAO();
		dao.alteraContato(contato);
	}
}
*/