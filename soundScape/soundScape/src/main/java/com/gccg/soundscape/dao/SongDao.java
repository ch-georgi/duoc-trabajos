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
            return session.createQuery("from S  ong", Song.class).list();
        }
    }
}
