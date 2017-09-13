package be.oak3.model;

import java.util.Comparator;

public abstract class Product implements Comparable<Product>{
    private int productNummer;
    private String merk;
    private String naam;
    private int volume;
    private double prijs;

    public Product(int productNummer, String merk, String naam, int volume, double prijs) {
        this.productNummer = productNummer;
        this.merk = merk;
        this.naam = naam;
        this.volume = volume;
        this.prijs = prijs;
    }

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
    public int compareTo(Product p){
        return getProductNummer()-p.getProductNummer();
    }
    public String getProductCode() {
        String code = getMerk().substring(0,4)+ getNaam().substring(0,4)+getVolume();
        code.toUpperCase().replace(" ","_");
        return code;
    }
        /*StringBuilder code = new StringBuilder();
        code.append(getMerk().substring(0, 4)).append(getNaam().substring(0, 4)).append(getVolume());
        code.toString();
        code.toUpperCase().replace(" ","_");
        return code;
    }
    */
    public static Comparator<Product> sorteerOpMerknaam(){
        return (m1, m2)->m1.getMerk().compareTo(m2.getMerk());
    }

    @Override
    public String toString(){
        return getProductNummer()+" "+"Merk: "+getMerk()+"\t"+"Naam: "+getNaam()+"\t"+"Volume: "+getVolume()+"\t"+"Prijs: "+getPrijs()+"\t"+"Code: "+code;
    }

        /*return String.format(%5d%10s%30s\t%10d%2s%10.2%10s%,productNummer,"Merk: ",merk,"Naam: ", naam,volume,"ml","Prijs: ", prijs, code);*/


}

