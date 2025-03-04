package com.github.JBreno.ecommerce.relacionamentos;

import com.github.JBreno.ecommerce.EntityManagerTest;
import com.github.JBreno.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;


public class RelacionamentosOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setXml("TESTE");
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setPedido(pedido);

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getNotaFiscal());
    }

}
