package com.apptorneo.Tournament.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inscription")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscription")
    private Long idInscription;


    @ManyToOne
    @JoinColumn(name = "id_user",insertable = false,updatable = false)
    private  User user;

    @ManyToOne
    @JoinColumn(name = "id_tournament",insertable = false,updatable = false)
    private  Tournament tournament;

    @Column(name = "created_at")
    private Date createAt;

    public Long getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(Long idInscription) {
        this.idInscription = idInscription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
