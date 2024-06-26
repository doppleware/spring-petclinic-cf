package org.springframework.samples.petclinic.adapters;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Console;

@Component
public class PetVaccinationRequestMessage {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public PetVaccinationRequestMessage(KafkaTemplate<String, String> kafkaTemplate) {

		this.kafkaTemplate = kafkaTemplate;
	}

	public void Send() {
		// template.convertAndSend("petVaccineRequests", "Hello, world!");
		try {
			kafkaTemplate.send("petVaccineRequests", "test");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
