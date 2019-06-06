package it.contrader.usermicroservice.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the BiomedicalData entity.
 */
public class BiomedicalDataDTO implements Serializable {

    private Long id;

    private Integer hearthbeat;

    private Integer bloodPressure;

    private Integer height;

    private Integer weight;

    private Integer fatMass;

    private Integer fatFreeMass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHearthbeat() {
        return hearthbeat;
    }

    public void setHearthbeat(Integer hearthbeat) {
        this.hearthbeat = hearthbeat;
    }

    public Integer getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Integer bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getFatMass() {
        return fatMass;
    }

    public void setFatMass(Integer fatMass) {
        this.fatMass = fatMass;
    }

    public Integer getFatFreeMass() {
        return fatFreeMass;
    }

    public void setFatFreeMass(Integer fatFreeMass) {
        this.fatFreeMass = fatFreeMass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BiomedicalDataDTO biomedicalDataDTO = (BiomedicalDataDTO) o;
        if (biomedicalDataDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), biomedicalDataDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BiomedicalDataDTO{" +
            "id=" + getId() +
            ", hearthbeat=" + getHearthbeat() +
            ", bloodPressure=" + getBloodPressure() +
            ", height=" + getHeight() +
            ", weight=" + getWeight() +
            ", fatMass=" + getFatMass() +
            ", fatFreeMass=" + getFatFreeMass() +
            "}";
    }
}
