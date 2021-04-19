package com.Giz.service;

import java.util.List;

import com.Giz.data.domain.Storie;

public interface StorieService {
	
	public Storie addStorie(Storie storie) throws Exception;
	
	public List<Storie> getStorie() throws Exception;

	public List<Object[]> historiqueList();

}
