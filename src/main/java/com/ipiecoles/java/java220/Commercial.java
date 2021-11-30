package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Commercial extends Employe {
    private Double caAnnuel;
    private Integer performance;

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer perf) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
        this.performance = perf;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    @Override
    public Double getPrimeAnnuelle() {
        if(this.getCaAnnuel() == null)
            return 500d;
        Double resultat = this.getCaAnnuel() * 0.05;
        if(resultat < 500)
            return 500d;
        else
            return Math.ceil(resultat);
    }

    @Override
    public boolean equals(Object obj) {
        final Commercial c = (Commercial) obj;
        boolean employebool = super.equals(obj);
        if((c.getCaAnnuel() == null || this.getCaAnnuel() == null) && employebool == true) {
            if(c.getCaAnnuel() == null && this.getCaAnnuel() == null && employebool == true)
                return true;
            else
                return false;
        }
        else if(c.getCaAnnuel().equals(this.getCaAnnuel()) && employebool == true)
            return true;
        else
            return false;
    }

    public boolean performanceEgale(Integer perf) {
        if(perf.equals(this.getPerformance()))
            return true;
        else
            return false;
    }

    public Note equivalenceNote() {
        Note resultat;
        switch(this.performance) {
            case 0:
                resultat = Note.INSUFFISANT;
                break;
            case 50:
                resultat = Note.INSUFFISANT;
                break;
            case 100:
                resultat = Note.PASSABLE;
                break;
            case 150:
                resultat = Note.BIEN;
                break;
            case 200:
                resultat = Note.TRES_BIEN;
                break;
            default:
                resultat = null;
        }
        return resultat;
    }
}
