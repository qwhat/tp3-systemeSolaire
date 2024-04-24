public class Coordonnees {
    public final double x, y;

    public Coordonnees() {
        this(0, 0);
    }

    public Coordonnees(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Additionne un objet Coordonnées avec un autre; Aucun des objets existants ne sont modifiés.
     * @param autre L'autre objet Coordonnées à ajouter à l'objet courant.
     * @return Un nouvel objet Coordonnées représentant la somme des deux.
     */
    public Coordonnees plus(Coordonnees autre) {
        return new Coordonnees(autre.x + x, autre.y + y);
    }

    /**
     * Compare deux objets Coordonnées pour indiquer s'ils sont (approximativement) identiques.
     * Les coordonnées sont considérées différentes si elles divergent de plus de 0.001 unités.
     * @param obj L'autre objet Coordonnées à comparer avec l'objet courant.
     * @return True si les deux coordonnées sont identiques; False sinon ou en cas d'erreur.
     */
    @Override
    public boolean equals(Object obj) {
        try {
            Coordonnees autre = (Coordonnees) obj;
            return Math.abs(autre.x - x) <= 0.001 && Math.abs(autre.y - y) <= 0.001;
        }
        catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("[%.5f, %.5f]", x, y);
    }
}
