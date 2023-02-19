package com.telemed.telemed.model;


import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Record {

    @Id
    @GeneratedValue()
    private Long id;
    private int sisTlak;

    Date date;

    private int dijTlak;

    private int bpm;

    private String opisStanja;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Record() {

    }

    public Record(Date date, User user, int sisTlak, int dijTlak, int bpm, String opisStanja) {
        this.date = date;
        this.user = user;
        this.sisTlak = sisTlak;
        this.dijTlak = dijTlak;
        this.bpm = bpm;
        this.opisStanja = opisStanja;
    }

    public int getSisTlak() {
        return sisTlak;
    }

    public void setSisTlak(int sisTlak) {
        this.sisTlak = sisTlak;
    }

    public int getDijTlak() {
        return dijTlak;
    }

    public void setDijTlak(int dijTlak) {
        this.dijTlak = dijTlak;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public String getOpisStanja() {
        return opisStanja;
    }

    public void setOpisStanja(String opisStanja) {
        this.opisStanja = opisStanja;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
