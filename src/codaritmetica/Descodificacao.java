package codaritmetica;

public class Descodificacao {

    private String sides;
    private Integer ides;
    private Double probacum;

    public Descodificacao(String sides, Integer ides, Double probacum) {
        this.setSides(sides);
        this.setIdes(ides);
        this.setProbacum(probacum);
    }


    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public Integer getIdes() {
        return ides;
    }

    public void setIdes(Integer ides) {
        this.ides = ides;
    }

    public Double getProbacum() {
        return probacum;
    }

    public void setProbacum(Double probacum) {
        this.probacum = probacum;
    }
}
