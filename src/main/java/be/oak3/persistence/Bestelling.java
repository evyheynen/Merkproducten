package be.oak3.persistence;

import be.oak3.model.Product;
import be.oak3.persistence.Berekenbaar;

import java.util.List;

public interface Bestelling extends Berekenbaar {

    public void voegProductToe(Product product);

    public void sorteer();

    public void sorteerOpMerk();

    public void sorteerOpVolume();

    public void toonPerMerk(String merk);

    public List<Product>lijstVanBepaaldMerk(String merk);

    public void toonGoedkopereProducten();

    public Product zoekDuursteProduct();

    public void toonParfums();

}
