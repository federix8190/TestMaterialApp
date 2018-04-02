package py.com.konecta.testmaterialapp.model;

import java.util.Date;

public class Oferta {

    private Long id;
    private String estado;
    private String titulo;
    private Date inicioPuja;
    private Date finPuja;
    private Integer montoBase;
    private Long montoCompra;
    private Long montoPuja;
    private Integer montoIncremento;

    public Oferta() {
        this.titulo = "Oferta 1";
        this.estado = "Finalizada";
        this.montoBase = 1355000;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getInicioPuja() {
        return inicioPuja;
    }

    public void setInicioPuja(Date inicioPuja) {
        this.inicioPuja = inicioPuja;
    }

    public Date getFinPuja() {
        return finPuja;
    }

    public void setFinPuja(Date finPuja) {
        this.finPuja = finPuja;
    }

    public Integer getMontoBase() {
        return montoBase;
    }

    public void setMontoBase(Integer montoBase) {
        this.montoBase = montoBase;
    }

    public Long getMontoCompra() {
        return montoCompra;
    }

    public void setMontoCompra(Long montoCompra) {
        this.montoCompra = montoCompra;
    }

    public Long getMontoPuja() {
        return montoPuja;
    }

    public void setMontoPuja(Long montoPuja) {
        this.montoPuja = montoPuja;
    }

    public Integer getMontoIncremento() {
        return montoIncremento;
    }

    public void setMontoIncremento(Integer montoIncremento) {
        this.montoIncremento = montoIncremento;
    }
}
