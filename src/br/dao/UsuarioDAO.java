package br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.Objeto.Usuario;

public class UsuarioDAO implements Dao<Usuario> {
	private EntityManager session;

	public EntityManager getSession() {
		return session;
	}

	public void startConnection() {
		session.getTransaction().begin();
	}

	public void closeConnection() {
		session.getTransaction().commit();
		session.close();
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	public Usuario buscarPorEmail(String email) {
		
		EasyCriteria<Usuario> easyCriteria = EasyCriteriaFactory
				.createQueryCriteria(session, Usuario.class);
		
		easyCriteria.andEquals("email", email);

		
		List<Usuario> usuarios = easyCriteria.getResultList();

		if (usuarios.isEmpty()) {
			return null;
		} else {
			return usuarios.get(0);
		}

	}

	public boolean verificaEmailCadastrado(String email) {
		EasyCriteria<Usuario> easyCriteria = EasyCriteriaFactory
				.createQueryCriteria(session, Usuario.class);
		if (email != null) {
			easyCriteria.andEquals("email", email);
		}

		if (easyCriteria.getResultList().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public Usuario buscarPorLogin(String login) { // TODO Auto-generated
		String hql = "select u from usuario u where u.login = :login";
		@SuppressWarnings("unused")
		Query consulta = this.session.createQuery(hql);
		// consulta.setString("login", login);
		return null;// (Usuario) consulta.uniqueResult();
	}

	@Override
	public void salve(Usuario obj) {
		session.persist(obj);

	}

	@Override
	public void remove(Usuario obj) {
		this.session.remove(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> lista() {
		Query query = session.createQuery(" SELECT e FROM usuario e");
		return (List<Usuario>) query.getResultList();
	}

	@Override
	public void update(Usuario obj) {
		session.merge(obj);
	}

	@Override
	public Usuario getUnico(int id) {

		return this.session.find(Usuario.class, id);
	}

	public Usuario realizarLoginUsuario(String login, String senha) {

		EasyCriteria<Usuario> easyCriteria = EasyCriteriaFactory
				.createQueryCriteria(session, br.Objeto.Usuario.class);
		easyCriteria.andEquals("email", login).andEquals("senha", senha);

		return easyCriteria.getSingleResult();
	}
}
