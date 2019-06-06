package it.contrader.fitmicroservice.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Diet.
 */
@Entity
@Table(name = "diet")
public class Diet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day")
    private String day;

    @Column(name = "breakfast")
    private String breakfast;

    @Column(name = "snack")
    private String snack;

    @Column(name = "lunch")
    private String lunch;

    @Column(name = "snack_afternoon")
    private String snackAfternoon;

    @Column(name = "dinner")
    private String dinner;

    @NotNull
    @Column(name = "id_player", nullable = false)
    private Integer idPlayer;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public Diet day(String day) {
        this.day = day;
        return this;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public Diet breakfast(String breakfast) {
        this.breakfast = breakfast;
        return this;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getSnack() {
        return snack;
    }

    public Diet snack(String snack) {
        this.snack = snack;
        return this;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }

    public String getLunch() {
        return lunch;
    }

    public Diet lunch(String lunch) {
        this.lunch = lunch;
        return this;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getSnackAfternoon() {
        return snackAfternoon;
    }

    public Diet snackAfternoon(String snackAfternoon) {
        this.snackAfternoon = snackAfternoon;
        return this;
    }

    public void setSnackAfternoon(String snackAfternoon) {
        this.snackAfternoon = snackAfternoon;
    }

    public String getDinner() {
        return dinner;
    }

    public Diet dinner(String dinner) {
        this.dinner = dinner;
        return this;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public Diet idPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
        return this;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
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
        Diet diet = (Diet) o;
        if (diet.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), diet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Diet{" +
            "id=" + getId() +
            ", day='" + getDay() + "'" +
            ", breakfast='" + getBreakfast() + "'" +
            ", snack='" + getSnack() + "'" +
            ", lunch='" + getLunch() + "'" +
            ", snackAfternoon='" + getSnackAfternoon() + "'" +
            ", dinner='" + getDinner() + "'" +
            ", idPlayer=" + getIdPlayer() +
            "}";
    }
}
