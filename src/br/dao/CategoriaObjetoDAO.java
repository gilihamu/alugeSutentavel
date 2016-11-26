package br.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.Objeto.CategoriaObjeto;
import br.dao.Dao;


public class CategoriaObjetoDAO implements Dao<CategoriaObjeto> {
	private EntityManager session;

	public Integer ultimoElementoAdicionado() {
		String hql = "select max(idCategoriaObjeto) from categoriaObjeto";

		Query query = session.createQuery(hql);
		return (Integer) query.getResultList().get(0);

	}

	@Override
	public void salve(CategoriaObjeto obj) {
		session.persist(obj);
	}

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	@Override
	public void remove(CategoriaObjeto obj) {
		session.remove(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoriaObjeto> lista() {
		Query query = session.createQuery(" SELECT e FROM categoriaObjeto e");
		return (List<CategoriaObjeto>) query.getResultList();
	}

	@Override
	public void update(CategoriaObjeto obj) {
		this.session.merge(obj);

	}

	@Override
	public CategoriaObjeto getUnico(int id) {

		return this.session.find(CategoriaObjeto.class, id);
	}



}
