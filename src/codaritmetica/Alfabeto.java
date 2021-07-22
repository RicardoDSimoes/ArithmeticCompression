package codaritmetica;

public class Alfabeto {

    private String si;
    private Double pi;
    private String lastpi;
    private Double sub_lower;
    private Double sub_higher;


    public Alfabeto(String si, Double pi, String lastpi) {
        this.si = si;
        this.pi = pi;
        this.setLastpi(lastpi);
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public Double getPi() {
        return pi;
    }

    public void setPi(Double pi) {
        this.pi = pi;
    }


    public String getLastpi() {
        return lastpi;
    }

    public void setLastpi(String lastpi) {
        this.lastpi = lastpi;
    }

    public Double getSub_lower() {
        return sub_lower;
    }

    public void setSub_lower(Double sub_lower) {
        this.sub_lower = sub_lower;
    }

    public Double getSub_higher() {
        return sub_higher;
    }

    public void setSub_higher(Double sub_higher) {
        this.sub_higher = sub_higher;
    }
}
