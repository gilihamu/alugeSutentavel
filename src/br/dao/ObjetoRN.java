package br.dao;

import java.util.List;

import br.AtendimentoLugares.Cidade;
import br.Objeto.CategoriaObjeto;
import br.Objeto.Objeto;
import br.util.DAOFactoy;

public class ObjetoRN {
	private ObjetoDAO objetoDAO;

	public ObjetoDAO getObjetoDAO() {
		return objetoDAO;
	}

	public void setObjetoDAO(ObjetoDAO objetoDAO) {
		this.objetoDAO = objetoDAO;
	}

	public ObjetoRN() {
		this.objetoDAO = DAOFactoy.criarObjetoDao();

	}

	public Objeto getObjeto(Integer id) {
		return this.objetoDAO.getUnico(id);
	}

	public List<Objeto> listar() {
		return this.objetoDAO.lista();
	}

	public Integer ultimoElementoAdicionado() {
		return this.objetoDAO.ultimoElementoAdicionado();
	}

	public void remove(Objeto objeto) {
		this.objetoDAO.remove(objeto);
	}

	public void update(Objeto objeto) {
		this.objetoDAO.update(objeto);
	}
	
	public void salva(Objeto objeto) {
		this.objetoDAO.salve(objeto);
	}

	public List<Objeto> listaObjetosPelaCidade(Cidade cidade, CategoriaObjeto categoriaObjeto) {
		return this.objetoDAO.listaObjetoPelaCidade(cidade, categoriaObjeto);
	}

	public Objeto cadastraObjeto(Objeto objeto) {

		this.objetoDAO.salve(objeto);
		
		return objeto;
	}

}
