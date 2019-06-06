package it.contrader.usermicroservice.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Player entity.
 */
public class PlayerDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer idBiomedicalData;

    @NotNull
    private Integer idPerformance;

    @NotNull
    private Integer idUser;

    private Long biomedicalDataId;

    private Long performanceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdBiomedicalData() {
        return idBiomedicalData;
    }

    public void setIdBiomedicalData(Integer idBiomedicalData) {
        this.idBiomedicalData = idBiomedicalData;
    }

    public Integer getIdPerformance() {
        return idPerformance;
    }

    public void setIdPerformance(Integer idPerformance) {
        this.idPerformance = idPerformance;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Long getBiomedicalDataId() {
        return biomedicalDataId;
    }

    public void setBiomedicalDataId(Long biomedicalDataId) {
        this.biomedicalDataId = biomedicalDataId;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayerDTO playerDTO = (PlayerDTO) o;
        if (playerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), playerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
            "id=" + getId() +
            ", idBiomedicalData=" + getIdBiomedicalData() +
            ", idPerformance=" + getIdPerformance() +
            ", idUser=" + getIdUser() +
            ", biomedicalData=" + getBiomedicalDataId() +
            ", performance=" + getPerformanceId() +
            "}";
    }
}
