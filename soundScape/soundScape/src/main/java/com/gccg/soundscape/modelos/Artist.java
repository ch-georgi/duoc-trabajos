package com.gccg.soundscape.modelos;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs;

    //Constructores
    public Artist() {
    }

    public Artist(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Artist(String nombre) {
        this.nombre = nombre;
    }
    
    

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song>  songs) {
        this.songs = songs;
    }
    
    @Override
    public String toString(){
        return this.getNombre();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Artist other = (Artist) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
