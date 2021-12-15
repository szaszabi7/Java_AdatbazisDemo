package org.example.AdatbazisMaven;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Adatbazis {
    private static final String url = "jdbc:mysql://localhost:3306/dolgozok";
    private static final String username = "root";
    private static final String password = "";

    private Connection conn;

    public Adatbazis() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public List<Dolgozo> dolgozokListazasa() throws SQLException {
        List<Dolgozo> dolgozoLista = new ArrayList<>();
        String sql = "SELECT * FROM dolgozok";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            int id = result.getInt("id");
            int kor = result.getInt("kor");
            int fizetes = result.getInt("fizetes");
            String nev = result.getString("nev");
            String nem = result.getString("nem");
            Dolgozo dolgozo = new Dolgozo(id, nev, nem, kor, fizetes);
            dolgozoLista.add(dolgozo);
        }
        return dolgozoLista;
    }
}
