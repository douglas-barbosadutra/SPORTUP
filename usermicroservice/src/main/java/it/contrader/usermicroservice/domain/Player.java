package it.contrader.usermicroservice.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Player.
 */
@Entity
@Table(name = "player")
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private BiomedicalData biomedicalData;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Performance performance;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Player idUser(Integer idUser) {
        this.idUser = idUser;
        return this;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public BiomedicalData getBiomedicalData() {
        return biomedicalData;
    }

    public Player biomedicalData(BiomedicalData biomedicalData) {
        this.biomedicalData = biomedicalData;
        return this;
    }

    public void setBiomedicalData(BiomedicalData biomedicalData) {
        this.biomedicalData = biomedicalData;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Player performance(Performance performance) {
        this.performance = performance;
        return this;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
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
        Player player = (Player) o;
        if (player.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), player.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Player{" +
            "id=" + getId() +
            ", idUser=" + getIdUser() +
            "}";
    }
}
