package co.udec.gerencial.logica;

public class CobroTelepeaje {
    public static String placacarro;
    protected int categoria;
    protected float valorCT;

    public CobroTelepeaje(String placacarro, int categoria, float valorCT) {
        CobroTelepeaje.placacarro = placacarro;
        this.categoria = categoria;
        this.valorCT = valorCT;
    }

    public CobroTelepeaje(float valorCT) {
        this.valorCT = valorCT;
    }    

    public CobroTelepeaje(int categoria, float valorCT) {
        this.categoria = categoria;
        this.valorCT = valorCT;
    }

    public String getPlacacarro() {
        return placacarro;
    }

    public void setPlacacarro(String placacarro) {
        CobroTelepeaje.placacarro = placacarro;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public float getValorCT() {
        return valorCT;
    }

    public void setValorCT(float valorCT) {
        this.valorCT = valorCT;
    }
    
}
