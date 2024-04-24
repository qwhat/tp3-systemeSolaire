import java.util.Date;
import java.util.List;

public abstract class Astre implements Comparable<Astre> {
    public final String nom;
    public final double diametre; // en km

    protected Orbite orbite;
    protected List<Astre> satellites;

    public Astre(String nom, double diametre, Orbite orbite) {
        this.nom = nom;
        this.diametre = diametre;
        this.orbite = orbite;
        this.satellites = null;
    }

    public String getNom() {
        return nom;
    }

    public double getDiametre() {
        return diametre;
    }

    public Orbite getOrbite() {
        return orbite;
    }

    protected List<Astre> getSatellites() {
        return satellites;
    }

    public abstract Coordonnees getPosition();
    protected abstract Coordonnees getPosition(long dureeJours);
    public Coordonnees getPosition(Date date) {
        Date now = new Date();
        long duree_ms = date.getTime() - now.getTime();
        return getPosition(duree_ms / (24 * 60 * 60 * 1000));
    }

    @Override
    public int compareTo(Astre autre) {
        double distance = this.orbite.getDistance() - autre.orbite.getDistance();
        return (int)Math.round(distance);
    }
}
