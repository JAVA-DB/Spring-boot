package com.example.api.dto;

public class MemberDto {

    private String name;
    private String email;
    private String organization;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getOrganization(){
        return organization;
    }

    public void setOrganization(String organization){
        this.organization = organization;
    }

    @Override
    public String toString() {

        System.out.println("MemberDto{" +
                "name = '" + this.name + "'\'" +
                ", email = " + this.email + "\'" +
                ", organization = " + this.organization + "\'" +
                "}");

        return "MemberDto{" +
                "name = '" + this.name + "'\'" +
                ", email = " + this.email + "\'" +
                ", organization = " + this.organization + "\'" +
                "}";
    }
}


