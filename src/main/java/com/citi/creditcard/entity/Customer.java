package com.citi.creditcard.entity;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;

@Document("customers")
public class Customer {


    @Field("customer_id")
    @Indexed(unique = true)
    @NotBlank(message = "customer id is required")
    private Integer customerId;

    @Field("first")
    @NotBlank(message = "First name is required")
    private String firstName;


    @Field("last")
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Field("gender")
    @NotBlank(message = "Gender is required")
    private String gender;

    @Field("job")
    @NotBlank(message = "JOB is required")
    private String job;

    @Field("dob")
    @NotBlank(message = "Date of Birth Required")
    private String dob;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJOB() {
        return job;
    }

    public void setJOB(String job) {
        this.job = job;
    }

    public String getDOB() {
        return dob;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return String.format("Transaction : [first= %s, last= %s, dob= %s, gender= %s, job= %s,  customer_id= %s ]",
                firstName,
                lastName,
                dob,
                gender,
                job,
                customerId
        );
    }
}



