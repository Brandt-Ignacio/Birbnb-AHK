package dds.birbnb_ahk.entities.reservas;

import java.time.LocalDate;
import java.util.UUID;

import dds.birbnb_ahk.entities.alojamientos.Alojamiento;
import dds.birbnb_ahk.entities.notificaciones.FactoryNotificacion;
import dds.birbnb_ahk.entities.notificaciones.Notificacion;
import dds.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaAlta;

    @ManyToOne
    @JoinColumn(name = "huespes_id", nullable = false)
    private Usuario huesped;

    @ManyToOne
    @JoinColumn(name = "alojamiento_id", nullable = false)
    private Alojamiento alojamiento;

    @Embedded
    private RangoFechas rangoFechas;

    @Enumerated(EnumType.STRING
    )
    private EstadoReserva estado;

    @Column
    private Double precioPorNoche;



    public void actualizarEstado(EstadoReserva estadoReserva){
        this.estado = estadoReserva;
        //TODO pendiente de ser guardado
        Notificacion notificacion = new FactoryNotificacion().crearSegunReserva(this);
    }
}


