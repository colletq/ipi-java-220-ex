package com.ipiecoles.java.java220;

public class TechnicienException extends Exception {
    private String message;

    public TechnicienException(Technicien t, int mauvaisGrade) {
        this.message = "Le grade doit être compris entre 1 et 5 : "+mauvaisGrade+", technicien : "+t;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
