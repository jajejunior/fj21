package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaRemove{
	public static void main(String args[]){
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId((long) 1 );
		
		//pega o funcionario e joga no método remove do DAO
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.removeFuncionario(funcionario);
	}
}


/*
public class TestaRemove {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setId((long) 2);
		
		ContatoDAO dao = new ContatoDAO();
		dao.removeContato(contato);
	}
}
*/