package com.empmanagment.domain.employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long employeeId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Department.class)
    @JoinColumn(name = "department_id",foreignKey = @ForeignKey(foreignKeyDefinition = "department_fk"))
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Job.class)
    @JoinColumn(name = "job_id",foreignKey = @ForeignKey(foreignKeyDefinition = "job_fk"))
    private Job job;

    public Employee(){
    }

    public Employee(String lastName, String email, String phoneNumber, Date hireDate, Department department, Job job) {
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.department = department;
        this.job = job;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
