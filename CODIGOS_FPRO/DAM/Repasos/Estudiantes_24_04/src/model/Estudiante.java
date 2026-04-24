package model;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    private String nombre, apellido;
    private int edad;
    private List<String> asignaturas;
    private double nombraMedia;
    private int horasSemanales;


    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, int edad, double nombraMedia, int horasSemanales) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nombraMedia = nombraMedia;
        this.horasSemanales = horasSemanales;
        this.asignaturas = new ArrayList<>();

    }

    public Estudiante(String nombre, String apellido, int edad, ArrayList<String> asignaturas, double nombraMedia, int horasSemanales) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.asignaturas = asignaturas;
        this.nombraMedia = nombraMedia;
        this.horasSemanales = horasSemanales;
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("nombraMedia = " + nombraMedia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public double getNombraMedia() {
        return nombraMedia;
    }

    public void setNombraMedia(double nombraMedia) {
        this.nombraMedia = nombraMedia;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }
}
