package com.example.testcontainer.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = Employee.EMPLOYEE)
public class Employee implements Serializable {
    public static final String EMPLOYEE = "employee";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = Employee.ID)
    @GeneratedValue
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = Employee.NAME)
    private String name;

    @Column(name = Employee.ADDRESS)
    private String address;
}
