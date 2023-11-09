package com.parthu.service;

import org.springframework.http.ResponseEntity;

import com.parthu.binding.EmpBinding;
import com.parthu.entity.EmpEntity;

public interface EmpService {

	public String insertEmp(EmpBinding emp);
	public EmpEntity getEmpById(Integer id);
	public ResponseEntity<String> deleteEmpById(Integer id);
	public EmpEntity updateEmpById(EmpEntity emp);
}
