package com.example.Service;

import com.example.models.Department;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
	
    @Value("${topic.name}")
    private String topicName;
    
    @Autowired
    KafkaTemplate<String, Department> kafkaTemplate;
    
    public KafkaProducer(KafkaTemplate<String, Department> kafkaTemplate) {
    	this.kafkaTemplate = kafkaTemplate;
    }
    
	public void sendData(Department data) {
		LOGGER.info(String.format("Message sent %s",  data.toString()));
		kafkaTemplate.send(topicName, data);

	}

}
