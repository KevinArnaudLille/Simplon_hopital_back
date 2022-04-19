package com.example.demo.routing;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class VisualisationRouter {

	@GetMapping("/services")
	public String getAllServicesData() {

		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject("http://localhost:9001/services", String.class);

		return result;
	}

}
