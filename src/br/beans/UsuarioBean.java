package br.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.util.DigestUtils;

import br.AtendimentoLugares.Bairro;
import br.Empresa.Empresa;
import br.Empresa.EmpresaRN;
import br.Endereco.Endereco;
import br.Objeto.Usuario;
import br.beans.menssagem.Menssagem;
import br.dao.EstadoRN;
import br.dao.UsuarioDAO;
import br.dao.UsuarioRN;
import br.util.Email.Email;
import br.util.Email.EmailDestino;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private DataModel<Usuario> listaUsuario;
	private String email = null;
	private String bairro;
	private String cidade;
	private String uf;
	
	


	public UsuarioBean() {
		usuario = new Usuario();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		if (this.usuario == null || !login.equals(this.usuario.getEmail())) {

			if (login != null) {
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuario = usuarioRN.buscarPorEmail(login);
			}
		}
		return usuario;
	}

	public void preparaAdicionarUsuario() {
		usuario = new Usuario();
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public DataModel<Usuario> getListaUsuario() {
		List<Usuario> lista = new UsuarioDAO().lista();
		listaUsuario = new ListDataModel<Usuario>(lista);
		return listaUsuario;
	}

	public void setListaUsuario(DataModel<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public String cancelar() {
		usuario = new Usuario();
		return "cadastroUsuario.jsf?faces-redirect=true";
	}




	public String salvar() {

		

			UsuarioRN usuarioRN = new UsuarioRN();
			EstadoRN estadoRN = new EstadoRN();
			//En

			if (usuarioRN.verificaEmailCadastrado(usuario.getEmail())) {

				String senha = this.usuario.getSenha();

				String senhaCripto = DigestUtils.md5DigestAsHex(senha
						.getBytes());

				this.usuario.setSenha(senhaCripto);
				
				Endereco endereco = new Endereco();
				endereco = estadoRN.carregaCidadeEstado(cidade,uf);
				usuario.getEndereco().setEstado(endereco.getEstado());
				usuario.getEndereco().setCidade(endereco.getCidade());

				usuarioRN.salvar(usuario);
				

				emailCadastro(senha);
				return "login.jsf?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"E-mail já foi Cadastrado!!",
								"Informe outro E-mail"));
				return null;
			}
		
	}

	public String alterarUsuario() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		if (this.usuario == null || !login.equals(this.usuario.getEmail())) {

			if (login != null) {
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuario = usuarioRN.buscarPorEmail(login);
				return "/paginas/publico/alterarUsuario.jsf?faces-redirect=true";
			}
		}
		
		
		return "login.jsf?faces-redirect=true";
	}

	public String atualizarSalvarUsuario() {
		String senha = this.usuario.getSenha();
		String senhaCripto = DigestUtils.md5DigestAsHex(senha.getBytes());
		this.usuario.setSenha(senhaCripto);
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.atualizarUsuario(usuario);
		return "login.jsf?faces-redirect=true";
	}

	public void emailCadastro(String senha) {
		String mensagem = Menssagem.cadastro(usuario.getNome(),
				usuario.getEmail(), senha);
		EmailDestino emailDestino = new EmailDestino();
		emailDestino.setEmail(usuario.getEmail());
		emailDestino.setNome(usuario.getNome());
		emailDestino.setMensagem(mensagem);
		emailDestino.setAssunto("Cadastro realizado com Sucesso");
		sendEmail(emailDestino);
	}

	public void sendEmail(EmailDestino emailDestino) {

		Email enviarEmail = new Email(emailDestino);
		enviarEmail.sendEmail();
	}

	public void emailEsqueciMinhaSenha() {
		String senha = gerarSenhaAleatoria();

		String menssagem;

		menssagem = Menssagem.recuperarSenha(usuario.getNome(),
				usuario.getEmail(), senha);
		senha = DigestUtils.md5DigestAsHex(senha.getBytes());
		usuario.setSenha(senha);

		String htmlInicio = "<html> <head></head><body>";
		String htmlFim = " </body></html>";

		EmpresaRN empresaRN = new EmpresaRN();
		List<Empresa> empresas = empresaRN.listar();

		menssagem = "______________________________________";
		for (Empresa e : empresas) {
			menssagem += "<br/>| " + e.getNomeFant() + "|";
		}

		menssagem = htmlInicio + menssagem + htmlFim;
		EmailDestino emailDestino = new EmailDestino();
		emailDestino.setEmail(usuario.getEmail());
		emailDestino.setNome(usuario.getNome());
		emailDestino.setMensagem(menssagem);
		emailDestino.setAssunto("Nova Senha");
		sendEmail(emailDestino);
	}

	public String gerarSenhaAleatoria() {
		int cont = 0, b = 0, c = 0, num = 0;
		String i = "";
		String[] Vetor = new String[7];

		String[] ArrayString = { "2", "4", "5", "6", "7", "8", "9", "0", "1",
				"3", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "l",
				"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "w",
				"y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X",
				"W", "Y", "Z" };

		for (c = 0; c < 4; c++) {
			num = (int) (Math.random() * 10);

			cont = (int) (Math.random() * ArrayString.length);

			for (b = 0; b <= ArrayString.length; b++) {

				if (b == cont)
					i = ArrayString[b];

			}

			Vetor[c] = (i += num);
			i = "";
			num = 0;
		}

		String senha = "";
		String p1 = "";
		String p2 = "";
		String p3 = "";
		String p4 = "";

		p1 = Vetor[0];
		p2 = Vetor[1];
		p3 = Vetor[2];
		p4 = Vetor[3];

		senha += p1 + p2 + p3 + p4;

		return senha;
	}

	public void esqueciMinhaSenha(ActionEvent actionEvent) {
		;
		try {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.usuario = usuarioRN.buscarPorEmail(email);
			emailEsqueciMinhaSenha();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"E-mail enviado com sucesso!!", ""));
		} catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Login não encontrado!!", ""));
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
