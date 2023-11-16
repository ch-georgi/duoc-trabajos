
package com.gccg.soundscape.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "anio")
    private int anio;
    
    @Column(name = "duracion")
    private int duracion;
    
    @ManyToOne
    @JoinColumn(name = "artista", nullable=false)
    private Artist artist;
    
    @ManyToOne
    @JoinColumn(name = "genero", nullable=false)
    private Genere genere;

    //Constructores
    public Song() {
    }

    public Song(String titulo, int anio, int duracion, Artist artista, Genere genero) {
        this.titulo = titulo;
        this.anio = anio;
        this.duracion = duracion;
        this.artist = artista;
        this.genere = genero;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Artist getArtista() {
        return artist;
    }

    public void setArtista(Artist artista) {
        this.artist = artista;
    }

    public Genere getGenero() {
        return genere;
    }

    public void setGenero(Genere genero) {
        this.genere = genero;
    }
    
    @Override
    public String toString(){
        String songDetalle =
                "ID =" + this.getId() + "\n" +
                "Título =" + this.getTitulo() + "\n" +
                "Año =" + this.getAnio() + "\n" +
                "Artista =" + this.getArtista().getNombre() + "\n" +
                "Género =" + this.getGenero().getGenero() + "\n" +
                "Duración =" + this.getDuracion();
        return songDetalle;
    }
}
