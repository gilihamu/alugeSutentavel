package br.dao;

import java.util.List;

import br.AtendimentoLugares.Cidade;
import br.Objeto.Aluguel;
import br.util.DAOFactoy;

public class AluguelRN {
	private AluguelDAO aluguelDAO;

	public AluguelDAO getAluguelDAO() {
		return aluguelDAO;
	}

	public void setAluguelDAO(AluguelDAO aluguelDAO) {
		this.aluguelDAO = aluguelDAO;
	}

	public AluguelRN() {
		this.aluguelDAO = DAOFactoy.criarAluguel();

	}

	public Aluguel getAluguel(Integer id) {
		return this.aluguelDAO.getUnico(id);
	}

	public List<Aluguel> listar() {
		return this.aluguelDAO.lista();
	}

	public Integer ultimoElementoAdicionado() {
		return this.aluguelDAO.ultimoElementoAdicionado();
	}

	public void remove(Aluguel aluguel) {
		this.aluguelDAO.remove(aluguel);
	}

	public void update(Aluguel aluguel) {
		this.aluguelDAO.update(aluguel);
	}
	
	public void salva(Aluguel aluguel) {
		this.aluguelDAO.salve(aluguel);
	}

	public Aluguel cadastraAluguel(Aluguel aluguel) {

		this.aluguelDAO.salve(aluguel);
		
		return aluguel;
	}

}
