package dds.birbnb_ahk.entities;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

public class CambioEstadoReserva {
    private LocalDate fecha;
    private EstadoReserva estado;
    private Reserva reserva;
    private String motivo;
    private Usuario usuario;
}
