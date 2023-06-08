package DAO;

import Controller.DBConnector;
import Model.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LibrosDAO {
    private Connection connection;

    public void init() {
        connection = DBConnector.getConnection();
    }
    public void closeConnection() {
        DBConnector.closeConnection();
    }

    public LibrosDAO() {
    }

    public void agregarLibro(Libro libro) {
        try {
            String query = "INSERT INTO libros (nombre, editorial, ano, tipo_libro, estado, id_categoria) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, libro.getNombre());
            statement.setString(2, libro.getEditorial());
            statement.setInt(3, libro.getAno());
            statement.setString(4, libro.getTipo_libro());
            statement.setInt(5, libro.getEstado());
            statement.setInt(6, libro.getId_categoria());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Libro> buscarNombre(String nombre) {
        // Lógica para buscar libros por nombre en la base de datos
        // Devuelve una lista de libros que coinciden con el nombre
        return null;
    }



    public void eliminarLibro(int idLibro) {
        // Lógica para dar de baja un libro en la base de datos
    }

}

