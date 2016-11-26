package br.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.AtendimentoLugares.Estado;
import br.dao.Dao;


public class EstadoDAO implements Dao<Estado> {
	private EntityManager session;

	public Integer ultimoElementoAdicionado() {
		String hql = "select max(idEstado) from estado";

		Query query = session.createQuery(hql);
		return (Integer) query.getResultList().get(0);

	}

	@Override
	public void salve(Estado obj) {
		session.persist(obj);
	}

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	@Override
	public void remove(Estado obj) {
		session.remove(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> lista() {
		Query query = session.createQuery(" SELECT e FROM estado e");
		return (List<Estado>) query.getResultList();
	}

	@Override
	public void update(Estado obj) {
		this.session.merge(obj);

	}

	@Override
	public Estado getUnico(int id) {

		return this.session.find(Estado.class, id);
	}

	public Estado pesquisaEstado(String uf) {
		
	
		EasyCriteria<Estado> easyCriteria = EasyCriteriaFactory.createQueryCriteria(session, Estado.class);
		easyCriteria.andEquals("descEstado", uf);

		return (Estado) easyCriteria.getSingleResult();
	}



}
