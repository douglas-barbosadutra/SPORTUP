package it.contrader.usermicroservice.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Performance entity.
 */
public class PerformanceDTO implements Serializable {

    private Long id;

    private Integer maxCorsaMin;

    private Integer maxFlessioni;

    private Integer maxAddominali;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaxCorsaMin() {
        return maxCorsaMin;
    }

    public void setMaxCorsaMin(Integer maxCorsaMin) {
        this.maxCorsaMin = maxCorsaMin;
    }

    public Integer getMaxFlessioni() {
        return maxFlessioni;
    }

    public void setMaxFlessioni(Integer maxFlessioni) {
        this.maxFlessioni = maxFlessioni;
    }

    public Integer getMaxAddominali() {
        return maxAddominali;
    }

    public void setMaxAddominali(Integer maxAddominali) {
        this.maxAddominali = maxAddominali;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PerformanceDTO performanceDTO = (PerformanceDTO) o;
        if (performanceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), performanceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PerformanceDTO{" +
            "id=" + getId() +
            ", maxCorsaMin=" + getMaxCorsaMin() +
            ", maxFlessioni=" + getMaxFlessioni() +
            ", maxAddominali=" + getMaxAddominali() +
            "}";
    }
}
