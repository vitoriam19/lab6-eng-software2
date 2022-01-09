package ufmg.engsoftware.vitshop;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Peca> estoque;

    public Estoque () {

        estoque = new ArrayList<>(10);
    }

    public ArrayList<Peca> getEstoque() {
        return estoque;
    }

    public void addPeca(Peca peca){
        this.estoque.add(peca);
    }

    public void removePeca(Peca peca){
        this.estoque.remove(peca);
    }

    public int qntPecas() {
        return this.estoque.size();
    }

    public void percorreEstoque () {
        for(int i = 0 ; i < this.estoque.size(); i++) {
            System.out.println( i + " Peca do estoque tem ID " + this.estoque.get(i).getID() + " e Valor: " + this.estoque.get(i).getValor());
        }
    }

    public Peca achaPeca(int ID) throws Exception {
        for (Peca peca: estoque) {
            if(peca.getID() == ID){
                return peca;
            }
        }

        throw new Exception("Peca nao esta no estoque");
    }
}
