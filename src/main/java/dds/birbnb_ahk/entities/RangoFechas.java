package dds.birbnb_ahk.entities;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RangoFechas {
    private LocalDate fechaIncio;
    private LocalDate fechaFin;

    public boolean estasDisponible(RangoFechas rango) {
        return this.fechaIncio.isBefore(rango.fechaIncio) || this.fechaFin.isAfter(rango.fechaFin);
    }
}
