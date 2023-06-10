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
        // Obtener los parámetros enviados desde el index
        String nombreCategoria = request.getParameter("nombreCategoria");

        // Crear una instancia de la categoría
        Categoria categoria = new Categoria(0, nombreCategoria); //Aqui es para que el id se genere automaticamente

        try {
            // Aqui es para conectarse a la bd
            DSLContext create = DBGenerator.conectarBD("biblioteca");

            // Agregar la categoría a la bd
            CategoriaDAO.agregarCat(create, categoria);

            DBConnector.closeConnection();

            // Redirecciono a una pagina de exito estandar
            response.sendRedirect("exito.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //conexion a la bd
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