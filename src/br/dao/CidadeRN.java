package br.dao;

import java.util.List;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.AtendimentoLugares.CidadeDAO;
import br.AtendimentoLugares.Estado;
import br.AtendimentoLugares.Cidade;
import br.Endereco.Endereco;
import br.util.DAOFactoy;

public class CidadeRN {
	private static final String Cidade = null;
	private CidadeDAO cidadeDAO;

	public CidadeDAO getCidadeDAO() {
		return cidadeDAO;
	}

	public void setCidadeDAO(CidadeDAO cidadeDAO) {
		this.cidadeDAO = cidadeDAO;
	}

	public CidadeRN() {
		this.cidadeDAO = DAOFactoy.criarCidade();

	}

	public br.AtendimentoLugares.Cidade getCidade(Integer id) {
		return this.cidadeDAO.getUnico(id);
	}

	public List<Cidade> listar() {
		return this.cidadeDAO.lista();
	}

	public void remove(Cidade cidade) {
		this.cidadeDAO.remove(cidade);
	}

	public void update(Cidade cidade) {
		this.cidadeDAO.update(cidade);
	}
	
	public void salva(Cidade cidade) {
		this.cidadeDAO.salve(cidade);
	}

	public Cidade pesquisaCidade(Estado estado, String cidade) {

		return cidadeDAO.pesquisaCidade(estado, cidade);
	}

}

