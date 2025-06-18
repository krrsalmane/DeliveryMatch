package com.deliverymatch.model;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@NoArgsConstructor
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private DemandeStatus status;
    @Enumerated(EnumType.STRING)

    @ManyToOne
    private Annonce annonce;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DemandeStatus getStatus() {
        return status;
    }

    public void setStatus(DemandeStatus status) {
        this.status = status;
    }
}
