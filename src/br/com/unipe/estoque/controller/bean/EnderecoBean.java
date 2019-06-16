package br.com.unipe.estoque.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import br.com.unipe.estoque.model.enumerator.Enderecos;
import br.com.unipe.estoque.model.enumerator.Estados;
import br.com.unipe.estoque.model.enumerator.Municipios;
import br.com.unipe.estoque.model.vo.Endereco;

@ManagedBean(name = "enderecoBean")
@javax.faces.bean.ViewScoped
public class EnderecoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Endereco endereco;
	private Estados selectEstado;
	private List<Endereco> enderecoList;
	private List<Endereco> filteredEnderecoList;
	private List<SelectItem> listEstados;
	private List<SelectItem> listMunicipios;
	
	
	public EnderecoBean() {
		endereco = new Endereco();
		listMunicipios = new ArrayList<>();
		listEstados = new ArrayList<>();
	}
	
	public void carregarMunicipios() {
		listMunicipios = new ArrayList<>();
		for (Municipios municipios : Municipios.values()) {
			if (selectEstado.name().equals(municipios.getEstado()))
				listMunicipios.add(new SelectItem(municipios, municipios.getLabel()));
		}

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
	
	public String remove(Endereco e) {
		Enderecos.INSTANCE.remove(e);
		return "listarEnderecos";
	}
	
	public String alterar(Endereco e) {
		return "alterarEndereco";
	}
	
	public String update(Endereco e) {
		return "listarEnderecos";
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<SelectItem> getListMunicipios() {
		return listMunicipios;
	}

	public void setListMunicipios(List<SelectItem> listMunicipios) {
		this.listMunicipios = listMunicipios;
	}
	public List<SelectItem> getListEstados() {
		return listEstados;
	}

	public void setListEstados(List<SelectItem> listEstados) {
		this.listEstados = listEstados;
	}
	public Estados getSelectEstado() {
		return selectEstado;
	}

	public void setSelectEstado(Estados selectEstado) {
		this.selectEstado = selectEstado;
	}
	@PostConstruct
	public void postConstruct() {
		enderecoList = Enderecos.INSTANCE.AllAddress();
		listMunicipios = new ArrayList<>();
		for (Municipios municipios : Municipios.values()) {
			listMunicipios.add(new SelectItem(municipios, municipios.getLabel()));
		}

		listEstados = new ArrayList<>();
		for (Estados estados : Estados.values()) {
			listEstados.add(new SelectItem(estados, estados.getLabel()));
		}
		
	}
	public List<Endereco> getListEndereco(){
		return enderecoList;
	}
	public List<Endereco> getFilteredEnderecoList() {
		return filteredEnderecoList;
	}
	public void setFilteredEnderecoList(List<Endereco> filteredEnderecoList) {
		this.filteredEnderecoList = filteredEnderecoList;
	}
	
}
