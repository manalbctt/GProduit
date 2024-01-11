package com.DevOps;

public class Produit {

    private Long id;       // Identifiant unique du produit
    private String nom;     // Nom du produit
    private double prix;    // Prix du produit
    private int quantite;   // Quantité du produit


    public Produit() {;
    }


    // Constructeur d'un nouveau Produit avec les paramètres spécifiés
    public Produit(final Long id, final String nom, final double prix, final int quantite) {
        this.setId(id);
        this.setNom(nom);
        this.setPrix(prix);
        this.setQuantite(quantite);
    }

    // Getters et setters suivent un ordre cohérent

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode pour obtenir le prix, avec vérification de non-négativité
    public double getPrix() {
        if (prix < 0) {
            throw new IllegalArgumentException("Le prix ne peut pas être négatif.");
        }
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Méthode pour obtenir la quantité, avec vérification de non-négativité
    public int getQuantite() {
        if (quantite < 0) {
            throw new IllegalArgumentException("La quantité ne peut pas être négative.");
        }
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Méthode toString pour afficher les informations du produit
    @Override
    public String toString() {
        return "Produit{id=" + id + ", nom='" + nom + "', prix=" + prix + ", quantite=" + quantite + '}';
    }
}

