package be.oak3.persistence;

import be.oak3.model.Product;
import be.oak3.persistence.Berekenbaar;

import java.util.List;

public interface Bestelling extends Berekenbaar {

    void voegProductToe(Product product);

    void sorteer();

    void sorteerOpMerk();

    void sorteerOpVolume();

    Product zoekDuursteProduct();



    List<Product> lijstVanBepaaldMerk(String merk);

    List<Product> lijstVanParfums();

    List<Product> lijstVanGoedkopeProducten();

    List<Product> getAlleProducten();

}
