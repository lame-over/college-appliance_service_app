package com.college;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "electronics_passport")
public class ElectronicsPassport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_of_electronic", nullable = false, length = 255)
    private String nameOfElectronic;

    @Column(name = "type_of_electronic", nullable = false, length = 255)
    private String typeOfElectronic;

    @Column(name = "year_of_electronic")
    private Short yearOfElectronic;

    @OneToMany(mappedBy = "electronicsPassport")
    private List<RepairRequest> repairRequests = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfElectronic() {
        return nameOfElectronic;
    }

    public void setNameOfElectronic(String nameOfElectronic) {
        this.nameOfElectronic = nameOfElectronic;
    }

    public String getTypeOfElectronic() {
        return typeOfElectronic;
    }

    public void setTypeOfElectronic(String typeOfElectronic) {
        this.typeOfElectronic = typeOfElectronic;
    }

    public Short getYearOfElectronic() {
        return yearOfElectronic;
    }

    public void setYearOfElectronic(Short yearOfElectronic) {
        this.yearOfElectronic = yearOfElectronic;
    }

    public List<RepairRequest> getRepairRequests() {
        return repairRequests;
    }

    public void setRepairRequests(List<RepairRequest> repairRequests) {
        this.repairRequests = repairRequests;
    }
}
