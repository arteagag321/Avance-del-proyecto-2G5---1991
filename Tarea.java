import java.util.Date;

public class Tarea {
    private int id;
    private String descripcion;
    private String estado;
    private Date fechaLimite;

    public Tarea(int id, String descripcion, String estado, Date fechaLimite) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void completarTarea() {
        this.estado = "Completada";
    }

    @Override
    public String toString() {
        return "Tarea ID: " + id + ", Descripción: " + descripcion + ", Estado: " + estado;
    }
}
