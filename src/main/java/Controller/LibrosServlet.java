package Controller;

import Model.Data.DAO.LibroDAO;
import Model.Data.DBConnector;
import Model.Data.DBGenerator;
import Model.Libro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;

@WebServlet
public class LibrosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreLibro = request.getParameter("nombre");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String tipoLibro = request.getParameter("tipo_libro");
        String editorial = request.getParameter("editorial");
        int estado = Integer.parseInt(request.getParameter("estado"));
        int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));

        Libro libro = new Libro(0, nombreLibro,ano,tipoLibro,editorial,estado,id_categoria); // El id se generará automáticamente en la base de datos

        try {
            // conexion a la bd
            DSLContext create = DBGenerator.conectarBD("biblioteca");

            // Agregar la categoría a la bd
            LibroDAO.agregarLibro(create, libro);

            DBConnector.closeConnection();

            // Redireccionar a una página de éxito
            response.sendRedirect("exito.jsp");
        } catch (ClassNotFoundException e) {
            // Manejar la excepción
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para manejar las solicitudes GET, como buscar y dar de baja libros
    }

}

