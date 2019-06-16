package br.com.unipe.estoque.model.enumerator;

import java.util.ArrayList;
import java.util.List;

import br.com.unipe.estoque.model.vo.Usuario;

public enum Usuarios {

	INSTANCE;
	
	private List<Usuario> listUsuario;
	
	private Usuarios() {
		listUsuario = new ArrayList<Usuario>();
	}
	public void addUser(Usuario u){
		listUsuario.add(u);
	}
	public void remove(Usuario u){
		listUsuario.remove(u);
	}
	public void alterar(Usuario u){
		
	}
	public List<Usuario> allUsers(){
		return listUsuario;
	}
	
}
