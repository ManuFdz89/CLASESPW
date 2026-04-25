package model;

import java.util.ArrayList;

public class Estudiante {

    private String nombre, apellido;
    private int edad;
    private double notaMedia;

    private ArrayList<String> asignaturasAprobadas;
    private int horasEstudio;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, int edad, double notaMedia, ArrayList<String> asignaturasAprobadas, int horasEstudio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.notaMedia = notaMedia;
        this.asignaturasAprobadas = asignaturasAprobadas;
        this.horasEstudio = horasEstudio;
    }
    public Estudiante(String nombre, String apellido, int edad, int horasEstudio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        // this.notaMedia = notaMedia;
        this.asignaturasAprobadas = new ArrayList<>();
        this.horasEstudio = horasEstudio;
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("notaMedia = " + notaMedia);
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

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public ArrayList<String> getAsignaturasAprobadas() {
        return asignaturasAprobadas;
    }

    public void setAsignaturasAprobadas(ArrayList<String> asignaturasAprobadas) {
        this.asignaturasAprobadas = asignaturasAprobadas;
    }

    public int getHorasEstudio() {
        return horasEstudio;
    }

    public void setHorasEstudio(int horasEstudio) {
        this.horasEstudio = horasEstudio;
    }
}
