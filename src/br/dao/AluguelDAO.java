package br.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.AtendimentoLugares.Cidade;
import br.Objeto.Aluguel;
import br.dao.Dao;


public class AluguelDAO implements Dao<Aluguel> {
	private EntityManager session;

	public Integer ultimoElementoAdicionado() {
		String hql = "select max(idAluguel) from aluguel";

		Query query = session.createQuery(hql);
		return (Integer) query.getResultList().get(0);

	}

	@Override
	public void salve(Aluguel obj) {
		session.persist(obj);
	}

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	@Override
	public void remove(Aluguel obj) {
		session.remove(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluguel> lista() {
		Query query = session.createQuery(" SELECT e FROM aluguel e");
		return (List<Aluguel>) query.getResultList();
	}

	@Override
	public void update(Aluguel obj) {
		this.session.merge(obj);

	}

	@Override
	public Aluguel getUnico(int id) {

		return this.session.find(Aluguel.class, id);
	}




}
