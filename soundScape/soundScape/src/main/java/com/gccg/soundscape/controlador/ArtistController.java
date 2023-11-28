package com.gccg.soundscape.controlador;

import com.gccg.soundscape.modelos.Artist;
import com.gccg.soundscape.modelos.daos.ArtistDao;
import java.util.List;

/**
 *
 * @author christophermaxgeorgipedrero
 */
public class ArtistController {
    private final ArtistDao dao;

    public ArtistController() {
        this.dao = new ArtistDao();
    }
    
    public List<Artist> listarArtistas(){
        return this.dao.getArtists();
    }
    
    public void crearArtista(Artist artist){
        this.dao.saveArtist(artist);
    }
    
    public void actualizarArtista(Artist artist){
        this.dao.replaceArtist(artist);
    }
    
    public boolean eliminarArtista(int id){
        try{
            return this.dao.deleteById(id);
        }catch(Exception e){
            return false;
        }
    }
    
    public Artist buscarArtistaPorId(int id){
        try{
            return this.dao.getById(id);
        }catch(Exception e){
            return null;
        }
    }
}
