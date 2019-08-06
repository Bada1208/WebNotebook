package com.sysoiev.model;

public class Contact {

    private int id;
    private String surname;
    private String name;
    private String phoneNumber;
    private int age;

    public Contact() {

    }

    public Contact(int id, String surname, String name, String phoneNumber, int age) {
        if (id > 0 && surname != null && !surname.isEmpty() && name != null && !name.isEmpty() && phoneNumber != null
                && !phoneNumber.isEmpty() && age > 0) {
            this.id = id;
            this.surname = surname;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.age = age;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }


}
