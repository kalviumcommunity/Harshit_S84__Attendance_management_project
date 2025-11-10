package com.school;

public class Staff extends Person implements Storable { // Implements Storable
    private String role;

    public Staff(String name, String role) {
        super(name);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Role: " + role + " (Role: Non-Teaching Staff)");
    }

    @Override
    public String toDataString() {
        // Format: id,name,role
        return getId() + "," + getName() + "," + role;
    }
}