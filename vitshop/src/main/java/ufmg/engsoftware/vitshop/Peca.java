package ufmg.engsoftware.vitshop;

public class Peca {

    private int ID;
    private int valor;

    public Peca(int ID, int valor) {

        this.ID = ID;
        this.valor = valor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
