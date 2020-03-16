package modele;

import java.util.Date;

/**
 * @author Alexis GUAY
 * @version 1.0.0
 * 01/12/2019 -- Création
 */
public class Releve {
    private int id_relev;
    private Date date_relev;
    private int heure_relev;
    private float temp_relev;
    private Zone laZone;

    /**
     * @param id_relev l'identifiant du relevé
     * @param date_relev la date du relevé
     * @param heure_relev l'heure du relevé
     * @param temp_relev la température du relevé
     * @param laZone l'objet zone qui correspond à la zone où a etait realisé le relevé
     * Constructeur de l'objet Releve
     */
    public Releve(int id_relev, Date date_relev, int heure_relev, float temp_relev, Zone laZone) {
        this.id_relev = id_relev;
        this.date_relev = date_relev;
        this.heure_relev = heure_relev;
        this.temp_relev = temp_relev;
        this.laZone = laZone;
    }

    /**
     * @return l'identifiant du relevé
     */
    public int getId_relev() {
        return id_relev;
    }

    /**
     * @param id_relev un int
     * ajoute un identifiant à l'objet Releve
     */
    public void setId_relev(int id_relev) {
        this.id_relev = id_relev;
    }

    /**
     * @return la date du relevé
     */
    public Date getDate_relev() {
        return date_relev;
    }

    /**
     * @param date_relev une Date
     * ajoute une date à l'objet Releve
     */
    public void setDate_relev(Date date_relev) {
        this.date_relev = date_relev;
    }

    /**
     * @return l'heure du relevé
     */
    public int getHeure_relev() {
        return heure_relev;
    }

    /**
     * @param heure_relev un int
     * ajoute une heure à l'objet Releve
     */
    public void setHeure_relev(int heure_relev) {
        this.heure_relev = heure_relev;
    }

    /**
     * @return la température du relevé
     */
    public float getTemp_relev() {
        return temp_relev;
    }

    /**
     * @param temp_relev un float
     * ajoute une température à l'objet Releve
     */
    public void setTemp_relev(float temp_relev) {
        this.temp_relev = temp_relev;
    }

    /**
     * @return la zone du relevé
     */
    public Zone getLaZone() {
        return laZone;
    }

    /**
     * @param laZone une zone
     * ajoute une zone à l'objet Releve
     */
    public void setLaZone(Zone laZone) {
        this.laZone = laZone;
    }

    @Override
    public String toString() {
        return "Releve{" + "id_relev=" + id_relev + ", date_relev=" + date_relev + ", heure_relev=" + heure_relev + ", temp_relev=" + temp_relev + ", laZone=" + laZone.getNom_zone() + '}';
    }
    
    
    
    
    
    
    
}
