package com.Giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.SupportVideo;


public interface SupportVideoRepository extends JpaRepository<SupportVideo, Long> {	
}

