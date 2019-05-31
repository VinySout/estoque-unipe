package br.com.unipe.estoque.controller.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.unipe.estoque.model.enumerator.Enderecos;
import br.com.unipe.estoque.model.vo.Endereco;

@ManagedBean(name = "enderecoBean")
@javax.faces.bean.ViewScoped
public class EnderecoBean {
	
	private Endereco endereco;
	
	public EnderecoBean() {
		endereco = new Endereco();
	}
	public String prepararCadastro() {
		endereco = new Endereco();
		return "cadastroEndereco.jsf";
	}
	public String prepararList() {
		return "";
	}
	public String adicionarEndereco() {
		Enderecos.INSTANCE.addAddress(endereco);
		return "listarEnderecos";
	}
	
	public List<Endereco> getListEndereco(){
		return Enderecos.INSTANCE.AllAddress();
	}
	public String remove(Endereco e) {
		Enderecos.INSTANCE.remove(e);
		return "listarEnderecos";
	}
	public String alterar(Endereco e) {
		return "alterarEndereco";
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
