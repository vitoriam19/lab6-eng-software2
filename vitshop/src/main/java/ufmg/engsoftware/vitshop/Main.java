package ufmg.engsoftware.vitshop;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws Exception {
        Manipulacoes map = new Manipulacoes();
        map.addPeca(1,100);
        map.addPeca(2,200);
        map.addPeca(3,300);

        map.atualizaValorPeca(1,110);

        map.removePeca(2);

       map.estoque.percorreEstoque();
    }
}
