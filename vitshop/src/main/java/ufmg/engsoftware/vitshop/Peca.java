package ufmg.engsoftware.vitshop;

public class Peca {

    private int ID;
    private int valor;

    public Peca(int ID, int valor) throws Exception {

        this.ID = ID;
        this.setValor(valor);
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

    public void setValor(int valor) throws Exception {

        if( valor < 0) {
            throw new Exception("Nao é possivel salvar um valor menor que zero");
        }

        // Regra de negocio: Só pode ser colocado valores multiplos de 50
        if(valor%50 != 0) {
            throw new Exception("So e possivel adicionar valores multiplos de 50");
        }

        this.valor = valor;
    }

}
