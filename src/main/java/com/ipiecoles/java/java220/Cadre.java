package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Cadre extends Employe {
    private Double coefficient;

    public Cadre() {
        this.coefficient = 1d;
    }

    public Cadre(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Cadre(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double coefficient) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.coefficient = coefficient;
    }

    public Cadre(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Boolean tempsPartiel, String sexe, Double coefficient) {
        super(nom, prenom, matricule, dateEmbauche, salaire, tempsPartiel, sexe);
        this.coefficient = coefficient;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() * this.getCoefficient();
    }

    public Integer getNbConges() throws Exception {
        Double bonusConges = Math.ceil(this.getCoefficient());
        return super.getNbConges() + bonusConges.intValue();
    }

    public String toString() {
        return "Employe{nom='" + this.nom + "', prenom='" + this.prenom + "', matricule='" + this.matricule + "', dateEmbauche=" + this.getDateEmbauche() + ", salaire=" + this.salaire + ", tempsPartiel=" + this.tempsPartiel + ", sexe='" + this.sexe + "', coefficient=" + this.coefficient + "}";
    }

    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire, tempsPartiel, sexe, coefficient);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Cadre e = (Cadre) obj;

        if(this.getNom() == null && e.getNom() != null)
            return false;

        if(this.getNom() != null && e.getNom() == null)
            return false;

        if(this.getNom() == null && e.getNom() == null)
            return false;

        if(!(this.getNom().equals(e.getNom())))
            return false;

        if(this.getPrenom() == null && e.getPrenom() != null)
            return false;

        if(this.getPrenom() != null && e.getPrenom() == null)
            return false;

        if(this.getPrenom() == null && e.getPrenom() == null)
            return false;

        if(!(this.getPrenom().equals(e.getPrenom()))) {
            return false;
        }

        if(this.getMatricule() == null && e.getMatricule() != null)
            return false;

        if(this.getMatricule() != null && e.getMatricule() == null)
            return false;

        if(this.getMatricule() == null && e.getMatricule() == null)
            return false;

        if(!(this.getMatricule().equals(e.getMatricule()))) {
            return false;
        }

        if(this.getSalaire() == null && e.getSalaire() != null)
            return false;

        if(this.getSalaire() != null && e.getSalaire() == null)
            return false;

        if(this.getSalaire() == null && e.getSalaire() == null)
            return false;

        if(!(this.getSalaire().equals(e.getSalaire()))) {
            return false;
        }

        if(this.getDateEmbauche() == null && e.getDateEmbauche() != null)
            return false;

        if(this.getDateEmbauche() != null && e.getDateEmbauche() == null)
            return false;

        if(this.getDateEmbauche() == null && e.getDateEmbauche() == null)
            return false;

        if(!(this.getDateEmbauche().equals(e.getDateEmbauche()))) {
            return false;
        }

        if(this.getSexe() == null && e.getSexe() != null)
            return false;

        if(this.getSexe() != null && e.getSexe() == null)
            return false;

        if(this.getSexe() == null && e.getSexe() == null)
            return false;

        if(!(this.getSexe().equals(e.getSexe()))) {
            return false;
        }

        if(!(this.isTempsPartiel() == e.isTempsPartiel())) {
            return false;
        }

        if(this.getCoefficient() == null && e.getCoefficient() != null)
            return false;

        if(this.getCoefficient() != null && e.getCoefficient() == null)
            return false;

        if(this.getCoefficient() == null && e.getCoefficient() == null)
            return false;

        if(!(this.getCoefficient().equals(e.getCoefficient()))) {
            return false;
        }

        return true;
    }
}
