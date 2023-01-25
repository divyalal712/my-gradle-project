package no.training.project.model;

import java.util.List;

public class EmpClass {
    private String name;
    private int id;
    private Address address;
    private int salary;
    private List<String> phoneNumber;

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EmpClass(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public EmpClass(String name, int id, Address address, List<String> phoneNumber) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "EmpClass{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address=" + address +
                ", salary=" + salary +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
