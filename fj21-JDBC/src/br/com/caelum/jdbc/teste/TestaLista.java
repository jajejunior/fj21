package br.com.caelum.jdbc.teste;

import java.util.List;
//import br.com.caelum.jdbc.ContatoDAO;
import br.com.caelum.jdbc.FuncionarioDAO;
//import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaLista {

//Lista Funcionários
	public static void main(String args[]){
		FuncionarioDAO dao = new FuncionarioDAO();
		
		//uma lista para receber outra lista
		List<Funcionario> funcionarioList = dao.getLista();
		
		for (Funcionario funcionario : funcionarioList){
			System.out.println("Nome: "+ funcionario.getNome());
			System.out.println("Usuário: "+ funcionario.getUsuario());
			System.out.println("Senha: "+ funcionario.getSenha());
			System.out.println(" ");
		}
	}
}

/* Testa Lista Contatos
public static void main(String[] args) {
	ContatoDAO dao = new ContatoDAO();
	
	//cria uma lista de contatos recebendo o metodo getList
	List<Contato> contatoList = dao.getLista();
	
	//iterando a lista com o obj 
	for (Contato contato : contatoList){
		System.out.println("Nome: "+ contato.getNome());
		System.out.println("Email: "+ contato.getEmail());
		System.out.println("Endereço: "+ contato.getEndereco());
		System.out.println("Nascimento: "+contato.getDataNascimento().getTime());
		System.out.println(" ");
	}
}
*/