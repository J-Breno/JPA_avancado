package com.github.JBreno.ecommerce.conhecendoEntityManager;

import com.github.JBreno.ecommerce.EntityManagerTest;
import com.github.JBreno.ecommerce.model.Pedido;
import com.github.JBreno.ecommerce.model.StatusPedido;
import org.junit.Test;

public class GerenciamentoTransacoesTest extends EntityManagerTest {
    @Test(expected = Exception.class)
    public void abrirFecharCancelarTransacao() {
        try {
            entityManager.getTransaction().begin();
            metodoDeNegocio();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void metodoDeNegocio() {
        Pedido pedido = entityManager.find(Pedido.class, 1);
        pedido.setStatus(StatusPedido.PAGO);

        if(pedido.getPagamento() == null) {
            throw new RuntimeException("Pedido anida não foi pago");
        }
    }
}
