package com.empmanagment.domain.employee;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false,name = "department_id")
    private Long departmantId;
    @Column
    private String departmentName;
    @ManyToOne(targetEntity = Location.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id",foreignKey = @ForeignKey(foreignKeyDefinition = "location_fk"))
    private Location location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employees;
    public Department(){
    }

    public Department(String departmentName,Location location,List<Employee> employees) {
        this.departmentName = departmentName;
        this.location = location;
        this.employees = employees;
    }

    public Long getDepartmantId() {
        return departmantId;
    }

    public void setDepartmantId(Long departmantId) {
        this.departmantId = departmantId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmantId.equals(that.departmantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmantId);
    }
}

