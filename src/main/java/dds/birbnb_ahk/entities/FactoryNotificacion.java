package dds.birbnb_ahk.entities;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FactoryNotificacion {

    private String crearMensajeSegunEstado(Reserva reserva){
        return switch (reserva.getEstado()){
            case PENDIENTE -> "Tenes una reserva de " + reserva.getHuesped().getNombre()
                + ", para el alojamiento " + reserva.getAlojamiento().getNombre()
                + "desde el dia " + reserva.getRangoFechas().getFechaIncio().toString()
                + " hasta el dia " + reserva.getRangoFechas().getFechaFin().toString()
                + ".";

            case CONFIRMADA -> "La reserva para el alojamiento " + reserva.getAlojamiento().getNombre()
                + ", desde el dia " + reserva.getRangoFechas().getFechaIncio().toString()
                + " hasta el dia " + reserva.getRangoFechas().getFechaFin().toString()
                + " fue confirmada.";
            case CANCELADA -> "La reserva de " + reserva.getHuesped().getNombre()
                    + " para el alojamiento " + reserva.getAlojamiento().getNombre()
                    + ", desde el dia " + reserva.getRangoFechas()
        }
    }

    public Notificacion crearSegunReserva(Reserva reserva){
        Notificacion noti = new Notificacion();
        if(reserva.getEstado().equals(EstadoReserva.PENDIENTE)) {
            noti.setUsuario(reserva.getAlojamiento().getAnfitrion());
        }
        else if(reserva.getEstado().equals(EstadoReserva.CONFIRMADA)){
            noti.setUsuario(reserva.getHuesped());
        }
        else if(reserva.getEstado().equals(EstadoReserva.CANCELADA)){
            noti.setUsuario(reserva.getAlojamiento().getAnfitrion());
        }

        noti.setMensaje(this.crearMensajeSegunEstado(reserva));
        return noti;
    }
}
