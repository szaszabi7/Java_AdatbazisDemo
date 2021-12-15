package org.example.AdatbazisMaven;

import java.sql.SQLException;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        try {
            Adatbazis db = new Adatbazis();
            List<Dolgozo> dolgozoLista = db.dolgozokListazasa();
            for (Dolgozo dolgozo: dolgozoLista) {
                System.out.println(dolgozo);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
