import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Planete extends Astre {
    private final Etoile etoile;

    public Planete(String nom, double diametre, Orbite orbite, Etoile etoile) {
        super(nom, diametre, orbite);
        super.satellites = new ArrayList<>();
        this.etoile = etoile;
    }

    public Etoile getEtoile() {
        return etoile;
    }

    @Override
    public Coordonnees getPosition() {
        return etoile.getPosition().plus(orbite.getPosition());
    }

    @Override
    public Coordonnees getPosition(long dureeJours) {
        Orbite futur = new Orbite(orbite);
        futur.avancer(dureeJours);
        return etoile.getPosition(dureeJours).plus(futur.getPosition());
    }

    public List<Astre> getLunes() {
        return getSatellites();
    }

    public int getNbLunes() {
        return satellites.size();
    }

    public void ajouterLune(Lune lune) {
        if (lune.getPlanete() != this)
            throw new IllegalStateException(String.format("La lune %s est déjà en orbite autour de %s",
                    lune.getNom(), lune.getPlanete().getNom()));
        if (lune.getOrbite().getDistance() >= this.getOrbite().getDistance())
            throw new IllegalArgumentException(String.format("La lune %s a une orbite trop grande pour %s",
                    lune.getNom(), nom));
        satellites.add(lune);
        Collections.sort(satellites);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nom + " (Planète) " + getPosition());
        for (Astre astre : satellites)
            sb.append("\n\t\t").append(astre);
        return sb.toString();
    }
}
