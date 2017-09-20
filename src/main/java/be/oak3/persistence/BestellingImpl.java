package be.oak3.persistence;

import be.oak3.model.Parfum;
import be.oak3.model.Product;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BestellingImpl implements Bestelling {
    List<Product> producten;
    private static int productNummer = 1000;



    public List<Product> getProducten() {
        return producten;
    }



    public BestellingImpl() {
        //GUAVA
        producten= Lists.newArrayList();

        producten=new ArrayList<>();
    }

    public void voegProductToe(Product product) {
        product.setProductNummer(productNummer);
            producten.add(product);
            productNummer++;
        }

   @Override
    public void sorteer(){
        List<Product> n= producten.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        n.forEach(System.out::println);
    }

    @Override
    public void sorteerOpMerk() {

    }
    /* Collections.sort(producten);*/

    /* n.logger.debug("");

    @Override
    public void sorteerOpMerk(){
        producten.stream().sorted(Product.sorteerOpMerknaam()).forEach(System.out::println);
    }
    /*Collections.sort(producten,Product.sorteeropMerknaam());*/

    @Override
    public void sorteerOpVolume(){
        producten.stream().sorted((v1,v2)->v1.getVolume()-v2.getVolume()).forEach(System.out::println);
}

    @Override
    public void toonPerMerk(String merk) {
        producten.stream().filter(product -> product.getMerk().equalsIgnoreCase(merk)).forEach(System.out::println);
    }


    @Override
    public List<Product>lijstVanBepaaldMerk(String merk){
        return producten.stream().filter(product->product.getMerk().equalsIgnoreCase(merk)).collect(Collectors.toList());
    }
    @Override
    public void toonGoedkopereProducten(){
        producten.stream().filter(p->p.getPrijs()<50).forEach(System.out::println);
    }

    @Override
    public Product zoekDuursteProduct(){
        return producten.stream().max(Comparator.comparingDouble(Product::getPrijs)).orElseThrow(RuntimeException::new);
    }

    @Override
    public void toonParfums() { producten.stream().filter(p->p instanceof Parfum).forEach(System.out::println);
    }

    @Override
    public double totalePrijs(){
        return producten.stream().mapToDouble(Product::getPrijs).sum();
    }
}
