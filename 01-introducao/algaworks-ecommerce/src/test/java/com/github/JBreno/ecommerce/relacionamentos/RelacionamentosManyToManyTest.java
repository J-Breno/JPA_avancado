package com.github.JBreno.ecommerce.relacionamentos;

import com.github.JBreno.ecommerce.EntityManagerTest;
import com.github.JBreno.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;


public class RelacionamentosManyToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){
        Produto produto = entityManager.find(Produto.class, 1);
        Categoria categoria = entityManager.find(Categoria.class, 1);

        entityManager.getTransaction().begin();
        produto.setCategorias(Arrays.asList(categoria));
        entityManager.getTransaction().commit();

        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
        Assert.assertFalse(categoriaVerificacao.getProdutos().isEmpty());
    }

}
