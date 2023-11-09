package com.parthu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parthu.binding.EmpBinding;
import com.parthu.entity.EmpEntity;
import com.parthu.service.EmpService;

@RestController
public class EmpRest {

	@Autowired
	private EmpService service;

	@PostMapping("/add")
	public ResponseEntity<String> insertEmp(@RequestBody EmpBinding emp) {
		String s = service.insertEmp(emp);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<EmpEntity> getEmp(@PathVariable Integer id) {
		EmpEntity entity = service.getEmpById(id);
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
	    ResponseEntity<String> deleteEmpResponse = service.deleteEmpById(id);
	    return deleteEmpResponse;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmpEntity> updateEmp(@RequestBody EmpEntity entity,@PathVariable Integer id){
		entity.setId(id);
		service.updateEmpById(entity);
		return new ResponseEntity<>(entity,HttpStatus.CREATED);
	}

}
