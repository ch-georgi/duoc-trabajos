
package com.gccg.soundscape.modelos.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gccg.soundscape.modelos.Artist;
import com.gccg.soundscape.HibernateUtil;

/**
 *
 * @author christophermaxgeorgipedrero
 */
public class ArtistDao {
    public void saveArtist(Artist artist) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(artist);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List < Artist > getArtists() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Artist", Artist.class).list();
        }catch(Exception e){
            return null;
        }
    }
    
    public List < Artist > getArtistByNombre(String nombre){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Artist where upper(nombre) like '%" + nombre + "%'", Artist.class).list();
        }catch(Exception e){
            return null;
        }
    }
    
    public Artist getById(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Artist.class, id);
        }catch(Exception e){
            return null;
        }
    }
    
    public Boolean deleteById(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(this.getById(id));
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public Boolean updateArtist(Artist artist){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(artist);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public Boolean replaceArtist(Artist artist){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(artist);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
