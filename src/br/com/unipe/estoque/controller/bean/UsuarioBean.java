package br.com.unipe.estoque.controller.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.unipe.estoque.model.enumerator.Usuarios;
import br.com.unipe.estoque.model.vo.Usuario;



@ManagedBean(name = "usuarioBean")
@javax.faces.bean.ViewScoped 
public class UsuarioBean {
	
	private Usuario usuario;

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
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataNasc = sdf.parse(usuario.getData());
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Invalida",
					"Formato da Data Invalido (dd/MM/yyyy)");
			fc.addMessage("msgDtNasc", fm);
			return "";
		}

		Usuarios.INSTANCE.addUser(usuario);
		return "listarUsuarios";
	}
	public List<Usuario> getListUsuario() {
		return Usuarios.INSTANCE.allUsers();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
