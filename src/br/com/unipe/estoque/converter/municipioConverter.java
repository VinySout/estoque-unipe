package br.com.unipe.estoque.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.unipe.estoque.model.enumerator.Municipios;

@FacesConverter("municipioConverter")
public class municipioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			for (Municipios cidade : Municipios.values()) {
				if (value.equals(cidade.getLabel())) {
					return cidade;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			Municipios cidade = (Municipios) value;
			return cidade.getLabel();
		}
		return "";
	}
	
}
