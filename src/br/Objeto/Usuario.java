package br.Objeto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.AtendimentoLugares.Cidade;
import br.AtendimentoLugares.Estado;
import br.Endereco.Endereco;
import br.Permissao.Permissao;

@Entity(name = "usuario")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nome;
	private String login; 
	private String email;
	private String senha;
	private String teste;
	private String telefone;
	private String celular;
	private String cpf;
	private String cnpj;
	private String ptpessoa; //f-fisica j--juridica
	private boolean ativo;
	@ManyToOne
	@JoinColumn(name = "idEndereco")
	private Endereco endereco = new Endereco();
	
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Aluguel> alugueisFeitos;

	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Objeto> ObjetosPublicados;
	
	@ManyToOne
	@JoinColumn(name = "idPermissao")
	private Permissao permissao;
	
	@ManyToOne
	@JoinColumn(name = "idCidade")
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "idEstado")
	private Estado estado;
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public Usuario() {
		ativo = true;
	}

	
	public List<Objeto> getObjetosPublicados() {
		return ObjetosPublicados;
	}

	public void setObjetosPublicados(List<Objeto> objetosPublicados) {
		ObjetosPublicados = objetosPublicados;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getPtpessoa() {
		return ptpessoa;
	}

	public void setPtpessoa(String ptpessoa) {
		this.ptpessoa = ptpessoa;
	}

	public List<Aluguel> getAlugueisFeitos() {
		return alugueisFeitos;
	}

	public void setAlugueisFeitos(List<Aluguel> alugueisFeitos) {
		this.alugueisFeitos = alugueisFeitos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idUsuario;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}
}
