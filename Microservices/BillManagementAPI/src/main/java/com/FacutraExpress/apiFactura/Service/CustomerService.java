package com.FacutraExpress.apiFactura.Service;

import com.FacutraExpress.apiFactura.Models.Dto.CustomerDto;
import com.FacutraExpress.apiFactura.Models.Entities.Customer;
import com.FacutraExpress.apiFactura.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Customer getCustomerByEmail(String email) {
        return Optional.of(email)
                .flatMap(customerRepository::findByEmail)
                .orElse(null);
    }


    public Customer getCustomerById(Long id) {
        return Optional.of(id).flatMap(customerRepository::findById)
                .orElse(null);
    }

    public Customer saveCustomer(CustomerDto customerRequest) {
        return Optional.of(customerRequest)
                .map(this::mapToCustomer)
                .map(customerRepository::save)
                .orElseThrow(()-> new RuntimeException("Error saving customer"));
    }


    private Customer mapToCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .email(customerDto.getEmail())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .status(1)
                .numberIdentification(customerDto.getNumberIdentification())
                .build();
    }
}
