/* INSCRIVEZ VOTRE OU VOS NOMS CI-DESSOUS:
1.
2.
 */
public class SystemeSolaire {
    public static void main(String[] args) {
        // Source des données: https://nssdc.gsfc.nasa.gov/planetary/factsheet/
        Etoile soleil = new Etoile("Sol", 1.989e30, 5772);

        Comete halley = soleil.ajouterComete("Halley", 11.0,
                new Orbite(2677, 0, 27791));

        Planete mercure = soleil.ajouterPlanete("Mercure", 4879,
                        new Orbite(57.9, 0, 88)),
                venus = soleil.ajouterPlanete("Venus", 12104,
                        new Orbite(108.2, 90, 225)),
                terra = soleil.ajouterPlanete("Terra", 12756,
                        new Orbite(149.6, 180, 365)),
                mars = soleil.ajouterPlanete("Mars", 6792,
                        new Orbite(228.0, 270, 687)),
                jupiter = soleil.ajouterPlanete("Jupiter", 142984,
                        new Orbite(778.5, 20, 4331)),
                saturn = soleil.ajouterPlanete("Saturne", 120536,
                        new Orbite(149.6, 180, 10747)),
                uranus = soleil.ajouterPlanete("Uranus", 51118,
                        new Orbite(228.0, 270, 30589)),
                neptune = soleil.ajouterPlanete("Neptune", 49528,
                        new Orbite(778.5, 20, 59800));

        Lune    luna = new Lune("Luna", 3475,
                        new Orbite(0.384, 0, 27.3), terra),
                phobos = new Lune("Phobos", 22.533,
                        new Orbite(0.00938, 0, 0.318), mars),
                deimos = new Lune("Deimos", 12.4,
                        new Orbite(0.02346, 0, 1.262), mars);

        terra.ajouterLune(luna);
        mars.ajouterLune(phobos);
        mars.ajouterLune(deimos);
        // Et les lunes de jupiter: Io, Europa, Ganymède, Callisto...

        System.out.println("Notre système solaire:");
        System.out.println(soleil);

        System.out.println("\nTempérature du soleil: " + soleil.getTemperature());
        System.out.println("Il y a " + soleil.getNbPlanetes() + " planètes en orbite autour du soleil");
        System.out.println("On compte " + soleil.getNbCometes() + " comètes en orbite autour du soleil");

        System.out.println("\nLa planète Mars est en orbite autour de: " + mars.getEtoile().getNom());
        System.out.println("Diamètre de la planète Mars: " + mars.getDiametre());
        System.out.println("Il y a " + mars.getNbLunes() + " lunes en orbite autour de Mars: " + mars.getLunes());

        System.out.println("\nDans un an (365 jours), ces astres seront aux positions suivantes:");
        System.out.println(soleil.getNom() + ": " + soleil.getPosition(365));
        System.out.println(terra.getNom() + ": " + terra.getPosition(365));
        System.out.println(luna.getNom() + ": " + luna.getPosition(365));
        System.out.println(venus.getNom() + ": " + venus.getPosition(365));
    }
}
