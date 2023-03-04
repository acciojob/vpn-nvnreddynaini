package com.driver.services;

import com.driver.model.ServiceProvider;

public interface AdminService {

    public void register(String username, String password);

    public void addServiceProvider(int adminId, String providerName);

    public ServiceProvider addCountry(int serviceProviderId, String countryName);

}