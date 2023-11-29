package com.gccg.soundscape.modelos;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public Genere(String genero) {
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
        return this.getGenero();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Genere other = (Genere) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
