package model;

//Clase para construir los Objetos Producto.
public class Producto {
    private String nombre;
    private boolean comprado;

    public Producto(String nombre) {
        this.nombre = nombre;
        this.comprado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    @Override
    public String toString() {
        return comprado ? "✔ " + nombre : nombre;
    }
}