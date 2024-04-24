public class Comete extends Astre {
    private Etoile etoile;

    public Comete(String nom, double diametre, Orbite orbite) {
        super(nom, diametre, orbite);
        this.etoile = null;
    }

    public Etoile getEtoile() {
        return etoile;
    }

    public void setEtoile(Etoile etoile) {
        if (this.etoile != null)
            throw new IllegalStateException("La comète " + nom + " est déjà en orbite autour de " + etoile.getNom());
        this.etoile = etoile;
    }

    public boolean estRetrograde() {
        return orbite.estRetrograde();
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

    @Override
    public String toString() {
        return nom + " (Comète) " + getPosition();
    }
}
