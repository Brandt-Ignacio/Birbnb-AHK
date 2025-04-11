package dds.birbnb_ahk.entities.alojamientos;
import dds.birbnb_ahk.entities.ubicaciones.Direccion;
import dds.birbnb_ahk.entities.Moneda;
import dds.birbnb_ahk.entities.reservas.RangoFechas;
import dds.birbnb_ahk.entities.reservas.Reserva;
import dds.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Alojamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Setter
    @Getter
    @ManyToOne
    private Usuario anfitrion;

    @Setter
    @Getter
    @Column(name = "nombre")
    private String nombre;

    @Setter
    @Getter
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Setter
    @Getter
    @Column(name = "precioPorNoche")
    private Double precioPorNoche;

    @Setter
    @Getter

    @Enumerated(EnumType.STRING)
    private Moneda moneda;

    @Setter
    @Getter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioChecking;

    @Setter
    @Getter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioCheckOut;

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(nullable = false)
    private Direccion direccion;

    @Setter
    @Getter
    @Column
    private Integer cantHuespedesMax;

    @Getter
    @ElementCollection
    @CollectionTable(name = "alojamiento_caracteristicas", joinColumns = @JoinColumn(name = "alojamiento_id"))

    @Enumerated(EnumType.STRING)
    @Column(name = "caracteristica")
    private List<Caracteristica> caracteristicas;

    @Getter
    @OneToMany(mappedBy = "alojamiento")
    private List<Reserva> reservas;

    @Getter
    @OneToMany
    @JoinColumn(name = "alojamiento_id")
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
        return this.reservas.stream().noneMatch(r -> r.getRangoFechas().estasDisponible(rango));
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
