package be.oak3.model;

import java.util.Comparator;

public abstract class Product implements Comparable<Product>{
    private int productNummer;
    private String merk;
    private String naam;
    private int volume;
    private double prijs;

    //CONSTRUCTOR
    public Product(int productNummer, String merk, String naam, int volume, double prijs) {
        this.productNummer = productNummer;
        this.merk = merk;
        this.naam = naam;
        this.volume = volume;
        this.prijs = prijs;
    }

    //GETTERS
    public int getProductNummer() {
        return productNummer;
    }

    public String getMerk() {
        return merk;
    }

    public String getNaam() {
        return naam;
    }

    public int getVolume() {
        return volume;
    }

    public double getPrijs() {
        return prijs;
    }

    //SETTERS
    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    //METHODES
    public String getProductCode() {
        String result = merk.substring(0,3)+ naam.substring(0,3)+String.valueOf(volume);
        return result.toUpperCase().replace(" ","_");
    }

    public static Comparator<Product> sorteerOpMerknaam(){
        return (m1, m2)->m1.getMerk().compareTo(m2.getMerk());
    }

    //OVERIDE METHODES
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getProductNummer() != product.getProductNummer()) return false;
        if (getVolume() != product.getVolume()) return false;
        if (Double.compare(product.getPrijs(), getPrijs()) != 0) return false;
        if (!getMerk().equals(product.getMerk())) return false;
        return getNaam().equals(product.getNaam());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getProductNummer();
        result = 31 * result + getMerk().hashCode();
        result = 31 * result + getNaam().hashCode();
        result = 31 * result + getVolume();
        temp = Double.doubleToLongBits(getPrijs());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%d%s%-20s%10s%-24s%10%3sml%8s%4.2f%5s%s",
                productNummer, "Merk: ", merk, "Naam: ", naam,"Volume: ",volume, "Prijs: ", prijs,"Code: "+ getProductCode());
    }

    @Override
    public int compareTo(Product o) {
        return this.productNummer-o.getProductNummer();
    }
}

