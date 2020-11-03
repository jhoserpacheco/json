package modelo;

public class ProductoDTO {
    //tipo producto 

    private String descripcion;
    private String nombre;
    private String modelo;
    private byte departamento;
    private int cantidad;
    private double precio;

    public ProductoDTO(String descripcion, String nombre, String modelo, byte departamento, int cantidad, double precio) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.modelo = modelo;
        this.departamento = departamento;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ProductoDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDepartamento(byte departamento) {
        this.departamento = departamento;
    }

    public byte getDepartamento() {
        return departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" + "descripcrion=" + descripcion + ", nombre=" + nombre + ", modelo=" + modelo
                + ", departamento=" + departamento + ", precio=" + precio + '}';
    }

}
