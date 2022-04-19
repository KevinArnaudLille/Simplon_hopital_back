package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Service;
import com.example.demo.repository.ServiceRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ServiceController {
	@Autowired
	private ServiceRepository serviceRepository;
	
	@GetMapping("/services")
	public Iterable<Service> getService(){
		return serviceRepository.findAll();
	}
}
