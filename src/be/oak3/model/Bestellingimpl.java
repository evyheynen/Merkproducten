package be.oak3.model;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bestellingimpl implements Bestelling {
    List<Product> lijst = new ArrayList<>();
    private static int ProductNummer = 1000;

    public Bestellingimpl() {
    }

    @Override
    public void voegProductToe(Product product) {
        for (Product eenProduct : lijst) {
            lijst.add(product);
            ProductNummer++;
        }
    }

    public void sorteer(){
        lijst.stream().sorted((p1,p2)->p1.compareTo(p2));
    }

    public void sorteerOpMerk(){
        Comparator<Product> comparator= (m1, m2)->m1.getMerk().compareTo(m2.getMerk());
        comparator = comparator.thenComparing((m1, m2)->m1.getNaam().compareTo(m2.getNaam());
        lijst.stream().sorted(comparator);
    }

    public void sorteerOpVolume(){
        lijst.stream().sorted((v1,v2)->v1.getVolume()-v2.getVolume());
}

    public List<Product> toonPerMerk() {
        lijst.stream().filter((m1, m2) -> (m1.getMerk().compareTo(m2.getMerk()) = 0)).sorted();
        lijst.forEach(System.out::println);
    }

    public List<Product> toonGoedkopereProducten(){
        lijst.stream().filter(p->p.getPrijs()<50);
        lijst.forEach(System.out::println);
    }

    public List<Product> zoekDuursteProduct(){
        lijst.stream().max((prijs1, prijs2)->prijs1.getPrijs()-prijs2.getPrijs())
        .ifPresent(duurste -> System.out.println(duurste));
    }

    public List<Product> toonParfums() {
        if (Parfum.instanceof List<Product>) {
            System.out.println(Parfum);
        }
    }
    public double totalePrijs(){
        return lijst.stream().sum((p1,p2)->p1.getPrijs()+p2.getPrijs());
    }
}
