<%@ page import="java.util.List" %>
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
    <input type="number" id="ano" name="ano" required>
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
    <input type="number" id="id_categoria" name="id_categoria" required>
    <br>
    <button type="submit">Agregar</button>
</form>

</body>
</html>