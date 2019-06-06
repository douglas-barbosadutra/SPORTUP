package it.contrader.usermicroservice.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A BiomedicalData.
 */
@Entity
@Table(name = "biomedical_data")
public class BiomedicalData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hearthbeat")
    private Integer hearthbeat;

    @Column(name = "blood_pressure")
    private Integer bloodPressure;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "fat_mass")
    private Integer fatMass;

    @Column(name = "fat_free_mass")
    private Integer fatFreeMass;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHearthbeat() {
        return hearthbeat;
    }

    public BiomedicalData hearthbeat(Integer hearthbeat) {
        this.hearthbeat = hearthbeat;
        return this;
    }

    public void setHearthbeat(Integer hearthbeat) {
        this.hearthbeat = hearthbeat;
    }

    public Integer getBloodPressure() {
        return bloodPressure;
    }

    public BiomedicalData bloodPressure(Integer bloodPressure) {
        this.bloodPressure = bloodPressure;
        return this;
    }

    public void setBloodPressure(Integer bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Integer getHeight() {
        return height;
    }

    public BiomedicalData height(Integer height) {
        this.height = height;
        return this;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public BiomedicalData weight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getFatMass() {
        return fatMass;
    }

    public BiomedicalData fatMass(Integer fatMass) {
        this.fatMass = fatMass;
        return this;
    }

    public void setFatMass(Integer fatMass) {
        this.fatMass = fatMass;
    }

    public Integer getFatFreeMass() {
        return fatFreeMass;
    }

    public BiomedicalData fatFreeMass(Integer fatFreeMass) {
        this.fatFreeMass = fatFreeMass;
        return this;
    }

    public void setFatFreeMass(Integer fatFreeMass) {
        this.fatFreeMass = fatFreeMass;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BiomedicalData biomedicalData = (BiomedicalData) o;
        if (biomedicalData.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), biomedicalData.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BiomedicalData{" +
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
