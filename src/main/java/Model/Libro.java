package Model;

public class Libro {
    private int id_libro;
    private String nombre;
    private String editorial;
    private String tipo_libro;
    private int ano;
    private int estado;
    private int id_categoria;

    public Libro(int id_libro, String nombre, String editorial, String tipo_libro, int ano, int estado, int id_categoria) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.editorial = editorial;
        this.tipo_libro = tipo_libro;
        this.ano = ano;
        this.estado = estado;
        this.id_categoria = id_categoria;
    }

    public Libro(String nombre, String editorial, int ano, String tipoLibro, int estado, int idCategoria) {
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
