
package com.gccg.soundscape.modelos.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gccg.soundscape.modelos.Genere;
import com.gccg.soundscape.HibernateUtil;
/**
 *
 * @author christophermaxgeorgipedrero
 */
public class GenereDao {
    public void saveGenere(Genere genere) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(genere);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List < Genere > getGeneres() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Genere", Genere.class).list();
        }
    }
    
    public List < Genere > getGenereByNombre(String nombre){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Genere where genero = '" + nombre + "'", Genere.class).list();
        }
    }
    
    public Genere getById(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Genere.class, id);
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
    
    public Boolean updateGenere(Genere genere){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(genere);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public Boolean replaceGenere(Genere genere){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(genere);
            session.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
