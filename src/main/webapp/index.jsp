<%@ page import="java.util.List" %>
<%@ page import="Model.Categoria" %>
<%@ page import="Model.Data.DAO.CategoriaDAO" %>
<%@ page import="org.jooq.DSLContext" %>
<%@ page import="Model.Data.DBGenerator" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Libros Universidad de la Frontera</title>
</head>
<body>
<h1>Agregar Libro</h1>
<form action="LibrosServlet" method="post">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required>
    <br>
    <label for="editorial">Editorial:</label>
    <input type="text" id="editorial" name="editorial" required>
    <br>
    <label for="ano">Año:</label>
    <select id="ano" name="ano" required>
        <%
            int currentYear = java.time.Year.now().getValue();
            for (int year = currentYear; year >= 1900; year--) {
        %>
        <option value="<%= year %>"><%= year %></option>
        <%
            }
        %>
    </select>
    <br>
    <label for="tipo_libro">Tipo de Libro:</label>
    <select id="tipo_libro" name="tipo_libro" required>
        <option value="Físico">Físico</option>
        <option value="Digital">Digital</option>
    </select>
    <br>
    <label for="estado">Estado:</label>
    <select id="estado" name="estado" required>
        <option value="1">Activo</option>
        <option value="0">Inactivo</option>
    </select>
    <br>
    <label for="id_categoria">Categoría:</label>
    <select id="id_categoria" name="id_categoria" required>
        <%
            DSLContext create = DBGenerator.conectarBD("biblioteca");
            List<Categoria> categorias = CategoriaDAO.obtenerCategorias(create);
            for (Categoria categoria : categorias) {
        %>
        <option value="<%= categoria.getIdCategoria() %>"><%= categoria.getNombreCategoria() %></option>
        <%
            }
        %>
    </select>
    <br>
    <button type="submit">Agregar</button>
</form>

<h2>Agregar Categoría</h2>
<form action="CategoriaServlet" method="post">
<label for="nombreCategoria">Nombre de la Categoría:</label>
<input type="text" id="nombreCategoria" name="nombreCategoria" required>
<br>
<input type="submit" value="Agregar Categoría">
</body>
</html>


