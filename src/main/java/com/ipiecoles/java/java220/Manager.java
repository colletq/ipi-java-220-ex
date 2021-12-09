package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.*;

public class Manager extends Employe {
    private HashSet equipe = new HashSet<>();

    public HashSet getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet equipe) {
        this.equipe = equipe;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire * Entreprise.INDICE_MANAGER + salaire * (this.getEquipe().size() * 0.1);
    }

    public void ajoutTechnicienEquipe(Technicien t) {
        this.getEquipe().add(t);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate date, Double salaire, Integer grade) {
        this.getEquipe().add(new Technicien(nom, prenom, matricule, date, salaire, grade));
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + this.getEquipe().size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
    }

    public void augmenterSalaire(Double coefficient_augmentation) {
        if(this.getSalaire() == null)
            this.salaire = null;
        else {
            augmenterSalaireEquipe(coefficient_augmentation);
            this.salaire = this.getSalaire() * (1 + coefficient_augmentation);
        }
    }

    private void augmenterSalaireEquipe(Double coefficient_augmentation) {
        for(Object o : this.getEquipe()) {
            o = (Technicien)o;
            ((Technicien) o).augmenterSalaire(coefficient_augmentation);
        }
    }

    public List equipeParGrade() {
        List<Technicien> result = new ArrayList();
        for(Object o : this.getEquipe()) {
            result.add((Technicien) o);
        }
        Comparator<Technicien> gradeComp = (Technicien t1, Technicien t2) ->  (t2.getGrade() - t1.getGrade());
        Collections.sort(result, gradeComp);
        return result;
    }
}
