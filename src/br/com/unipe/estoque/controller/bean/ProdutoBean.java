package br.com.unipe.estoque.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.unipe.estoque.model.enumerator.Produtos;
import br.com.unipe.estoque.model.vo.Produto;

@ManagedBean(name = "produtoBean")
@javax.faces.bean.ViewScoped 
public class ProdutoBean{

	private Produto produto;
	private List<Produto> produtoList;
	private List<Produto> filteredProdutoList;
	
			
	public ProdutoBean() {
		produto = new Produto(); 
	}
	public String prepararCadastro() {
		produto = new Produto();
		return "cadastroProduto.jsf";
	}
	public String prepararList() {
		return "";
	}
	public String adicionarProduto() {
		Produtos.INSTANCE.addProduct(produto);
		return "listarProdutos";
	}
	
	public String remove(Produto p) {
		Produtos.INSTANCE.remove(p);
		return "listarProdutos";
	}
	public String alterar(Produto p) {
		return "alterarProdutos";
	}
	public String update(Produto p) {
		return "listarProdutos";
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@PostConstruct
	public void postConstruct() {
		produtoList = Produtos.INSTANCE.allProducts();
	}
	public List<Produto> getListProduto(){
		return produtoList;
	}
	public List<Produto> getFilteredProdutoList() {
		return filteredProdutoList;
	}
	public void setFilteredProdutoList(List<Produto> filteredProdutoList) {
		this.filteredProdutoList = filteredProdutoList;
	}
	public List<String> getTipoList(){
		return Produtos.INSTANCE.getTipos();
	}
}
