<%@ page import="java.util.List" %>
<%@ page import="Model.Categoria" %>
<%@ page import="Model.Data.DAO.CategoriaDAO" %>
<%@ page import="org.jooq.DSLContext" %>
<%@ page import="Model.Data.DBGenerator" %>
<%@ page import="Model.Libro" %>
<%@ page import="Model.Data.DAO.LibroDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Libros Universidad de la Frontera</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <!--Estos div son para que todo quede centrado-->
<h1 align="center">Agregar Libro</h1>
<form action="LibrosServlet" method="post">
    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text">Nombre del libro:</span>
        <input id="nombre" name="nombre" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" required>
    </div>
    <br>
    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text">Editorial:</span>
        <input id="editorial" name="editorial" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" required>
    </div>
    <br>
    <select id="ano" name="ano" class="form-select form-select-sm col-6" aria-label="Default select example" required>
        <option selected>Año de publicación:</option>
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
    <select id="tipo_libro" name="tipo_libro" class="form-select form-select-sm" aria-label="Default select example" required>
        <option selected>Tipo de libro: </option>
        <option value="Físico">Físico</option>
        <option value="Digital">Digital</option>
    </select>
    <br>
    <select id="estado" name="estado" class="form-select form-select-sm" aria-label="Default select example" required>
        <option selected>Elegir estado:</option>
        <option value="1">Activo</option>
        <option value="0">Inactivo</option>
    </select>
    <br>
    <select id="id_categoria" name="id_categoria" class="form-select form-select-sm" aria-label="Default select example" required>
        <option selected>Elegir genero:</option>
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
    <button type="submit" class="btn btn-primary btn-sm">Agregar</button>

</form>

<h2 align="center">Agregar Categoría</h2>
<form action="CategoriaServlet" method="post">
<label for="nombreCategoria">Nombre de la Categoría:</label>
<input type="text" id="nombreCategoria" name="nombreCategoria" required>
<br>
<input type="submit" value="Agregar Categoría">
</form>

<h3 align="center">Libros Añadidos</h3>
            <select id="Id_libro" name="Id_libro" class="form-select form-select-sm" aria-label="Default select example" required>
                <option selected>Libros disponibles:</option>
                <%
                    DSLContext create2 = DBGenerator.conectarBD("biblioteca");
                    List<Libro> libros = LibroDAO.obtenerLibros(create2);
                    for (Libro libro : libros) {
                %>
                <option value="<%= libro.getId_libro() %>"><%= libro.getNombre() %></option>
                <%
                    }
                %>
            </select>
        </div>
    </div>
</div>
</body>
</html>


