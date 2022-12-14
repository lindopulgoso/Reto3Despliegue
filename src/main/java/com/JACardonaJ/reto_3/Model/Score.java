package com.JACardonaJ.reto_3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Idscore ;
    private  String messageText ;
    private Integer stars;
    @OneToOne
    @JsonIgnoreProperties("score")
    private  Reservation reservation ;

    public Integer getIdscore() {
        return Idscore;
    }

    public void setIdscore(Integer idscore) {
        Idscore = idscore;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
