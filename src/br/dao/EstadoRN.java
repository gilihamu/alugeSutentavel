package br.dao;

import java.util.List;

import br.AtendimentoLugares.CidadeDAO;
import br.AtendimentoLugares.Estado;
import br.Endereco.Endereco;
import br.util.DAOFactoy;

public class EstadoRN {
	private EstadoDAO estadoDAO;

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public EstadoRN() {
		this.estadoDAO = DAOFactoy.criarEstado();

	}

	public br.AtendimentoLugares.Estado getEstado(Integer id) {
		return this.estadoDAO.getUnico(id);
	}

	public List<Estado> listar() {
		return this.estadoDAO.lista();
	}

	public Integer ultimoElementoAdicionado() {
		return this.estadoDAO.ultimoElementoAdicionado();
	}

	public void remove(Estado estado) {
		this.estadoDAO.remove(estado);
	}

	public void update(Estado estado) {
		this.estadoDAO.update(estado);
	}
	
	public void salva(Estado estado) {
		this.estadoDAO.salve(estado);
	}

	public Endereco carregaCidadeEstado(String cidade, String uf) {
		Endereco endereco = new Endereco();
		
		List<Estado> estados = estadoDAO.lista();
		for(Estado e: estados){
			if(e.getDescEstado().equals(uf)){
				endereco.setEstado(e);
			}
		}
		
		CidadeRN cidadeRN = new CidadeRN();
		endereco.setCidade(cidadeRN.pesquisaCidade(endereco.getEstado(),cidade));
		
					
		return endereco;
	}

}
