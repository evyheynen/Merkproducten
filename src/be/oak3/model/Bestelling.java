package be.oak3.model;

public interface Bestelling extends Berekenbaar{

    public void voegProductToe(Product product);

    public void sorteer();

    public void sorteerOpMerk();

    public void sorteerOpVolume();

    public void toonPerMerk();

    public void toonGoedkopereProducten();

    public void zoekDuursteProduct();
}
