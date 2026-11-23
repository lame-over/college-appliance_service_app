package com.college;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class Detail {
    @Id
    @Column(name = "name_of_detail", nullable = false, length = 255)
    private String nameOfDetail;

    @Column(name = "accounting_unit", length = 50)
    private String accountingUnit;

    public String getNameOfDetail() {
        return nameOfDetail;
    }

    public void setNameOfDetail(String nameOfDetail) {
        this.nameOfDetail = nameOfDetail;
    }

    public String getAccountingUnit() {
        return accountingUnit;
    }

    public void setAccountingUnit(String accountingUnit) {
        this.accountingUnit = accountingUnit;
    }
}
