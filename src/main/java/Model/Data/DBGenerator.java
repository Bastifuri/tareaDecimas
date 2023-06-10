package Model.Data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;
import java.sql.Connection;
import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {

    public static void iniciarBD(String biblioteca) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root","");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create,biblioteca);
        create = actualizarConexion(connection,biblioteca);
        crearTablaCategorias(create);
        crearTablaLibros(create);
        DBConnector.closeConnection();

    }
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        DSLContext create = DSL.using(connection);
        return create;
    }
    private static void crearBaseDato(DSLContext create, String biblioteca){
        create.createDatabaseIfNotExists(biblioteca).execute();
    }

    private static DSLContext actualizarConexion(Connection connection,String biblioteca){
        DBConnector.closeConnection();
        connection= DBConnector.connection(biblioteca,"root","");
        DSLContext create=DSL.using(connection);
        return create;
    }

    private static void crearTablaCategorias(DSLContext create){
        create.createTableIfNotExists("categorias").column("nombre_cat",VARCHAR(200))
                .column("id_categoria", INTEGER)
                .constraint(primaryKey("id_categoria")).execute();
    }

    private static void crearTablaLibros(DSLContext create){
        create.createTableIfNotExists("libros").column("Id_libro",INTEGER)
                .column("ano",INTEGER)
                .column("tipo_libro",VARCHAR(50))
                .column("editorial",VARCHAR(200))
                .column("estado",INTEGER)
                .column("id_categoria", INTEGER)
                .column("nombre",VARCHAR(200))
                .constraint(primaryKey("Id_libro")).execute();

    }
    private static void relacionarTabla(DSLContext create, String libros, String claveForanea, String categorias){
        create.alterTableIfExists(libros).add(foreignKey(claveForanea).references(categorias)).execute();
        create.alterTableIfExists(libros).alterConstraint(foreignKey(claveForanea).references(categorias)).enforced();
    }
    private static void agregarColumnaTabla(DSLContext create, String libros, String columna, DataType tipoColumna){
        create.alterTableIfExists(libros).addColumn(columna,tipoColumna);
    }

}
