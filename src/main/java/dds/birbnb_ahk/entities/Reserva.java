package dds.birbnb_ahk.entities;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Reserva {
    private LocalDate fechaAlta;
    private Usuario huesped;
    private Alojamiento alojamiento;
    private RangoFechas rangoFechas;
    private EstadoReserva estado;
    private Double precioPorNoche;



    public void actualizarEstado(EstadoReserva estadoReserva){
        this.estado = estadoReserva;
        //TODO pendiente de ser guardado
        Notificacion notificacion = new FactoryNotificacion().crearSegunReserva(this);
    }
}


