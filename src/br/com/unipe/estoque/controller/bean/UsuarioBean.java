package br.com.unipe.estoque.controller.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.unipe.estoque.model.enumerator.Usuarios;
import br.com.unipe.estoque.model.vo.Usuario;


@ManagedBean(name = "usuarioBean")
@javax.faces.bean.ViewScoped 
public class UsuarioBean {
	
	private Usuario usuario;
	private List<Usuario> usuarioList;
	private List<Usuario> filteredUsuarioList;
	
	public UsuarioBean() {
		usuario = new Usuario(); 
	}
	public String prepararCadastro() {
		usuario = new Usuario();
		return "cadastroUsuario.jsf";
	}
	public String prepararList() {
		return "";
	}
	public String adicionarUsuario() {
		Usuarios.INSTANCE.addUser(usuario);
		return "listarUsuarios";
	}
	
	public String remove(Usuario u) {
		Usuarios.INSTANCE.remove(u);
		return "listarUsuarios";
	}
	public String alterar(Usuario u) {
		return "alterarUsuario";
	}
	public String update(Usuario u) {
		return "listarUsuarios";
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario u) {
		this.usuario = u;
	}
	@PostConstruct
	public void postConstruct() {
		usuarioList = Usuarios.INSTANCE.allUsers();
	}
	public List<Usuario> getListUsuario(){
		return usuarioList;
	}
	public List<Usuario> getFilteredUsuarioList() {
		return filteredUsuarioList;
	}
	public void setFilteredUsuarioList(List<Usuario> filteredUsuarioList) {
		this.filteredUsuarioList = filteredUsuarioList;
	}
}
