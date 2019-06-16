package br.com.unipe.estoque.model.enumerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.unipe.estoque.model.vo.Produto;

public enum Produtos {
	
	INSTANCE;
	
	private List<Produto> listProduto = new ArrayList<>();
	List<String> tipos = Arrays.asList("Alimento","Eletrodoméstico","Eletroportáteis","Informática");
	
	private Produtos() {
		listProduto = new ArrayList<>();
	}
	public void addProduct(Produto p){
		listProduto.add(p);
	}
	public void remove(Produto p){
		listProduto.remove(p);
	}
	public void alterar(Produto p){
		
	}
	public List<Produto> allProducts(){
		return listProduto;
	}
	public List<String> getTipos(){
		return tipos;
	}
	
}
