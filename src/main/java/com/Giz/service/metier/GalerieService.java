package com.Giz.service.metier;


import com.Giz.data.domain.Galerie;

public interface GalerieService {

	public Iterable<Galerie> getAllGalerie();

	public Galerie creategalerie(Galerie galerie) throws Exception;

	public Galerie getGalerieById(Long id) throws Exception;

	public void deleteGalerie(Long id) throws Exception;

	public void updateGalerie(Long id, String nom_album) throws Exception;
}
