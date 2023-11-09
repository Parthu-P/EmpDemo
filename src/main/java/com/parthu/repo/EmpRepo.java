package com.parthu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parthu.entity.EmpEntity;

public interface EmpRepo extends JpaRepository<EmpEntity, Integer> {

}
