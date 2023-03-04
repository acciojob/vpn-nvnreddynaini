package com.driver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn
    private Admin admin;

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    private List<Connection> connectionList;

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    private List<Country> countryList;

    @ManyToMany
    @JoinColumn
    private List<User> users;

    public ServiceProvider(Integer id, String name, Admin admin, List<Connection> connectionList, List<Country> countryList, List<User> users) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.connectionList = connectionList;
        this.countryList = countryList;
        this.users = users;
    }

    public ServiceProvider() {
    }

    public ServiceProvider(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

//    public ServiceProvider get() {
//    }
}