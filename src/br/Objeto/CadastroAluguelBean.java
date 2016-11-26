package br.Objeto;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.Cliente.ClienteRN;
import br.beans.util.ContextUtil;
import br.dao.ObjetoRN;
import br.util.FileUpload;

@ManagedBean(name = "cadastroAluguelBean")
@SessionScoped
public class CadastroAluguelBean {
	private Objeto objeto;
	private Aluguel aluguel;
	private FileUpload arquivo = new FileUpload();

	private ContextUtil contextUtil = new ContextUtil();
	private UploadedFile file;

	@PostConstruct
	public void construct() {
		this.objeto = new Objeto();
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void handleFileUpload(FileUploadEvent event) {
		this.objeto.setImagemPrincipal(event.getFile().getContents());
		this.arquivo.fileUpload(event);
	}

	public String cadastraObjeto() {
		ObjetoRN objetoRN = new ObjetoRN();
		
		this.objeto.setUsuarioLocator(contextUtil.getClienteLogado());
		this.objeto = objetoRN.cadastraObjeto(objeto);

		this.arquivo.gravarArquivoTomCat("objetos/", "" + objeto.getIdObjeto());

		this.arquivo.gravarArquivoProjeto("objetos/",""  + objeto.getIdObjeto());
		
		this.objeto = new Objeto();

		return "/principal.jsf??faces-redirect=true";

	}
	
	public String verObjeto() {

		aluguel = new Aluguel();
		aluguel.setObjeto(objeto);
		aluguel.setUsuarioLocador(contextUtil.getClienteLogado());

		return "/paginas/publico/efetuaAlugeul.jsf";
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public ContextUtil getContextUtil() {
		return contextUtil;
	}

	public void setContextUtil(ContextUtil contextUtil) {
		this.contextUtil = contextUtil;
	}

}
