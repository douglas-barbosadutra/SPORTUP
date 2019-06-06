package it.contrader.fitmicroservice.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Diet entity.
 */
public class DietDTO implements Serializable {

    private Long id;

    private String day;

    private String breakfast;

    private String snack;

    private String lunch;

    private String snackAfternoon;

    private String dinner;

    @NotNull
    private Integer idPlayer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getSnackAfternoon() {
        return snackAfternoon;
    }

    public void setSnackAfternoon(String snackAfternoon) {
        this.snackAfternoon = snackAfternoon;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DietDTO dietDTO = (DietDTO) o;
        if (dietDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dietDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DietDTO{" +
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
