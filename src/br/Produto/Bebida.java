package br.Produto;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import br.Empresa.Categoria.CategoriaENUM;

@Entity(name = "bebida")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Bebida extends Produto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tamanho;
	private int estoque;

	public Bebida() {
		setQualificacao(CategoriaENUM.Bebida);
	}

	public void implementaEstoque() {
		estoque = estoque - 1;
	}

	public String getTamanho() {
		return tamanho;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public boolean isAtivo() {

		ativo = estoque > 0 ? true : false;

		return ativo;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + estoque;
		result = prime * result + ((tamanho == null) ? 0 : tamanho.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bebida other = (Bebida) obj;
		if (estoque != other.estoque)
			return false;
		if (tamanho == null) {
			if (other.tamanho != null)
				return false;
		} else if (!tamanho.equals(other.tamanho))
			return false;
		return true;
	}

	@Override
	public Object onCycleDetected(Context arg0) {
		Bebida b = new Bebida();
		b.setIdProduto(getIdProduto());
		return b;
	}
}
