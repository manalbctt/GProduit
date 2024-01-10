package com.DevOps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProduitServiceTest {

    @Test
    void testCreateProduit() {
        ProduitService produitService = new ProduitService();

        Produit produit1 = new Produit(1L, "Produit A", 20.0, 50);
        produitService.createProduit(produit1);

        Produit produit2 = new Produit(2L, "Produit B", 25.0, 30);

        assertTrue(produitService.createProduit(produit2));
        assertFalse(produitService.createProduit(produit1)); // Produit déjà existant
    }

    @Test
    void testReadProduit() {
        ProduitService produitService = new ProduitService();

        Produit produit1 = new Produit(1L, "Produit A", 20.0, 50);
        produitService.createProduit(produit1);

        Produit produitLu = produitService.readProduit(1L);
        assertNotNull(produitLu);
        assertEquals("Produit A", produitLu.getNom());

        Produit produitNonExistant = produitService.readProduit(2L);
        assertNull(produitNonExistant);
    }

    @Test
    void testUpdateProduit() {
        ProduitService produitService = new ProduitService();

        Produit produit1 = new Produit(1L, "Produit A", 20.0, 50);
        produitService.createProduit(produit1);

        Produit produitUpdate = new Produit(1L, "Produit A Modifié", 25.0, 60);
        produitService.updateProduit(produitUpdate);

        Produit produitLu = produitService.readProduit(1L);
        assertNotNull(produitLu);
        assertEquals("Produit A Modifié", produitLu.getNom());
        assertEquals(25.0, produitLu.getPrix(), 0.001);
        assertEquals(60, produitLu.getQuantite());
    }

    @Test
    void testDeleteProduit() {
        ProduitService produitService = new ProduitService();

        Produit produit1 = new Produit(1L, "Produit A", 20.0, 50);
        produitService.createProduit(produit1);

        produitService.deleteProduit(1L);
        assertNull(produitService.readProduit(1L)); // Vérifie que le produit a été supprimé
    }
}

