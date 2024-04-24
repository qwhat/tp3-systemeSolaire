public class Orbite {
    private static final double TAU = 2 * Math.PI;

    private double distance; // en millions de km
    private double angle; // en radians
    private double vitesseRevolution; // en radians par jour

    /**
     * Représente une orbite circulaire à partir de sa distance moyenne, son angle actuel et sa durée de révolution.
     * @param distance Distance moyenne de l'objet en orbite (en millions (10^6) de km).
     * @param angle Angle actuel de l'objet en orbite (en degrés).
     * @param dureeRevolution Durée de révolution de l'objet en orbite (en jours terriens).
     */
    public Orbite(double distance, double angle, double dureeRevolution) {
        if (distance < 0)
            throw new IllegalArgumentException("La distance doit être positive");
        this.distance = distance;
        this.angle = Math.toRadians(angle);
        this.vitesseRevolution = TAU / dureeRevolution;
    }

    /**
     * Créé une copie de l'orbite passée en paramètre.
     * @param source Orbite à copier.
     */
    public Orbite(Orbite source) {
        this.distance = source.distance;
        this.angle = source.angle;
        this.vitesseRevolution = source.vitesseRevolution;
    }

    public double getDistance() {
        return distance;
    }

    /**
     * Retourne l'angle actuel de cette orbite.
     * @return L'angle actuel de l'orbite, en degrés (entre 0 et 359.999).
     */
    public double getAngle() {
        return Math.toDegrees(angle % TAU); // Le modulo permet d'avoir une valeur entre 0 et 360.
    }

    /**
     * Retourne la vitesse de révolution de cette orbite. Elle sera négative si l'orbite est rétrograde (inverse).
     * @return La vitesse de révolution de l'orbite, en degrés par jour.
     */
    public double getVitesseRevolution() {
        return Math.toDegrees(vitesseRevolution);
    }

    /**
     * Indique si l'orbite est <a href="https://fr.wikipedia.org/wiki/Mouvement_prograde_ou_r%C3%A9trograde">rétrograde</a>
     * (ie. en sens inverse).
     * @return True si l'orbite est rétrograde.
     */
    public boolean estRetrograde() {
        return vitesseRevolution < 0;
    }

    /**
     * Permet d'obtenir les coordonnées cartésiennes de l'objet en orbite selon sa position angulaire actuelle.
     * @return Un objet Coordonnées représentant la position (x, y) relative de l'objet.
     */
    public Coordonnees getPosition() {
        return new Coordonnees(Math.cos(angle) * distance, Math.sin(angle) * distance);
    }

    /**
     * Permet de simuler le changement angulaire de l'orbite pendant la durée spécifiée.
     * @param duree Temps écoulé (en jours terriens).
     * @return L'objet Orbite actuel dont l'état a été modifié.
     */
    public Orbite avancer(long duree) {
        angle += duree * vitesseRevolution;
        return this;
    }
}
