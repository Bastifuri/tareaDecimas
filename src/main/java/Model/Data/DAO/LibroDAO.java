package Model.Data.DAO;

import Model.Libro;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class LibroDAO {
    public static void agregarLibro(DSLContext query, Libro libro) {
        Table tablaLibro = table(name("libros"));
        Field[] columnas = tablaLibro.fields("Id_libro", "nombre", "ano", "tipo_libro", "editorial", "estado", "id_categoria");
        query.insertInto(tablaLibro, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4], columnas[5], columnas[6])
                .values(libro.getId_libro(), libro.getNombre(), libro.getAno(), libro.getTipo_libro(),
                        libro.getEditorial(), libro.getEstado(), libro.getId_categoria())
                .execute();
    }


   /* public List<Libro> obtenerLibro(DSLContext query, String nombre, String valor) {
        Result<Record> resultados = query.select().from(DSL.table("libros")).where(DSL.field(nombre).eq(valor)).fetch();
        return obtenerListaLibros(resultados);
    }
    private List obtenerListaLibros(Result resultados){
        List<Libro> libros= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String nombreLibro = (String) resultados.getValue(fila,"nombre");
            libros.add(new Libro(nombreLibro));
        }
        return libros;
    }*/
}
