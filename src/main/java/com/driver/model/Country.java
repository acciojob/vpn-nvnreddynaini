// Note: Do not write @Enumerated annotation above CountryName in this model.
package com.driver.model;

import javax.persistence.*;

@Entity
@Table
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private CountryName countryName;
    private String code;

    @ManyToOne
    @JoinColumn
    private ServiceProvider serviceProvider;

    @OneToOne(mappedBy = "country", cascade = CascadeType.ALL)
    private User user;

    public Country(Integer id, CountryName countryName, String code, ServiceProvider serviceProvider, User user) {
        this.id = id;
        this.countryName = countryName;
        this.code = code;
        this.serviceProvider = serviceProvider;
        this.user = user;
    }

    public Country(Integer id, CountryName countryName) {
        this.id = id;
        this.countryName = countryName;
    }

    public Country() {
    }

    public Country(CountryName countryName) {
        this.countryName = countryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CountryName getCountryName() {
        return countryName;
    }

    public void setCountryName(CountryName countryName) {
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
