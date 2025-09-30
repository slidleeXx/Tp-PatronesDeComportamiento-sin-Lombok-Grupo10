import Chain_of_Responsibility.*;
import Mediator.*;



public class Main {
    public static void main(String[] args) {
        //-----PATRON CHAIN OF RESPONSIBILITY -----
        System.out.println("\n--> PROBAMOS PATRON CHAIN OF RESPONSIBILITY:");
        Handler basico = new Asistente();
        Handler intermedio = new Profesor_Chain_of_Responsibility();
        Handler experto = new Coordinador();

            //Determinamos quien es el siguiente en la fila que atenderá a la solicitud.
        basico.setNext(intermedio);
        intermedio.setNext(experto);

        Solicitud solicitud1 = new Solicitud("Problema con un libro.", 1);
        Solicitud solicitud2 = new Solicitud("Problema con un tema de una clase.", 2);
        Solicitud solicitud3 = new Solicitud("Problema con un programa.", 3);
            //Excede el nivel, por lo tanto no se puede atender dicha solicitud.
        Solicitud solicitud4 = new Solicitud("Problema con un libro.", 5);

        basico.handle(solicitud1);
        basico.handle(solicitud2);
        basico.handle(solicitud3);
        basico.handle(solicitud4);

        //-----PATRON COMMAND-----

        //-----PATRON ITERATOR-----

        //-----PATRON MEDIATOR-----
        System.out.println("\n--> PROBAMOS PATRON MEDIATOR:");
        ChatMediator sala = new ChatRoom();
        Profesor_Mediator profesorMediator = new Profesor_Mediator(sala, "Profesor Pablo");
        Alumno_Mediator alumnoMediator1 = new Alumno_Mediator(sala, "Pepe");
        Alumno_Mediator alumnoMediator2 = new Alumno_Mediator(sala, "Rosa");

        sala.agregarUsuario(profesorMediator);
        sala.agregarUsuario(alumnoMediator1);
        sala.agregarUsuario(alumnoMediator2);

        profesorMediator.enviar("Buen dia chicos.");
        alumnoMediator1.enviar("¡Hola a todos!");
        alumnoMediator2.enviar("Hola Profe y Pepe, ¿cómo han estado?");
        alumnoMediator1.enviar("Bien, ¿y tu Rosa?");
        alumnoMediator2.enviar("Muy bien, gracias.");

        //-----PATRON MEMENTO-----

        //-----PATRON OBSERVER-----

        //-----PATRON STATE-----

        //-----PATRON STRATEGY-----

        //-----PATRON TEMPLATE METHOD-----

        //-----PATRON VISITOR-----

    }
}