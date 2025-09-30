package entidades;

import iterador.CursoIterator;
import strategy.CalcularNota;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String apellido;
    private Integer dni;
    private Integer legajo;



    private List<Integer> notas = new ArrayList<>();
    private List<Curso> cursosInscriptos = new ArrayList<>();
    private CalcularNota estrategiaCalculoNot;


    public Alumno(String nombre, String apellido, Integer dni, Integer legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.legajo = legajo;
    }

    // Patron Iterator y Patron Strategy
    public void inscribirCurso(Curso curso) {
        if (!cursosInscriptos.contains(curso)){
        cursosInscriptos.add(curso);
            System.out.println("Se a inscripto en el curso: " +curso.getNombre());}
    }

    public void agregarNota(Integer nota){
        notas.add(nota);
    }

    public void setEstrategiaCalculoNot(CalcularNota estrategiaCalculoNot) {
        this.estrategiaCalculoNot = estrategiaCalculoNot;
    }
    public double calcularNotaFinal() {
        if (estrategiaCalculoNot == null) throw new IllegalStateException("Estrategia de calculo de nota no establecda");
        return estrategiaCalculoNot.calcularNota(notas);
    }

    public CursoIterator iterator() {
        return new ClCursoIterator(cursosInscriptos);
    }

    public void mostrarDatos() {
        System.out.println("---Alumno---\n");
        System.out.println("Nombre: "+nombre+"Apellido: "+apellido + "Dni: "+dni+"Legajo: "+legajo);
    }

    // implementación del iterador de cursos
    private static class ClCursoIterator implements CursoIterator {
        private java.util.List<Curso> cursosInscr;
        private int posicion = 0;

        public ClCursoIterator(java.util.List<Curso> cursosInscr) {
            this.cursosInscr = cursosInscr;
        }

        public boolean hasNext() {
            return posicion < cursosInscr.size();
        }

        public Curso next() {
            return cursosInscr.get(posicion++);
        }
    }
    // Fin Patron Iterator - Strategy

}

