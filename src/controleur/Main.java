package controleur;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import modele.*;
import vue.*;

/** 
 * @author Alexis GUAY
 * @version 1.0.0
 * 01/12/2019 -- Création
 */
public class Main {

    private final Accueil screen;
    private final AccesData conn;
    private ArrayList<Zone> lesZones;

    /**
     * Constructeur de la classe Main.
     */
    public Main() {
        lesZones = new ArrayList<>();
        conn = new AccesData(this);
        screen = new Accueil(this);
        screen.setVisible(true);
    }

    /*
     * @return une collection d'objet Zone.
     */
    public ArrayList<Zone> getLesZones() {
        return lesZones;
    }

    /**
     * @return la date actuelle sous forme d'objet Date.
     */
    public Date getDateActuelle() {
        Date dateActuelle = new Date();

        return dateActuelle;
    }

    /**
     * @return la date d'hier sous forme d'objet Date.
     */
    public Date getHier() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        Date dateHier = c.getTime();
        
        return dateHier;
    }

    /**
     * @return l'heure actuelle sous forme de int.
     */
    public int getHeureActuelle() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("HH");
        String heureActuelle = format.format(date);
        int heure = Integer.parseInt(heureActuelle);
        
        return heure;
    }

    /**
     * @param Zones une collection de d'objet Zone.
     * @return une collection d'objet Releve
     * Methode permettant de recupérer la collection de tous les relevés de chaque zone présent en paramètre sur les 24 dernières heures
     */
    public ArrayList<Releve> getReleve(ArrayList<Zone> Zones) {
        ArrayList<Releve> lesReleve = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int heure = getHeureActuelle();
        String date = format.format(getDateActuelle());
        String hier = format.format(getHier());
        for (Zone laZone : lesZones) {
            for (Releve leReleve : laZone.getSesRelevé()) {
                if (Zones.contains(leReleve.getLaZone())) {
                    for (int j = heure+1 ; j < 24; j++) {
                        if (leReleve.getHeure_relev() == j && format.format(leReleve.getDate_relev()).equals(hier)) {
                            lesReleve.add(leReleve);
                        }
                    }
                    for (int i = heure; i > -1; i--) {
                        if (leReleve.getHeure_relev() == i && format.format(leReleve.getDate_relev()).equals(date)) {
                            lesReleve.add(leReleve);
                        }
                    }
                }
            }
        }
        return lesReleve;
    }

    /**
     * @param Zones une collection d'objet Zone.
     * @param dateDebut un objet Date.
     * @param dateFin un objet Date.
     * @return une collection d'objet Releve.
     * Methode permettant de recupérer la collection de tous les relevés de chaque zones présentent en paramétre entre les deux date indiqué.
     */
    public ArrayList<Releve> getReleve(ArrayList<Zone> Zones, Date dateDebut, Date dateFin) {
        ArrayList<Releve> lesReleve = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (Zone laZone : lesZones) {
            if (Zones.contains(laZone)) {
                for (Releve leReleve : laZone.getSesRelevé()) {
                    if (leReleve.getDate_relev().after(dateDebut) && leReleve.getDate_relev().before(dateFin)) {
                        if (!lesReleve.contains(leReleve)) {
                            lesReleve.add(leReleve);
                        }
                    } else if (format.format(dateFin).equals(format.format(leReleve.getDate_relev())) || format.format(dateDebut).equals(format.format(leReleve.getDate_relev()))) {
                        if (!lesReleve.contains(leReleve)) {
                            lesReleve.add(leReleve);
                        }
                    }
                }
            }
        }
        return lesReleve;
    }

    /**
     *
     * @param lesReleves une collection d'objet Releve.
     * @return la moyenne des tempéatures de chaque releve sous forme de Float.
     */
    public float getMoyenneTemperature(ArrayList<Releve> lesReleves) {
        float total = 0;
        for (Releve leReleve : lesReleves) {
            total = total + leReleve.getTemp_relev();
        }
        float moyenne = total / lesReleves.size();
        
        return moyenne;
    }

    /**
     * @param lesReleves une collection d'objet Releve
     * @return l'objet Releve qui possède la tempéature la plus élevé.
     */
    public Releve getMaxTemperature(ArrayList<Releve> lesReleves) {
        float max = -1000;
        Releve ReleveMax = null;
        for (Releve leReleve : lesReleves) {
            if (leReleve.getTemp_relev() > max) {
                max = leReleve.getTemp_relev();
                ReleveMax = leReleve;
            }
        }
        return ReleveMax;
    }

    /**
     * @param lesReleves une collection d'objet Releve
     * @return l'objet Releve qui possède la tempéature la plus faible.
     */
    public Releve getMinTemperature(ArrayList<Releve> lesReleves) {
        float min = 1000;
        Releve ReleveMin = null;
        for (Releve leReleve : lesReleves) {
            if (leReleve.getTemp_relev() < min) {
                min = leReleve.getTemp_relev();
                ReleveMin = leReleve;
            }
        }
        return ReleveMin;
    }
    
    /**
     * @param lesReleves une collection d'objet Releve
     * @param min un float
     * @param max un float
     * @return une collection d'objet Releve qui possède une température non comprise entre les seuils d'alerte minimal et maximal.
     */
    public ArrayList<Releve> getAlerte(ArrayList<Releve> lesReleves, float min, float max){
        ArrayList<Releve> lesAlertes = new ArrayList<>();
        for (Releve leReleve : lesReleves) {
            if(leReleve.getTemp_relev()>max || leReleve.getTemp_relev()<min){
                lesAlertes.add(leReleve);
            }
        }
        return lesAlertes;
    }
    
    /**
     * @param lesReleves une collection d'objet Releve
     * @return une collection de collection d'objet Releve
     * Methode qui permet de regrouper les releves par jour et par date dans les mêmes collections d'objet Releve.
     */
    public ArrayList<ArrayList<Releve>> getListStats(ArrayList<Releve> lesReleves) {
        ArrayList<ArrayList<Releve>> ListStats = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<String> lesDates = new ArrayList<>();

        for (Releve unreleve : lesReleves) {
            if (!lesDates.contains(format.format(unreleve.getDate_relev()))) {
                lesDates.add(new String(format.format(unreleve.getDate_relev())));
            }
        }
        
        for (String laDate : lesDates) {

            for (int i = 0; i < 24; i++) {
                ArrayList<Releve> mesReleves = new ArrayList<>();
                ListStats.add(mesReleves);
                for (Releve unReleve : lesReleves) {
                    if (laDate.equals(format.format(unReleve.getDate_relev())) && unReleve.getHeure_relev() == i) {
                        mesReleves.add(unReleve);
                    }
                    
                }
            }

        }

        return ListStats;
    }

    /**
     * @param id_zone un String
     * @return l'objet Zone qui possède cet identifiant de zone.
     */
    public Zone getZone(String id_zone) {
        for (Zone laZone : lesZones) {
            if (laZone.getId_zone().equals(id_zone)) {
                return laZone;
            }
        }
        return null;
    }

    /**
     *
     * @param args
     * @throws SQLException
     * Point d'entré de l'application
     */
    public static void main(String[] args) throws SQLException {
        Main main = new Main();

    }
}
