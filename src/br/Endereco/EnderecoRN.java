package br.Endereco;

import java.util.List;

import br.util.DAOFactoy;

public class EnderecoRN {
	private EnderecoDAO enderecoDAO;

	public EnderecoRN() {
		this.enderecoDAO = DAOFactoy.criarEndereco();
	}

	public Endereco getEndereco(int id) {
		return this.enderecoDAO.getUnico(id);
	}


	public void salvar(Endereco endereco) {
		enderecoDAO.salve(endereco);
	}

	public List<Endereco> listar() {
		return this.enderecoDAO.lista();
	}

	public void atualizarEndereco(Endereco endereco) {

		this.enderecoDAO.update(endereco);
	}

}
