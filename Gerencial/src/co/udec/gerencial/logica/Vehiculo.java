package co.udec.gerencial.logica;

public class Vehiculo {
    protected String placa;
    protected int categoria;
    protected float saldo;

    public Vehiculo (String placa, int categoria, float saldo) {
        this.placa = placa;
        this.categoria = categoria;
        this.saldo = saldo;
    }
    
    public Vehiculo (int categoria, float saldo) {
        this.categoria = categoria;
        this.saldo = saldo;
    }

    public Vehiculo(String placa, int categoria) {
        this.placa = placa;
        this.categoria = categoria;
    }
    
     public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", categoria=" + categoria + ", saldo=" + saldo + '}';
    }    
}
