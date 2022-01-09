package ufmg.engsoftware.vitshop;

public class Manipulacoes {

    Estoque estoque = new Estoque();

    // Adiciona uma peca nova no estoque
    public Peca addPeca(int ID, int valor) throws Exception {

        if(estoque.qntPecas() == 10){
            throw new Exception("Capacidade maxima de pecas atingida");
        }

        Peca peca = new Peca(ID, valor);
        estoque.addPeca(peca);
        System.out.println("Peca " + ID + " adicionada com sucesso!!");
        return peca;
    }

    // Remove uma peca pelo seu ID
    public boolean removePeca(int ID) throws Exception {

        Peca peca = estoque.achaPeca(ID);
        estoque.removePeca(peca);
        System.out.println("Peca " + ID + " removida com sucesso!!");
        return true;
    }

    // Atualiza o valor da peca
    public boolean atualizaValorPeca(int ID, int valor) throws Exception {

        Peca peca = estoque.achaPeca(ID);
        peca.setValor(valor);
        System.out.println("Peca " + peca.getID() + " atualizada com sucesso!! Novo valor e de: " + peca.getValor());
        return true;


    }

}
