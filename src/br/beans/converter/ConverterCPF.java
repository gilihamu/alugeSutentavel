package br.beans.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="converterCPF")  
public class ConverterCPF implements Converter, Serializable {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override  
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {  
        if(valor != null || valor != "") {  
            valor = valor.toString().replaceAll("[- /.]", "");  
            valor = valor.toString().replaceAll("[-()]", "");  
        }  
        return valor;  
    }  
  
    @Override  
    public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {  
        return valor.toString();  
    }  
}  
