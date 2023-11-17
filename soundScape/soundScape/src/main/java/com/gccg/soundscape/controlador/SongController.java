package com.gccg.soundscape.controlador;
import com.gccg.soundscape.modelos.Song;
import com.gccg.soundscape.modelos.daos.SongDao;
import java.util.List;
/**
 *
 * @author christophermaxgeorgipedrero
 */
public class SongController {
    //private Song song;
    private SongDao dao;
    
    public SongController(){
        this.dao = new SongDao();
    }
    
    public List<Song> listarCanciones(){
        return this.dao.getSongs();
    }
    
    public void crearCancion(Song song){
        this.dao.saveSong(song);
    }
}
