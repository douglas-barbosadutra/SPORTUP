package it.contrader.usermicroservice.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Performance.
 */
@Entity
@Table(name = "performance")
public class Performance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "max_corsa_min")
    private Integer maxCorsaMin;

    @Column(name = "max_flessioni")
    private Integer maxFlessioni;

    @Column(name = "max_addominali")
    private Integer maxAddominali;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaxCorsaMin() {
        return maxCorsaMin;
    }

    public Performance maxCorsaMin(Integer maxCorsaMin) {
        this.maxCorsaMin = maxCorsaMin;
        return this;
    }

    public void setMaxCorsaMin(Integer maxCorsaMin) {
        this.maxCorsaMin = maxCorsaMin;
    }

    public Integer getMaxFlessioni() {
        return maxFlessioni;
    }

    public Performance maxFlessioni(Integer maxFlessioni) {
        this.maxFlessioni = maxFlessioni;
        return this;
    }

    public void setMaxFlessioni(Integer maxFlessioni) {
        this.maxFlessioni = maxFlessioni;
    }

    public Integer getMaxAddominali() {
        return maxAddominali;
    }

    public Performance maxAddominali(Integer maxAddominali) {
        this.maxAddominali = maxAddominali;
        return this;
    }

    public void setMaxAddominali(Integer maxAddominali) {
        this.maxAddominali = maxAddominali;
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
        Performance performance = (Performance) o;
        if (performance.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), performance.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Performance{" +
            "id=" + getId() +
            ", maxCorsaMin=" + getMaxCorsaMin() +
            ", maxFlessioni=" + getMaxFlessioni() +
            ", maxAddominali=" + getMaxAddominali() +
            "}";
    }
}
