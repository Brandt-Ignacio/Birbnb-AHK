package dds.birbnb_ahk.entities.notificaciones;
import dds.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "norificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaAlta;

    @Column
    private Boolean leida;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaLeida;

    public Notificacion(){
        this.leida = false;
        this.fechaAlta = LocalDate.now();
    }

    public void marcarComoLeida(){
        this.leida = true;
        this.fechaLeida = LocalDateTime.now();
    }
}


