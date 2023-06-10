package Model.Data.DAO;

import Model.Categoria;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.Record;


import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class CategoriaDAO {
    public static void agregarCat(DSLContext query, Categoria categoria){
        Table tablaCat = table(name("categorias"));
        Field[] columnas = tablaCat.fields("id_categoria","nombre_cat");
        query.insertInto(tablaCat, columnas[0],columnas[1])
                .values(categoria.getIdCategoria(), categoria.getNombreCategoria())
                .execute();
    }
    public static List<Categoria> obtenerCategorias(DSLContext query) {
        List<Categoria> categorias = new ArrayList<>();

        // Obtener los datos de la tabla de categorías
        Result<Record> result = query.select().from(table(name("categorias"))).fetch();

        // Recorrer los registros y crear objetos Categoria
        for (Record record : result) {
            int idCategoria = record.get("id_categoria", Integer.class);
            String nombreCategoria = record.get("nombre_cat", String.class);

            Categoria categoria = new Categoria(idCategoria, nombreCategoria);
            categorias.add(categoria);
        }

        return categorias;
    }
}
