package br.AtendimentoLugares;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "estado")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstado;
	private String descEstado;
	
	@OneToMany
	@JoinColumn(name = "idEstado")
	private List<Cidade> cidades = new ArrayList<Cidade>();

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescEstado() {
		return descEstado;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

}
