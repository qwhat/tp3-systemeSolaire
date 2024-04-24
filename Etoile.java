import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Etoile extends Astre {
    private double temperature; // en Kelvin

    public Etoile(String nom, double diametre, double temperature) {
        super(nom, diametre, null);
        super.satellites = new LinkedList<>();

        if (temperature < 0)
            throw new IllegalArgumentException("La température doit être positive");
        else
            this.temperature = temperature;
    }

    @Override // Seulement pour changer la visibilité de la méthode.
    public List<Astre> getSatellites() {
        return super.getSatellites();
    }

    @Override
    public Coordonnees getPosition() {
        return new Coordonnees();
    }

    @Override
    public Coordonnees getPosition(long dureeJours) {
        return getPosition();
    }

    public double getTemperature() {
        return temperature;
    }

    public int getNbCometes() {
        int nb = 0;
        for (Astre astre : satellites)
            if (astre instanceof Comete)
                nb++;
        return nb;
    }

    public int getNbPlanetes() {
        int nb = 0;
        for (Astre astre : satellites)
            if (astre instanceof Planete)
                nb++;
        return nb;
    }

    public Comete ajouterComete(String nom, double diametre, Orbite orbite) {
        Comete comete = new Comete(nom, diametre, orbite);
        comete.setEtoile(this);
        satellites.add(comete);
        Collections.sort(satellites);
        return comete;
    }

    public Planete ajouterPlanete(String nom, double diametre, Orbite orbite) {
        Planete planete = new Planete(nom, diametre, orbite, this);
        satellites.add(planete);
        Collections.sort(satellites);
        return planete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nom + " (Étoile) " + getPosition());
        for (Astre astre : satellites)
            sb.append("\n\t").append(astre);
        return sb.toString();
    }
}
