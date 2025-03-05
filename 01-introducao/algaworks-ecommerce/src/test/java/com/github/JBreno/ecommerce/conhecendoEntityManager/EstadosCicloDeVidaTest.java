package com.github.JBreno.ecommerce.conhecendoEntityManager;

import com.github.JBreno.ecommerce.EntityManagerTest;
import com.github.JBreno.ecommerce.model.Categoria;
import org.junit.Test;


public class EstadosCicloDeVidaTest extends EntityManagerTest {
    @Test
    public void analisarEstados() {
        Categoria categoriaNovo = new Categoria();
        Categoria categoriaGerenciadaMerge = entityManager.merge(categoriaNovo);
        Categoria categoriaGerenciada = entityManager.find(Categoria.class, 1);
    }
}
