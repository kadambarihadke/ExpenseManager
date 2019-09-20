package com.springboot.expencemanager.Conversion;

import java.util.List;

public interface ConversionInterface<E, V> {
	
	public E translateToEntity(E entity, V dto);
	
	public V translateToDTO(E entity, V dto);
	
	public List<V> translateToDtos(List<E> entity);

}
