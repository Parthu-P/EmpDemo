package com.parthu.service;

import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.parthu.binding.EmpBinding;
import com.parthu.entity.EmpEntity;
import com.parthu.repo.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService {

	private Logger logger=LoggerFactory.getLogger(EmpServiceImpl.class);
	
	@Autowired
	private EmpRepo repo;

	@Override
	public String insertEmp(EmpBinding emp) {
		EmpEntity entity = new EmpEntity();
		BeanUtils.copyProperties(emp, entity);
		repo.save(entity);
		logger.info("Emp record saved");
		return "success";
	}

	@Override
	public EmpEntity getEmpById(Integer id) {
		Optional<EmpEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			EmpEntity empEntity = findById.get();
			logger.info("based on id emp record got");
			return empEntity;
		}
		logger.warn("Id not found");
		return (EmpEntity) Collections.EMPTY_LIST;
	}

	@Override
	public ResponseEntity<String> deleteEmpById(Integer id) {
	    Optional<EmpEntity> empId = repo.findById(id);
	    if (empId.isPresent()) {
	        EmpEntity empEntity = empId.get();
	        repo.delete(empEntity);
	        logger.info("based on id emp record deleted");
	        return new ResponseEntity<>("Deleted", HttpStatus.OK);
	    } else {
	    	logger.warn("Id not found");
	        return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
	    }
	}

	@Override
	public EmpEntity updateEmpById(EmpEntity entity) {
		logger.info("based on id emp record updated");
		return repo.save(entity);
	
	}

}
