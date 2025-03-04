package com.github.JBreno.ecommerce.mapeamentoBasico;

import com.github.JBreno.ecommerce.EntityManagerTest;
import com.github.JBreno.ecommerce.model.Cliente;
import com.github.JBreno.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class MapeamentoEnumeracoesTest extends EntityManagerTest {

    @Test
    public void testarEnum() {
        Cliente cliente = new Cliente();
        cliente.setId(4);
        cliente.setNome("Arielle");
        cliente.setSexo(SexoCliente.FEMININO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);

    }

}
