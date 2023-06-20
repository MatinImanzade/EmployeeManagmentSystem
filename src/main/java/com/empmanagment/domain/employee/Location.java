package com.empmanagment.domain.employee;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id", unique = true, nullable = false)
    private Long locationId;

    @Column(name = "street_adress")
    private String streetAdress;
    @Column
    private String city;
    @Column
    private int postalCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<Department> departments;

    public Location() {
    }

    public Location(String streetAdress, String city, int postalCode) {
        this.streetAdress = streetAdress;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return postalCode == location.postalCode && Objects.equals(locationId, location.locationId) && Objects.equals(streetAdress, location.streetAdress) && Objects.equals(city, location.city) && Objects.equals(departments, location.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, streetAdress, city, postalCode, departments);
    }
}
