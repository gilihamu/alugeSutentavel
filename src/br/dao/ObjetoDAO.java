package br.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.AtendimentoLugares.Cidade;
import br.Objeto.CategoriaObjeto;
import br.Objeto.Objeto;
import br.dao.Dao;


public class ObjetoDAO implements Dao<Objeto> {
	private EntityManager session;

	public Integer ultimoElementoAdicionado() {
		String hql = "select max(idObjeto) from objeto";

		Query query = session.createQuery(hql);
		return (Integer) query.getResultList().get(0);

	}

	@Override
	public void salve(Objeto obj) {
		session.persist(obj);
	}

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	@Override
	public void remove(Objeto obj) {
		session.remove(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Objeto> lista() {
		Query query = session.createQuery(" SELECT e FROM objeto e");
		return (List<Objeto>) query.getResultList();
	}

	@Override
	public void update(Objeto obj) {
		this.session.merge(obj);

	}

	@Override
	public Objeto getUnico(int id) {

		return this.session.find(Objeto.class, id);
	}

	public List<Objeto> listaObjetoPelaCidade(Cidade cidade, CategoriaObjeto categoriaObjeto) {
		
		EasyCriteria<Objeto> easyCriteria = EasyCriteriaFactory.createQueryCriteria(session, Objeto.class);
			easyCriteria.andGreaterThan("quantidade", 0);
//		easyCriteria.leftJoin("categoriaObjeto").andEquals("categoriaObjeto.idCategoriaObjeto", categoriaObjeto.getIdCategoriaObjeto());
		
	    List<Objeto> objetosAt = easyCriteria.getResultList();

/*		Query query = session.createQuery(" SELECT e FROM empresa e");
		List<Empresa> objetosA2t = (List<Empresa>) query.getResultList();
		
		Query query1 = session.createQuery(" SELECT e FROM objeto e");
		List<Objeto> objetosAt = (List<Objeto>) query1.getResultList();*/

		List<Objeto> objetos = new ArrayList<Objeto>();
		for (Objeto objeto : objetosAt) {
			objetos.add(objeto);
		}
		return objetos;
	}


}
