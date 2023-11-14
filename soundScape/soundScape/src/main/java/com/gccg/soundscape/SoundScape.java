package com.gccg.soundscape;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gccg.soundscape.modelos.*;
import com.gccg.soundscape.dao.*;
import java.util.List;

/**
 *
 * @@author Genesis C - Christopher G
 */
public class SoundScape {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Get a database connection
/*        Connection connection = DatabaseConnection.getConnection();

        // Use the connection to execute SQL queries and interact with the database
        try {
            // Create a SQL statement
            String query = "SELECT * FROM song";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                // Execute the query and get the result set
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data from each row
                        int id = resultSet.getInt("id");
                        String title = resultSet.getString("titulo");
                        // ... (retrieve other columns as needed)

                        // Do something with the retrieved data
                        System.out.println("Song ID: " + id + ", Title: " + title);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
         */
        Artist artist = new Artist(1, "Adele");
        Genere genere = new Genere(3, "Pop");
        SongDao songDao = new SongDao();
        Song song = new Song(
                "Test", 2023, 430, artist, genere
        );
        songDao.saveStudent(song);

        List< Song> songs = songDao.getSongs();
        for (Song s : songs) {
            System.out.println(s.getTitulo());
        }
    }
}
