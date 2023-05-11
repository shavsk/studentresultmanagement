package com.student.resultmangement.service;

import com.student.resultmangement.entity.Result;
import com.student.resultmangement.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository=resultRepository;
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public void saveResult(Result result) {
        resultRepository.save(result);
    }
}
