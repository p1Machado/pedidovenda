package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.repository.CategoriaRepository;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

	private CategoriaRepository categoriaRepository;

	public CategoriaConverter() {
		categoriaRepository = CDIServiceLocator.getBean(CategoriaRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Categoria object = null;

		if (value != null) {
			Long id = new Long(value);
			object = categoriaRepository.buscarPorId(id);
			System.out.println(object);
		}

		return object;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			return ((Categoria) value).getId().toString();
		}
		return "";
	}

}
