package practice.practice7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.practice7.repository.EnrollRepository;

@Service
public class EnrollService {

    @Autowired
    private EnrollRepository enrollRepository;
}
