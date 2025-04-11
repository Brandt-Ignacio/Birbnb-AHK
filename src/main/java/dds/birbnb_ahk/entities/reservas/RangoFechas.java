package dds.birbnb_ahk.entities.reservas;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Embeddable
public class RangoFechas {
    @Column(columnDefinition = "DATE")
    private LocalDate fechaIncio;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaFin;

    public boolean estasDisponible(RangoFechas rango) {
        return this.fechaIncio.isBefore(rango.fechaIncio) || this.fechaFin.isAfter(rango.fechaFin);
    }
}
