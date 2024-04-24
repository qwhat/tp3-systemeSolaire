public class Lune extends Astre {
    private final Planete planete;

    public Lune(String nom, double diametre, Orbite orbite, Planete planete) {
        super(nom, diametre, orbite);
        this.planete = planete;
    }

    @Override
    public Coordonnees getPosition() {
        return planete.getPosition().plus(orbite.getPosition());
    }

    @Override
    public Coordonnees getPosition(long dureeJours) {
        Orbite futur = new Orbite(orbite);
        futur.avancer(dureeJours);
        return planete.getPosition(dureeJours).plus(futur.getPosition());
    }

    public Planete getPlanete() {
        return planete;
    }

    @Override
    public String toString() {
        return nom + " (Lune) " + getPosition();
    }
}
