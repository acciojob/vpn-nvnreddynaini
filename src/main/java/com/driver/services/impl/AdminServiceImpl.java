package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public void register(String username, String password) {
        Admin admin = new Admin(username,password);
        adminRepository1.save(admin);
    }

    @Override
    public void addServiceProvider(int adminId, String providerName) {
        ServiceProvider serviceProvider = new ServiceProvider(adminId,providerName);
        serviceProviderRepository1.save(serviceProvider);
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName){
        try{
            List<Country> countries = new ArrayList<>();
            Optional<ServiceProvider> serviceProvider = serviceProviderRepository1.findById(serviceProviderId);
            countries = serviceProvider.get().getCountryList();
            Country country = new Country(CountryName.valueOf(countryName));
            countries.add(country);
            serviceProvider.get().setCountryList(countries);
            ObjectMapper mapper = new ObjectMapper();
            ServiceProvider provider = mapper.convertValue(serviceProvider,ServiceProvider.class);
            serviceProviderRepository1.save(provider);
            return provider;
        }catch(Exception e){
            System.out.println("Error");
        }
        return null;
    }
}
