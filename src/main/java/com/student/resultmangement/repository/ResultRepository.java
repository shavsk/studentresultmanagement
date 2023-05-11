package com.student.resultmangement.repository;

import com.student.resultmangement.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Integer> {

}
