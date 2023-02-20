package com.example.Service;

import com.example.models.Department;
import com.example.repositories.DepartmentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    
    private DepartmentRepository departmentRepository;
    
    public KafkaConsumer (DepartmentRepository departmentRepository) {
    	this.departmentRepository = departmentRepository;
    }

    @KafkaListener(topics = "${topic.name}", groupId = "groupId")
    
    public void consume(Department department){
    	
        LOGGER.info(String.format("Message recieved -> %s", department));
        
        Department dep = new Department();
        dep.setId(department.getId());
        dep.setDepName(department.getDepName());
        dep.setManID(department.getManID());
        dep.setLocaID(department.getLocaID());
        
        departmentRepository.save(dep);
    }
}