package br.Objeto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.sun.xml.bind.CycleRecoverable;
import com.sun.xml.bind.CycleRecoverable.Context;

import br.Pedido.Pedido;


@Entity(name = "categoria_objeto")
public class CategoriaObjeto implements Serializable, CycleRecoverable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoriaObjeto;
	private String descricao;
	
	
	public int getIdCategoriaObjeto() {
		return idCategoriaObjeto;
	}
	
	@OneToMany
	@JoinColumn(name = "idCategoriaObjeto")
	private List<Objeto> objetos;
	
	public List<Objeto> getObjetos() {
		return objetos;
	}
	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}
	public void setIdCategoriaObjeto(int idCategoriaObjeto) {
		this.idCategoriaObjeto = idCategoriaObjeto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public Object onCycleDetected(Context arg0) {
		
		CategoriaObjeto categoriaObjeto = new CategoriaObjeto();
		categoriaObjeto.setIdCategoriaObjeto(this.idCategoriaObjeto);
		
		return categoriaObjeto;
	}
	
	
	



}
