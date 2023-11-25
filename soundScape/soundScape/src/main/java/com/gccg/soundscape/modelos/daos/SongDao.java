/*
 */
package com.gccg.soundscape.modelos.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gccg.soundscape.modelos.Song;
import com.gccg.soundscape.HibernateUtil;
import com.gccg.soundscape.modelos.Artist;
import com.gccg.soundscape.modelos.Genere;

/**
 *
 * @author christophermaxgeorgipedrero
 */
public class SongDao {

    public void saveSong(Song song) {
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

    public List< Song> getSongs() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Song", Song.class).list();
        } catch (Exception e) {
            return null;
        }
    }

    public List< Song> getSongsByTitulo(String titulo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Song where titulo = '" + titulo + "'", Song.class).list();
        } catch (Exception e) {
            return null;
        }
    }

    public List< Song> getSongsByTituloLike(String titulo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Song where upper(titulo) like '%" + titulo + "%'", Song.class).list();
        } catch (Exception e) {
            return null;
        }
    }

    public Song getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Song.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean deleteById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(this.getById(id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateSong(Song song) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(song);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean replaceSong(Song song) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(song);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Song> getSongByArtist(Artist artist) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Song where artist = " + artist.getId() + "", Song.class).list();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Song> getSongByGenere(Genere genere) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Song where genere = " + genere.getId() + "", Song.class).list();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Song> getSongByYear(int year) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Song where year = " + year + "", Song.class).list();
        } catch (Exception e) {
            return null;
        }
    }
}
