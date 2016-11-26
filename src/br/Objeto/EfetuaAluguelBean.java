package br.Objeto;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import br.beans.util.ContextUtil;
import br.dao.AluguelRN;
import br.dao.ObjetoRN;


@ManagedBean(name = "efetuaAluguelBean")
@SessionScoped
public class EfetuaAluguelBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Aluguel aluguel = new Aluguel();

	private ContextUtil contextUtil = new ContextUtil();

	
	public String verObjeto() {

		aluguel.setUsuarioLocador(contextUtil.getClienteLogado());
		//aluguel.getValorAluguelPago(aluguel.getObjeto().getValor());

		return "/paginas/publico/efetuaAluguel.jsf?faces-redirect=true";
	}
	
	public String salvarAluguel(){
		AluguelRN aluguelRN = new AluguelRN();

		//aluguel.getObjeto().setQuantidade(aluguel.getObjeto().getQuantidade()-1);
		
		aluguelRN.salva(aluguel);
		//objetoRN.salva(aluguel.getObjeto());
		
		this.aluguel = new Aluguel();
		
		return "/principal.jsf??faces-redirect=true";
	}



	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public ContextUtil getContextUtil() {
		return contextUtil;
	}

	public void setContextUtil(ContextUtil contextUtil) {
		this.contextUtil = contextUtil;
	}

}
