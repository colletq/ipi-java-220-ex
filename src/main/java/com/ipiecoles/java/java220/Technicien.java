package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Technicien extends Employe implements Comparable<Technicien>{
    private Integer grade;

    public Integer getGrade() {
        if(grade == null)
            return 0;
        else
            return grade;
    }

    public void setGrade(Integer grade) throws TechnicienException {
        if(grade.equals(0) || grade > 5)
            throw new TechnicienException(this, grade);
        else
            this.grade = grade;
    }

    public Technicien() {

    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    public Double getSalaire() {
        if(salaire != null)
            return this.salaire;
            //return this.salaire + ((double)this.getGrade()/10) * this.salaire;
        else
            return 0d;
    }

    public Integer getNbConges() throws Exception {
        return super.getNbConges() + super.getNombreAnneeAnciennete();
    }

    @Override
    public String toString() {
        return "Technicien{grade="+this.getGrade()+"} Employe{nom='"+this.getNom()+"', prenom='"+this.getPrenom()+"', matricule='"+this.getMatricule()+"', dateEmbauche="+this.getDateEmbauche()+", salaire="+this.getSalaire()+"}";
    }

    public Double getPrimeAnnuelle() throws Exception {
        return Entreprise.primeAnnuelleBase() * (1+(double)this.getGrade()/10) + super.getNombreAnneeAnciennete() * Entreprise.PRIME_ANCIENNETE;
    }

    @Override
    public int compareTo(Technicien o) {
        if(this.getGrade() > o.getGrade())
            return 1;
        else if(this.getGrade() < o.getGrade())
            return -1;
        else
            return 0;
    }
}
