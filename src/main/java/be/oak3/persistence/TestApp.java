package be.oak3.persistence;

import be.oak3.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TestApp {

    private static final Logger LOGGER   = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.printf("Oplossing van %s %s\n", "Kenneth Van Gijsel ",
                "Java Instructeur");

        Bestelling bestelling = new BestellingImpl();
        List<Product> lijst = Data.getData();

        for (Product artikel : lijst) {
            bestelling.voegProductToe(artikel);
        }

        LOGGER.debug("Lijst gesorteerd op natuurlijke volgorde: ");
        bestelling.sorteer();

        LOGGER.debug("\nLijst gesorteerd op merknaam: ");
        bestelling.sorteerOpMerk();

        LOGGER.debug("\nLijst gesorteerd op volume: ");
        bestelling.sorteerOpVolume();

        LOGGER.debug("\nVan het merk Georgio Armani:");
        bestelling.lijstVanBepaaldMerk("Georgio Armani");

        LOGGER.debug("\nAlle Parfums:");
        bestelling.lijstVanParfums();

        LOGGER.debug("\nAlle producten onder €50; ");
        bestelling.lijstVanGoedkopeProducten();

        Product product = bestelling.zoekDuursteProduct();
        LOGGER.debug("\nDuurste product:\n" + product);

        System.out.printf("\nTotale prijs: €%.2f", bestelling.totalePrijs());

    }
}
