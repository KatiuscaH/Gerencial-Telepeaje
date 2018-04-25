package co.udec.gerencial.logica;

import java.util.Date;

public class RecargaTelepeaje {
    protected String placacarro;
    protected float valor;
    protected Date fechaRecarga;

    public RecargaTelepeaje(String placacarro, float valor) {
        this.placacarro = placacarro;
        this.valor = valor;
    }

    public RecargaTelepeaje(float valor, Date fechaRecarga) {
        this.valor = valor;
        this.fechaRecarga = fechaRecarga;
    } 

    public String getPlacacarro() {
        return placacarro;
    }

    public void setPlacacarro(String placacarro) {
        this.placacarro = placacarro;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getFechaRecarga() {
        return fechaRecarga;
    }
       
}
