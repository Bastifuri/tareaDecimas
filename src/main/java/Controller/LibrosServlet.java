package Controller;

import DAO.CategoriasDAO;
import DAO.LibrosDAO;
import Model.Categoria;
import Model.Libro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LibrosServlet")
public class LibrosServlet extends HttpServlet {
    private LibrosDAO librosDAO;

    public void init() {
        librosDAO = new LibrosDAO();
        librosDAO.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para manejar las solicitudes POST, como agregar libros y categorías

       /* ESTO ES UN INTENTO DE AGREGAR UNA CATEGORIA A MI BASE DE DATOS
        String nombreCategoria = request.getParameter("nombreCategoria");
        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(nombreCategoria);
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        categoriasDAO.agregarCategoria(categoria);
        response.sendRedirect("agregarCat.jsp");*/

        String nombre = request.getParameter("nombre");
        String editorial = request.getParameter("editorial");
        int ano = Integer.parseInt(request.getParameter("ano"));
        String tipoLibro = request.getParameter("tipo_libro");
        int estado = Integer.parseInt(request.getParameter("estado"));
        int idCategoria = Integer.parseInt(request.getParameter("id_categoria"));

        Libro libro = new Libro(nombre, editorial, ano, tipoLibro, estado, idCategoria);

        LibrosDAO librosDAO = new LibrosDAO();
        librosDAO.agregarLibro(libro);

        response.sendRedirect("agregarCat.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para manejar las solicitudes GET, como buscar y dar de baja libros
    }

}

