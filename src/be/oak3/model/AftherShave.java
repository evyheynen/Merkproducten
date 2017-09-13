package be.oak3.model;

public class AftherShave extends Product{

    public enum Soort{
        VAPO, GEL;
    }
    private Soort soort;

    public AftherShave(int productNummer, String merk, String naam, int volume, double prijs, Soort soort) {
        super(productNummer,merk,naam,volume,prijs);
        this.soort = soort;
    }

    @Override
    public String toString{
        return super.toString()+"\t"+soort;
    }

}