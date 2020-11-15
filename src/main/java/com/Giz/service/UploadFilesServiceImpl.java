package com.Giz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Giz.data.domain.Uploads;
import com.Giz.repository.UploadsRepository;;

@Service
@Transactional
public class UploadFilesServiceImpl implements UploadFilesService {

	@Autowired
	private UploadsRepository uploadsRepository;
	
	@Override
	public Uploads addUploads(Uploads uploads) throws Exception {
		return uploads = uploadsRepository.save(uploads);
	}

	@Override
	public List<Uploads> getUploads() throws Exception {
		List<Uploads> list = uploadsRepository.ListUploads();
		return list;
	}


}
