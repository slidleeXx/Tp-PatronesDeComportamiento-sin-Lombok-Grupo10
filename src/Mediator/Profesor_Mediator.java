package Mediator;

public class Profesor_Mediator extends Usuario {

    public Profesor_Mediator(ChatMediator mediator, String nombre) {
        super(mediator, nombre);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("\n" + nombre + " envía: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }

    @Override
    public void recibir(String mensaje) {
        System.out.println("\n" + nombre + " recibe: " + mensaje);
    }
}
