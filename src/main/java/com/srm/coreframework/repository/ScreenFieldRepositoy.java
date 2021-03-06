package com.srm.coreframework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.srm.coreframework.entity.ScreenField;

@Repository
public interface ScreenFieldRepositoy extends JpaRepository<ScreenField, Integer> {
	
	
	@Query(value = " select s.fieldId,s.fieldName from ScreenField s where s.subScreenId =:subScreenId "
			+ " and s.activeFlag='0' and s.entityLicenseEntity.id=:entityId order by s.sequence asc")
	List<Object> getScreenFieldList(@Param("subScreenId") Integer subScreenId,@Param("entityId")  Integer entityId);
	
	

	@Query(value = " select s from ScreenField s where s.subScreenId =:subScreenAuthId and s.entityLicenseEntity.id=:entityId")
	List<ScreenField> getSubScreenFieldsEntity(@Param("subScreenAuthId") int subScreenAuthId,@Param("entityId") int entityId);
	
	
	

}
