package com.ipiecoles.java.java220;

import java.util.HashSet;
import java.util.List;

public class main {
    public static void
    main(String[] args) {

        Technicien t1 = new Technicien(null, null, null, null, 0.0, 1);
        Technicien t2 = new Technicien(null, null, null, null, 0.0, 2);
        Technicien t3 = new Technicien(null, null, null, null, 0.0, 3);

        Manager m = new Manager();
        m.ajoutTechnicienEquipe(t1);
        m.ajoutTechnicienEquipe(t2);
        m.ajoutTechnicienEquipe(t3);

        Object o = m.equipeParGrade();
        System.out.println(o);
        List l = (List) o;
        System.out.println(l.size());






    }
}
