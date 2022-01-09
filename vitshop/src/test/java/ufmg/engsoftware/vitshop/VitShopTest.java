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
            manipulacao.addPeca(12, 1500);
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
            manipulacao.estoque.achaPeca(1200);
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
        assertTrue(manipulacao.atualizaValorPeca(1,1200));
        int valor = manipulacao.estoque.achaPeca(1).getValor();
        assertEquals(valor, 1200);
    }

    @Test
    public void testQuantidadePecas() throws Exception {
        int quantidadePecas = manipulacao.estoque.qntPecas();
        manipulacao.addPeca(15, 1500);
        assertEquals(manipulacao.estoque.qntPecas(), quantidadePecas+1);

    }

    @Test
    public void testFalhaAoCriarPecaComValorNegativo() {
        Exception e = null;

        try {
            Peca peca = new Peca(22, -134);
        } catch (Exception ex) {
            e = ex;
        }

        String messageFalhaAoCriarPecaDeValorNegativo = "Nao é possivel salvar um valor menor que zero";
        assertEquals(e.getMessage(), messageFalhaAoCriarPecaDeValorNegativo);
    }

    @Test
    public void testAddPecaComMesmoID() {
        Exception e = null;

        try {
            manipulacao.addPeca(5, 1500);
        } catch (Exception ex) {
            e = ex;
        }

        String messageFalhaAoTentaAdicionarPecaComMesmoId = "Nao e possivel adicionar outra peca com o mesmo ID";
        assertEquals(e.getMessage(), messageFalhaAoTentaAdicionarPecaComMesmoId);
    }

    @Test
    public void testAdicionaValorMultiploDe50ComSucesso() throws Exception {
        Peca peca = new Peca(89, 2000);
        assertEquals(peca.getValor(), 2000);
    }

    @Test
    public void testFalhaAoAdicionarValorNaoMultiploDe50() {
        Exception e = null;

        try {
            Peca peca = new Peca(80, 123);
        } catch (Exception ex) {
            e = ex;
        }

        String messageFalhaAoAdicionarNaoMultiploDe50 = "So e possivel adicionar valores multiplos de 50";
        assertEquals(e.getMessage(), messageFalhaAoAdicionarNaoMultiploDe50);
    }
}
