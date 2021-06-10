package com.xml.test;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
//Optional: set the order of the elements
@XmlType(propOrder={"CPR", "lastName", "firstName", "zipNumber", "timeStamp"})
public class Person {

    public Person() {
        this.firstName = null;
        this.lastName = null;
        this.CPR = null;
        this.zipNumber = null;
        this.timeStamp = null;
    }

    public Person(String firstName, String lastName, String CPR, String zipNumber, String timeStamp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CPR = CPR;
        this.zipNumber = zipNumber;
        this.timeStamp = timeStamp;
    }


    private String firstName;
    private String lastName;
    private String CPR;
    private String zipNumber;
    private String timeStamp;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getCPR() { return CPR; }

    public void setCPR(String CPR) { this.CPR = CPR; }

    public String getZipNumber() { return zipNumber; }

    public void setZipNumber(String zipNumber) { this.zipNumber = zipNumber; }

    public String getTimeStamp() { return timeStamp; }

    public void setTimeStamp(String timeStamp) { this.timeStamp = timeStamp; }

    @Override
    public String toString() {
        return "Person{" +
                "CPR='" + CPR + '\'' +
                ", lastname=" + lastName +
                ", firstname=" + firstName +
                ", zip number=" + zipNumber +
                ", timeStamp=" + timeStamp +
                "}";
    }
}
