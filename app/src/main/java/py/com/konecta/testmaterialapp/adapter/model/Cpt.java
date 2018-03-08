package py.com.konecta.testmaterialapp.adapter.model;

/**
 * Created by konecta on 04/03/18.
 */

public class Cpt {

    private Long id;
    private Long nivel;
    private String subNivel;
    private String numeroGasto;
    private String tituloUnidad;
    private String denominacion;
    private String disponible;

    public Cpt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public String getSubNivel() {
        return subNivel;
    }

    public void setSubNivel(String subNivel) {
        this.subNivel = subNivel;
    }

    public String getNumeroGasto() {
        return numeroGasto;
    }

    public void setNumeroGasto(String numeroGasto) {
        this.numeroGasto = numeroGasto;
    }

    public String getTituloUnidad() {
        return tituloUnidad;
    }

    public void setTituloUnidad(String tituloUnidad) {
        this.tituloUnidad = tituloUnidad;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }
}
