package dds.birbnb_ahk.entities;
import lombok.Getter;
import lombok.Setter;

import javax.xml.catalog.Catalog;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Alojamiento {
    @Setter
    @Getter
    private Usuario anfitrion;

    @Setter
    @Getter
    private String nombre;

    @Setter
    @Getter
    private String descripcion;

    @Setter
    @Getter
    private Double precioPorNoche;

    @Setter
    @Getter
    private Moneda moneda;

    @Setter
    @Getter
    private LocalTime horarioChecking;

    @Setter
    @Getter
    private LocalTime horarioCheckOut;

    @Setter
    @Getter
    private Direccion direccion;

    @Setter
    @Getter
    private Integer cantHuespedesMax;

    @Getter
    private List<Caracteristica> caracteristicas;

    @Getter
    private List<Reserva> reservas;

    @Getter
    private List<Foto> fotos;

    public Alojamiento(){
        this.fotos = new ArrayList<>();
        this.caracteristicas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Boolean estasDisponibleEn(RangoFechas rango){
        /*boolean estaDisponible = false;
        int i = 0;
        while(i<this.reservas.size() && !estaDisponible){
            Reserva reserva = this.reservas.get(i);
            RangoFechas rangoDeLaReserva = reserva.getRangoFechas();

            if(rangoDeLaReserva.estasDisponible(rangoDeFechas)){
                estaDisponible = true;
            }
            i++;
        }
        return !estaDisponible;
         */
        return this.reservas.stream().noneMatch(r -> r.getRangoFechas().estasDisponible(rango))
    }


    public Boolean tuPrecioEstaDentroDe(Double valorMin, Double valorMax){
        return this.precioPorNoche <= valorMax && this.precioPorNoche >= valorMin;
    }

    public Boolean puedenAlojarse(Integer cantHuespedes){
        return cantHuespedes <= this.cantHuespedesMax;
    }

    public Boolean tenesCaracteristica(Caracteristica caracteristica){
        return this.caracteristicas.contains(caracteristica);
    }
}
