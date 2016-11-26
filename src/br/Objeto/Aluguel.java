package br.Objeto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.Cliente.Cliente;

@Entity(name = "aluguel")
public class Aluguel {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAluguel;
	private String descricao;
	private String valorAluguelPago; //n --não pago s--pago a--aguardando confirmação
	private String valorCacaoPago; //n --não pago s--pago a--aguardando confirmação
	private Date dataInicio;
	private Date dataFim;
	private int quantidade;
	private String situacao; //A--ativo m--EM em medicacao EA--- com atraso D--devolvido
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "idObjeto")
	private Objeto objeto;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente usuarioLocador;

	public int getIdAluguel() {
		return idAluguel;
	}

	public void setIdAluguel(int idAluguel) {
		this.idAluguel = idAluguel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValorAluguelPago() {
		return valorAluguelPago;
	}

	public void setValorAluguelPago(String valorAluguelPago) {
		this.valorAluguelPago = valorAluguelPago;
	}

	public String getValorCacaoPago() {
		return valorCacaoPago;
	}

	public void setValorCacaoPago(String valorCacaoPago) {
		this.valorCacaoPago = valorCacaoPago;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public Cliente getUsuarioLocador() {
		return usuarioLocador;
	}

	public void setUsuarioLocador(Cliente usuarioLocador) {
		this.usuarioLocador = usuarioLocador;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


}
