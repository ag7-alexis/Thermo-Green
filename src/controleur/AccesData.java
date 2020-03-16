package controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import modele.*;

/**
 * @author Alexis GUAY
 * @version 1.0.0
 * 01/12/2019 -- Création
 */
public class AccesData {
    private final Main main;
    private final String url = "jdbc:postgresql://localhost/DB_Vinci";
    private final String user = "vinci_user";
    private final String password = "***";
    
    /**
     * @param main
     * Constructeur de l'accès à la base de données
     */
    public AccesData(Main main){
        this.main = main;
        updateLesZones();
    }

    /**
     * @return une connexion
     * @throws SQLException
     * Connexion à la base de données
     */
    public Connection connect() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection DB -->" + e.getMessage());
        }

        return conn;
    }
   
    /**
     * Methode qui permet la récupération des différentes zones ainsi que tous les relevé qui leurs sont associés.
     * Elle construit donc  objet Zone et rempli leur collection d'objet Releve à partir de la base de données.
     */
    public void updateLesZones(){
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM ZONE;");
            while (rs.next()) {
                String id_zone = rs.getString("id_zone");
                String nom_zone = rs.getString("nom_zone");
                
                Zone zone = new Zone(id_zone, nom_zone);
                
                Statement stmt2 = conn.createStatement();
                
                ResultSet rs2 = stmt2.executeQuery("SELECT * FROM RELEVE WHERE id_zone = '"+id_zone+"';");
                while (rs2.next()){
                    int id_relev = rs2.getInt("id_relev");
                    Date date_relev = rs2.getDate("date_relev");
                    int heure_relev = rs2.getInt("heure_relev");
                    float temp_relev = rs2.getFloat("temp_relev");
                    zone.getSesRelevé().add(new Releve(id_relev, date_relev, heure_relev, temp_relev, zone));
                }
                this.main.getLesZones().add(zone);
                stmt2.close();
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("GET DATA --> " + e.getMessage());
        }
    }
    
    
    
    
}
