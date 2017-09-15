package be.oak3.model;

import java.util.List;

public interface Bestelling extends Berekenbaar{

    public void voegProductToe(Product product);

    public void sorteer();

    public void sorteerOpMerk();

    public void sorteerOpVolume();

    public List<Product> toonPerMerk();

    public List<Product> toonGoedkopereProducten();

    public List<Product> zoekDuursteProduct();
}
