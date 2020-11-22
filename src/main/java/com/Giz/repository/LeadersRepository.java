package com.Giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Giz.data.domain.Leaders;

public interface LeadersRepository extends JpaRepository<Leaders, Long> {

}
