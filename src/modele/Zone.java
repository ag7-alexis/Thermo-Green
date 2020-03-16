package modele;

import java.util.ArrayList;

/**
 * @author Alexis GUAY
 * @version 1.0.0
 * 01/12/2019 -- Création
 */
public class Zone {
    private String id_zone;
    private String nom_zone;
    private ArrayList<Releve> sesRelevé;

    /**
     *
     * @param id_zone l'identifiant de la zone
     * @param nom_zone le nom de la zone
     * @param sesRelevé la collection d'objet Releve de la zone
     * Constructeur de l'objet zone
     */
    public Zone(String id_zone, String nom_zone, ArrayList<Releve> sesRelevé) {
        this.id_zone = id_zone;
        this.nom_zone = nom_zone;
        this.sesRelevé = sesRelevé;
    }
    
    /**
     * @param id_zone l'identifiant de la zone
     * @param nom_zone le nom de la zone
     * Constructeur de l'objet zone
     */
    public Zone(String id_zone, String nom_zone) {
        this.id_zone = id_zone;
        this.nom_zone = nom_zone;
        this.sesRelevé = new ArrayList<>();
    }

    /**
     * @return l'identifiant de la zone
     */
    public String getId_zone() {
        return id_zone;
    }

    /**
     * @param id_zone un string
     * ajoute un identifiant à un objet Zone
     */
    public void setId_zone(String id_zone) {
        this.id_zone = id_zone;
    }

    /**
     * @return le nom de la zone

     */
    public String getNom_zone() {
        return nom_zone;
    }

    /**
     * @param nom_zone un String
     * ajoute un nom à un objet Zone
     */
    public void setNom_zone(String nom_zone) {
        this.nom_zone = nom_zone;
    }

    /**
     * @return la collection d'objet Releve de la zone
     */
    public ArrayList<Releve> getSesRelevé() {
        return sesRelevé;
    }

    /**
     * @param sesRelevé une collection d'objet Releve
     * ajoute une collection d'objet Releve à un objet Zone
     */
    public void setSesRelevé(ArrayList<Releve> sesRelevé) {
        this.sesRelevé = sesRelevé;
    }

    @Override
    public String toString() {
        return "Zone{" + "id_zone=" + id_zone + ", nom_zone=" + nom_zone + ", sesRelev\u00e9=" + sesRelevé + '}';
    }
    
    
    
    
    
}
