package com.srm.coreframework.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.srm.coreframework.entity.WeekendEntity;

@Repository
public interface WeekendRepository extends JpaRepository<WeekendEntity, Serializable> {
 
	 
	
}