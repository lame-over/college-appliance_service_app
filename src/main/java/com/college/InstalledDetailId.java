package com.college;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InstalledDetailId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id_request", nullable = false)
    private Long idRequest;

    @Column(name = "name_of_detail", nullable = false, length = 255)
    private String nameOfDetail;

    public InstalledDetailId() {
    }

    public InstalledDetailId(Long idRequest, String nameOfDetail) {
        this.idRequest = idRequest;
        this.nameOfDetail = nameOfDetail;
    }

    public Long getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Long idRequest) {
        this.idRequest = idRequest;
    }

    public String getNameOfDetail() {
        return nameOfDetail;
    }

    public void setNameOfDetail(String nameOfDetail) {
        this.nameOfDetail = nameOfDetail;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstalledDetailId)) {
            return false;
        }
        InstalledDetailId that = (InstalledDetailId) other;
        return Objects.equals(idRequest, that.idRequest)
                && Objects.equals(nameOfDetail, that.nameOfDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRequest, nameOfDetail);
    }
}
