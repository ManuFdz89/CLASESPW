package controller;

import model.Estudiante;

import java.util.*;

public class Gestor {

    private ArrayList<Estudiante> estudiantes;

    public Gestor() {
        estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Estudiante 1",
                "Apellido 1", 20, 8, new ArrayList(), 6));
        estudiantes.add(new Estudiante("Estudiante 2",
                "Apellido 2", 24, 7, new ArrayList(), 9));
        estudiantes.add(new Estudiante("Estudiante 3",
                "Apellido 3", 21, 9, new ArrayList(), 19));
        estudiantes.add(new Estudiante("Estudiante 4",
                "Apellido 4", 21, 6, new ArrayList(), 2));
        estudiantes.add(new Estudiante("Estudiante 5",
                "Apellido 5", 31, 9, new ArrayList(), 12));
    }

    public void mostrarAprobados(int x) {
        estudiantes.stream()
                .filter(item -> item.getNotaMedia() >= x)
                .forEach(Estudiante::mostrarDatos);
    }

    public void calcularMediaTotal() {
        double media = estudiantes.stream().mapToDouble(Estudiante::getNotaMedia).average().orElse(0);
        System.out.println("La media total es de " + media);
    }

    public void calcularMaximo(int x, int y) {
        Estudiante estudianteEstudioso = estudiantes.stream()
                .filter(item -> (item.getNotaMedia() >= x && item.getNotaMedia() <= y))
                .sorted(Comparator.comparingInt(Estudiante::getHorasEstudio))
                .findFirst().orElse(null);
    }

    public void estudiantesMap(int x, int y) {
        List<Estudiante> estudiantesGrupos = estudiantes.stream()
                .filter(item -> (item.getNotaMedia() >= x && item.getNotaMedia() <= y))
                .toList();

        HashMap<String, Estudiante> estudiantesMapa = new HashMap<>();
        estudiantesGrupos.forEach(it -> estudiantesMapa.put(it.getNombre() + "_" + it.getApellido(), it));
    }

    public void ordenarHoras() {
        estudiantes.stream()
                .sorted(Comparator.comparingInt(Estudiante::getHorasEstudio));
    }
}
