
package modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Song")
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
    
    @ManyToOne()
    @JoinColumn(name = "artista")
    private Artist artista;
    
    @ManyToOne()
    @JoinColumn(name = "genero")
    private Genere genero;

    //Constructores
    public Song() {
    }

    public Song(int id, String titulo, int anio, int duracion, Artist artista, Genere genero) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.duracion = duracion;
        this.artista = artista;
        this.genero = genero;
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
        return artista;
    }

    public void setArtista(Artist artista) {
        this.artista = artista;
    }

    public Genere getGenero() {
        return genero;
    }

    public void setGenero(Genere genero) {
        this.genero = genero;
    }
    
    
}
