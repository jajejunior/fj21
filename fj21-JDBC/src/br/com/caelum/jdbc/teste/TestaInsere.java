package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

//Teste do Insere Funcionario
public class TestaInsere {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		//insere na beans
		funcionario.setNome("Beatriz Marques");
		funcionario.setUsuario("biaques");
		funcionario.setSenha("********");
		//contato.setDataNascimento(Calendar.getInstance());
		
		//adiciona funcionario no dao
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.adicionaFuncionario(funcionario);
		System.out.println("Dados adicionados!");
	}
}


/*
 * Teste Insere Contato
public class TestaInsere {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		//insere na beans
		contato.setNome("");
		contato.setEmail("");
		contato.setEndereco("");
		contato.setDataNascimento(Calendar.getInstance());
		
		//adiciona funcionario no dao
		ContatoDAO dao = new ContatoDAO();
		dao.adicionaContato(contato);
		System.out.println("Dados adicionados!");
	}
}

*/	
