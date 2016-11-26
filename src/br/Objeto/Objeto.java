package br.Objeto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.xml.bind.CycleRecoverable;

import br.Cliente.Cliente;

@Entity(name = "objeto")
public class Objeto implements Serializable, CycleRecoverable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idObjeto;
	private String nome;
	private String descricao;
	private int quantidade;
	private float valor;
	@Lob
    private byte[] imagemPrincipal;
	
	@ManyToOne
	@JoinColumn(name = "idCategoriaObjeto")
	private CategoriaObjeto categoriaObjeto;
	
	@OneToMany
	@JoinColumn(name = "idObjeto")
	private List<Aluguel> alugados;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente usuarioLocator;
	
	
	
	public byte[] getImagemPrincipal() {
		return imagemPrincipal;
	}

	public void setImagemPrincipal(byte[] imagemPrincipal) {
		this.imagemPrincipal = imagemPrincipal;
	}

	public Cliente getUsuarioLocator() {
		return usuarioLocator;
	}

	public void setUsuarioLocator(Cliente usuarioLocator) {
		this.usuarioLocator = usuarioLocator;
	}

	public int getIdObjeto() {
		return idObjeto;
	}	
		
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}



	public List<Aluguel> getAlugados() {
		return alugados;
	}


	public void setAlugados(List<Aluguel> alugados) {
		this.alugados = alugados;
	}

	public void setIdObjeto(int idObjeto) {
		this.idObjeto = idObjeto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao+" ";
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public CategoriaObjeto getCategoriaObjeto() {
		return categoriaObjeto;
	}
	public void setCategoriaObjeto(CategoriaObjeto categoriaObjeto) {
		this.categoriaObjeto = categoriaObjeto;
	}
	@Override
	public Object onCycleDetected(Context arg0) {
		Objeto ob = new Objeto();
		ob.setIdObjeto(this.idObjeto);
		return ob;
	}


	

}
