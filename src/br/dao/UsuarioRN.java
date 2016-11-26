package br.dao;

import java.util.List;

import br.AtendimentoLugares.CidadeDAO;
import br.AtendimentoLugares.Estado;
import br.Endereco.Endereco;
import br.Objeto.Usuario;
import br.Permissao.Permissao;
import br.Permissao.PermissaoEnum;
import br.Permissao.PermissaoRN;
import br.util.DAOFactoy;

public class UsuarioRN {
	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactoy.criarUsuario();
	}

	public Usuario getUsuario(int id) {
		return this.usuarioDAO.getUnico(id);
	}

	public void salvarLoginEmpresa(Usuario usuario) {
		PermissaoRN permissaoRN = new PermissaoRN();

		Permissao permissao = permissaoRN
				.getPermissaoByDescricao(PermissaoEnum.ROLE_ADM.name());

		usuario.setPermissao(permissao);
		this.usuarioDAO.salve(usuario);
	}

	public void salvar(Usuario usuario) {
		PermissaoRN permissaoRN = new PermissaoRN();

		Permissao permissao = permissaoRN
				.getPermissaoByDescricao(PermissaoEnum.ROLE_CLI.name());

		usuario.setPermissao(permissao);

		usuarioDAO.salve(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.lista();
	}

	public Usuario buscarPorEmail(String email) {
		return this.usuarioDAO.buscarPorEmail(email);
	}

	public boolean verificaEmailCadastrado(String email) {
		return this.usuarioDAO.verificaEmailCadastrado(email);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void atualizarUsuario(Usuario usuario) {

		this.usuarioDAO.update(usuario);
	}

	public Usuario realizarLoginUsuario(String login, String senha) {

		return this.usuarioDAO.realizarLoginUsuario(login, senha);
	}


}
