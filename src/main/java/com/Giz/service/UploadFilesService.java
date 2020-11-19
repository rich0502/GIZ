package com.Giz.service;

import java.util.List;

import com.Giz.data.domain.Uploads;;

public interface UploadFilesService {
	
	public Uploads addUploads(Uploads uploads) throws Exception;
	
	public List<Uploads> getUploads() throws Exception;
	
}
