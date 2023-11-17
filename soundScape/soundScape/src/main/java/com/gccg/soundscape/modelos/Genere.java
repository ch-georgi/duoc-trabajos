package com.gccg.soundscape.modelos;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "genere")
public class Genere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "genero")
    private String genero;

    @OneToMany(mappedBy = "genere", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs;

    //Constructores
    public Genere() {
    }

    public Genere(int id, String genero) {
        this.id = id;
        this.genero = genero;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song>  songs) {
        this.songs = songs;
    }
    
    @Override
    public String toString(){
        String artistDetalle =
                "ID =" + this.getId() + "\n" +
                "Nombre género =" + this.getGenero();
        return artistDetalle;
    }

}
