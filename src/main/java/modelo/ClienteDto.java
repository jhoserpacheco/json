package modelo;

public class ClienteDto {

    private String nombre;
    private int cedula;
    private int telefono;
    private String correo;
    private String direccion;

    public ClienteDto() {
    }

    public ClienteDto(String nombre, int cedula, int telefono, String correo, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "ClienteDto{" + "nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + '}';
    }
}
