package controller;

import model.Estudiante;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Gestor {

    private ArrayList<Estudiante> estudiantes;

    public Gestor() {
        estudiantes = new ArrayList<>();
        /*estudiantes.add(new Estudiante("Estudiante 1", "Apellido 1", 20, 9, 10));
        estudiantes.add(new Estudiante("Estudiante 2", "Apellido 2", 40, 8, 12));
        estudiantes.add(new Estudiante("Estudiante 3", "Apellido 3", 30, 7, 20));
        estudiantes.add(new Estudiante("Estudiante 4", "Apellido 4", 50, 5, 30));
        estudiantes.add(new Estudiante("Estudiante 5", "Apellido 5", 23, 8, 15));*/
    }

    public void mostrarEstudiantesNota(int x) {
        estudiantes.stream().filter(it -> it.getNombraMedia() >= x)
                .forEach(Estudiante::mostrarDatos);
    }

    public void calcularMediaTotal() {

        double media = estudiantes.stream()// estudiante a estudiante
                .mapToDouble(Estudiante::getNombraMedia)// me quedo con la media
                .average() // calcula la media (sumatorio / total)
                .orElse(-1);
        System.out.println("La media es = " + media);
    }

    public void estudianteEstudioso(int x, int y) {
        Estudiante estudioso = estudiantes.stream()
                .filter(it -> it.getNombraMedia() >= x && it.getNombraMedia() <= y)
                .sorted(Comparator.comparingInt(Estudiante::getHorasSemanales))
                .findFirst().orElse(null);
    }

    public void rangoEstudiantes(int nota){
        //hashmap -> coleccion no indexada, par clave valor
        HashMap<Integer, List<Estudiante>> estudiantesMap = new HashMap<>();
        for(int i=5;i<11;i++){
            int finalI = i;
            estudiantesMap.put(i,
                    (ArrayList<Estudiante>) estudiantes.stream()
                            .filter(it->it.getNombraMedia()== finalI).toList());
        }



    }
}
