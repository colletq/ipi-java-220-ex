package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
    protected String nom;
    protected String prenom;
    protected String matricule;
    protected LocalDate dateEmbauche;
    protected Double salaire;
    protected Boolean tempsPartiel;
    protected String sexe;

    public Employe() {
    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Boolean tempsPartiel, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
        this.tempsPartiel = tempsPartiel;
        this.sexe = sexe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        if(matricule == null) {
            return "";
        }
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if(dateEmbauche.isAfter(LocalDate.now())) {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        else {
            this.dateEmbauche = dateEmbauche;
        }
    }

    public boolean isTempsPartiel() {
        return tempsPartiel;
    }

    public void setTempsPartiel(boolean tempsPartiel) {
        this.tempsPartiel = tempsPartiel;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) throws Exception {
        if(sexe != "Homme" && sexe != "Femme")
            throw new Exception("L'attribut sexe de la classe employé ne peut prendre que les valeurs \"Homme\" ou \"Femme\"");
        else
            this.sexe = sexe;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public final Integer getNombreAnneeAnciennete() throws Exception {
        if(this.getDateEmbauche() == null) {
            throw new Exception("La date d'embauche est nulle");
        }
        else if(LocalDate.now().getYear() - this.getDateEmbauche().getYear() < 0) {
            throw new Exception("L'employé n'est pas encore embauché !");
        }
        else
            return LocalDate.now().getYear() - this.getDateEmbauche().getYear();
    }

    public Integer getNbConges() throws Exception {
        return Entreprise.NB_CONGES_BASE;
    }

    //"Employe{nom='nom', prenom='prenom', matricule='12345', dateEmbauche=1970-01-01, salaire=500.0}"
    @Override
    public String toString() {
        return "Employe{nom='"+this.nom+"', prenom='"+this.prenom+"', matricule='"+this.matricule+"', dateEmbauche="+this.getDateEmbauche()+", salaire="+this.salaire+", tempsPartiel="+this.tempsPartiel+", sexe='"+this.sexe+"'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Employe e = (Employe) obj;

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
        
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire, tempsPartiel, sexe);
    }

    public void augmenterSalaire(Double coefficient_augmentation) {
        this.setSalaire(this.getSalaire() + this.getSalaire() * coefficient_augmentation);
    }

    public Double getPrimeAnnuelle() throws Exception {
        return Entreprise.primeAnnuelleBase();
    }
}
