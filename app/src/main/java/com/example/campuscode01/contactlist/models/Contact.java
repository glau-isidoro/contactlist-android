package com.example.campuscode01.contactlist.models;

public class Contact {

    private Long id;
    private String name;
    private String phone;

    public Contact(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
