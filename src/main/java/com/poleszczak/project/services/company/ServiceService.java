package com.poleszczak.project.services.company;

import com.poleszczak.project.repositories.company.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    // Get all services
    public List<com.poleszczak.project.models.company.Service> getAllServices() {
        return serviceRepository.findAll();
    }

    // Get service by ID
    public Optional<com.poleszczak.project.models.company.Service> getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId);
    }

    // Create or update a service
    public com.poleszczak.project.models.company.Service saveService(com.poleszczak.project.models.company.Service service) {
        return serviceRepository.save(service);
    }

    // Delete a service by ID
    public void deleteService(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }
}

