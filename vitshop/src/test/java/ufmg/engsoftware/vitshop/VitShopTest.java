package ufmg.engsoftware.vitshop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VitShopTest {

    public Manipulacoes manipulacao = new Manipulacoes();

    @Before
    public void init() throws Exception {
        int ID = 1;
        int valor = 100;

        for(int i=0; i<9; i++){
            manipulacao.addPeca(ID, valor);
            ID++;
            valor+=100;
        }
    }

    @Test
    public void testAddPecaComSucesso() throws Exception {
        Peca peca = manipulacao.addPeca(11, 1100);
        assertEquals(peca.getID(), 11);
        assertEquals(peca.getValor(), 1100);
    }

    @Test
    public void testAddAlemDaCapacidadeMaximaException(){
        Exception e = null;

        try {
            manipulacao.addPeca(11, 1100);
            manipulacao.addPeca(12, 1200);
        } catch (Exception ex) {
            e = ex;
        }

        String messageFalhaAdicaoPeca = "Capacidade maxima de pecas atingida";
        assertEquals(e.getMessage(), messageFalhaAdicaoPeca);
    }

    @Test
    public void testAchaPecaNaoExistenteException() {
        Exception e = null;

        try {
            manipulacao.estoque.achaPeca(1202);
        } catch (Exception ex) {
            e = ex;
        }

        String messagePecaNaoEstaNoEstoque = "Peca nao esta no estoque";
        assertEquals(e.getMessage(), messagePecaNaoEstaNoEstoque);
    }

    @Test
    public void testRemovePecaComSucesso() throws Exception {
        assertTrue(manipulacao.removePeca(2));
    }

    @Test
    public void testAtualizaValorComSucesso() throws Exception {
        assertTrue(manipulacao.atualizaValorPeca(1,125));
        int valor = manipulacao.estoque.achaPeca(1).getValor();
        assertEquals(valor, 125);
    }
}
