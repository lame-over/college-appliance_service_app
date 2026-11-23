package com.college;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "installed_details")
public class InstalledDetail {
    @EmbeddedId
    private InstalledDetailId id = new InstalledDetailId();

    @MapsId("idRequest")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_request", nullable = false)
    private RepairRequest repairRequest;

    @MapsId("nameOfDetail")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "name_of_detail", nullable = false)
    private Detail detail;

    @Column(name = "amount", nullable = false)
    private Float amount = 1.0f;

    @Column(name = "price", nullable = false, precision = 12, scale = 2)
    private BigDecimal price = BigDecimal.ZERO;

    public InstalledDetailId getId() {
        return id;
    }

    public void setId(InstalledDetailId id) {
        this.id = id;
    }

    public RepairRequest getRepairRequest() {
        return repairRequest;
    }

    public void setRepairRequest(RepairRequest repairRequest) {
        this.repairRequest = repairRequest;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
