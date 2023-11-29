package com.gccg.soundscape.controlador;

import com.gccg.soundscape.modelos.Genere;
import com.gccg.soundscape.modelos.daos.GenereDao;
import java.util.List;

/**
 *
 * @author christophermaxgeorgipedrero
 */
public class GenereController {
    private final GenereDao dao;

    public GenereController() {
        this.dao = new GenereDao();
    }
    
    public List<Genere> listarGeneros(){
        return this.dao.getGeneres();
    }
    
    public void crearGenero(Genere Genere){
        this.dao.saveGenere(Genere);
    }
    
    public void actualizarGenero(Genere Genere){
        this.dao.replaceGenere(Genere);
    }
    
    public boolean eliminarGenero(int id){
        try{
            return this.dao.deleteById(id);
        }catch(Exception e){
            return false;
        }
    }
    
    public Genere buscarGeneroPorId(int id){
        try{
            return this.dao.getById(id);
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Genere> buscarGeneroPorNombre(String nombre){
        try{
            return this.dao.getGenereByNombre(nombre);
        }catch(Exception e){
            return null;
        }
    }
}
