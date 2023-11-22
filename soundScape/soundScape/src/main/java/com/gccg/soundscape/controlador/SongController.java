package com.gccg.soundscape.controlador;
import com.gccg.soundscape.modelos.Song;
import com.gccg.soundscape.modelos.daos.SongDao;
import java.util.List;
/**
 *
 * @author christophermaxgeorgipedrero
 */
public class SongController {

    private final SongDao dao;
    
    public SongController(){
        this.dao = new SongDao();
    }
    
    public List<Song> listarCanciones(){
        return this.dao.getSongs();
    }
    
    public void crearCancion(Song song){
        this.dao.saveSong(song);
    }
    
    public void actualizarCancion(int id, Song song){
        song.setId(id);
        this.dao.replaceSong(song);
    }
    
    public boolean eliminarCancion(int id){
        try{
            return this.dao.deleteById(id);
        }catch(Exception e){
            return false;
        }
    }
}
