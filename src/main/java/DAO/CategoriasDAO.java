package DAO;

import Controller.DBConnector;
import Model.Categoria;
import Model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoriasDAO {
    private Connection connection;

    public void init() {
        connection = DBConnector.getConnection();
    }
    public void closeConnection() {
        DBConnector.closeConnection();
    }

    public void agregarCategoria(Categoria categoria){
        try{
            String query = "INSERT INTO categorias (nombre_cat) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, categoria.getNombreCategoria());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Libro> buscarCategoria(String categoria) {
        // Lógica para buscar libros por categoría en la base de datos
        // Devuelve una lista de libros que pertenecen a la categoría especificada
        return null;
    }
}
