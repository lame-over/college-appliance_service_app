package com.college;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "repair_request")
public class RepairRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_of_request", nullable = false)
    private LocalDate dateOfRequest;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_electronics_passport", nullable = false)
    private ElectronicsPassport electronicsPassport;

    @OneToMany(mappedBy = "repairRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InstalledDetail> installedDetails = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(LocalDate dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public ElectronicsPassport getElectronicsPassport() {
        return electronicsPassport;
    }

    public void setElectronicsPassport(ElectronicsPassport electronicsPassport) {
        this.electronicsPassport = electronicsPassport;
    }

    public List<InstalledDetail> getInstalledDetails() {
        return installedDetails;
    }

    public void setInstalledDetails(List<InstalledDetail> installedDetails) {
        this.installedDetails = installedDetails;
    }
}
