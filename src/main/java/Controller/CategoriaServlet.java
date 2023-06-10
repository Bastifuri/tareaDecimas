package Controller;

import Model.Categoria;
import Model.Data.DAO.CategoriaDAO;
import Model.Data.DBConnector;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet
public class CategoriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros enviados desde el formulario
        String nombreCategoria = request.getParameter("nombreCategoria");

        // Crear una instancia de la categoría
        Categoria categoria = new Categoria(0, nombreCategoria); // El id se generará automáticamente en la base de datos

        try {
            // Obtener la instancia DSLContext para interactuar con la base de datos
            DSLContext create = DBGenerator.conectarBD("biblioteca");

            // Agregar la categoría a la base de datos
            CategoriaDAO.agregarCat(create, categoria);

            // Cerrar la conexión a la base de datos
            DBConnector.closeConnection();

            // Redireccionar a una página de éxito o mostrar un mensaje de éxito
            response.sendRedirect("exito.jsp");
        } catch (ClassNotFoundException e) {
            // Manejar la excepción
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener la instancia DSLContext para interactuar con la base de datos
            DSLContext create = DBGenerator.conectarBD("biblioteca");

            // Obtener la lista de categorías
            List<Categoria> categorias = CategoriaDAO.obtenerCategorias(create);

            // Guardar la lista de categorías en el request para enviarla al index.jsp
            request.setAttribute("categorias", categorias);

            // Redireccionar al index.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            // Manejar la excepción
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}