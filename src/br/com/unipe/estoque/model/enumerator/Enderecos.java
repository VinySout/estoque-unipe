package br.com.unipe.estoque.model.enumerator;

import java.util.ArrayList;
import java.util.List;

import br.com.unipe.estoque.model.vo.Endereco;

public enum Enderecos {
	
	INSTANCE;
	
	private List<Endereco> listEnderecos;
	
	private Enderecos() {
		listEnderecos = new ArrayList<>();
	}
	public void addAddress(Endereco u) {
		listEnderecos.add(u);
	}
	public void remove(Endereco e) {
		listEnderecos.remove(e);
	}
	public void alterar(Endereco e) {
	}
	public List<Endereco> AllAddress(){
		return listEnderecos;
	}
}

