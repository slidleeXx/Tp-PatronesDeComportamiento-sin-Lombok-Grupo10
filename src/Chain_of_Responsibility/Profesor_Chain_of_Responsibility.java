package Chain_of_Responsibility;

public class Profesor_Chain_of_Responsibility implements Handler{
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handle(Solicitud s) {
        if (s.getNivel() == 2) {
            System.out.println("\nProfesor atiende la solicitud: " + s.getTipoSolicitud());

        } else if (next != null){
            next.handle(s);
        }
    }
}
