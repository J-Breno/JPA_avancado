package com.github.JBreno.ecommerce.iniciandoComJpa;

import com.github.JBreno.ecommerce.EntityManagerTest;
import com.github.JBreno.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void inserirRegistro() {
        Cliente cliente = new Cliente();
        cliente.setId(3);
        cliente.setNome("João Souza");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);

    }

    @Test
    public void buscarRegistro() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Assert.assertNotNull(cliente);
        Assert.assertEquals("João Breno", cliente.getNome());
    }

    @Test
    public void atualizarRegistro() {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("João Melo");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteVerificacao);
        Assert.assertEquals("João Melo", clienteVerificacao.getNome());
    }

    @Test
    public void excluirRegistro() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNull(clienteVerificacao);
    }
}
