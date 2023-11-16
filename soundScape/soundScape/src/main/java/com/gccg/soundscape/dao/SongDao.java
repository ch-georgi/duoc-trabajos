/*
 */
package com.gccg.soundscape.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gccg.soundscape.modelos.Song;
import com.gccg.soundscape.HibernateUtil;

/**
 *
 * @author christophermaxgeorgipedrero
 */
public class SongDao {
    public void saveStudent(Song song) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(song);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List < Song > getSongs() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Song", Song.class).list();
        }
    }
    
    public List < Song > getSongsByTitulo(String titulo){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Song where titulo = '" + titulo + "'", Song.class).list();
        }
    }
    
    public Song getById(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Song.class, id);
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
    
    public Boolean updateSong(Song song){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(song);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public Boolean replaceSong(Song song){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(song);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
