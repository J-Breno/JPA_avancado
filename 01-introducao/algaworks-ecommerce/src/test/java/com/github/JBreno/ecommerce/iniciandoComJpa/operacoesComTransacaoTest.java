package com.github.JBreno.ecommerce.iniciandoComJpa;

import com.github.JBreno.ecommerce.EntityManagerTest;
import com.github.JBreno.ecommerce.model.Produto;
import org.junit.Test;

public class operacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void abrirFecharTransacao() {
        Produto produto = new Produto(); // para o método não mostrar erros

        entityManager.getTransaction().begin();

//        entityManager.persist(produto);
//        entityManager.merge(produto);
//        entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }

}
