package com.DevOps;

import java.util.ArrayList;
import java.util.List;

class ProduitService {
    private List<Produit> produits = new ArrayList<>();

    public boolean createProduit(Produit produit) {
        // Vérification d'unicité par ID et nom
        if (!produitExists(produit.getId()) && !nomExists(produit.getNom())) {
            // Validation des données
            if (produit.getPrix() >= 0 && produit.getQuantite() >= 0) {
                produits.add(produit);
                System.out.println("Produit ajouté avec succès.");
                return true;
            } else {
                System.out.println("Erreur : Prix ou quantité invalide.");
            }
        } else {
            System.out.println("Erreur : Produit avec le même ID ou nom existe déjà.");
        }
        return false;
    }

    public Produit readProduit(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return produit;
            }
        }
        System.out.println("Erreur : Produit non trouvé.");
        return null;
    }

    public void updateProduit(Produit produit) {
        if (produitExists(produit.getId())) {
            // Validation des données
            if (produit.getPrix() >= 0 && produit.getQuantite() >= 0) {
                int index = produits.indexOf(readProduit(produit.getId()));
                produits.set(index, produit);
                System.out.println("Produit mis à jour avec succès.");
            } else {
                System.out.println("Erreur : Prix ou quantité invalide.");
            }
        } else {
            System.out.println("Erreur : Produit non trouvé.");
        }
    }

    public void deleteProduit(Long id) {
        Produit produit = readProduit(id);
        if (produit != null) {
            produits.remove(produit);
            System.out.println("Produit supprimé avec succès.");
        }
    }

    private boolean produitExists(Long id) {
        return produits.stream().anyMatch(p -> p.getId().equals(id));
    }

    private boolean nomExists(String nom) {
        return produits.stream().anyMatch(p -> p.getNom().equals(nom));
    }
}
