package Model;

public class Libro {
    private int id_libro;
    private String nombre;
    private String editorial;
    private String tipo_libro;
    private int ano;
    private int estado;
    private int id_categoria;

    public Libro(int idLibro, String nombreLibro, int ano, String tipoLibro, String editorial, int estado, int idCategoria) {
        this.id_libro = idLibro;
        this.nombre = nombreLibro;
        this.ano = ano;
        this.tipo_libro = tipoLibro;
        this.editorial = editorial;
        this.estado = estado;
        this.id_categoria = idCategoria;
    }

    public Libro(String nombreLibro) {
    }


    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTipo_libro() {
        return tipo_libro;
    }

    public void setTipo_libro(String tipo_libro) {
        this.tipo_libro = tipo_libro;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
