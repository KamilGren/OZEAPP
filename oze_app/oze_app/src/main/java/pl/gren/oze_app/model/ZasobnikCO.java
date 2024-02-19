package pl.gren.oze_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class ZasobnikCO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String producent;

    @NotBlank
    private String model;

    @NotBlank
    private String nazwa;

    @Positive
    private double cenaKatalogowa;

    @PositiveOrZero
    private double rabat;

    @PositiveOrZero
    private double cenaZakupu;

    @NotBlank
    private String material;

    @Positive
    private int pojemnosc;

    @Positive
    private int wysokosc;

    @Positive
    private int srednica;

    @NotBlank
    private String klasaErp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCenaKatalogowa() {
        return cenaKatalogowa;
    }

    public void setCenaKatalogowa(double cenaKatalogowa) {
        this.cenaKatalogowa = cenaKatalogowa;
    }

    public double getRabat() {
        return rabat;
    }

    public void setRabat(double rabat) {
        this.rabat = rabat;
    }

    public double getCenaZakupu() {
        return cenaZakupu;
    }

    public void setCenaZakupu(double cenaZakupu) {
        this.cenaZakupu = cenaZakupu;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    public int getSrednica() {
        return srednica;
    }

    public void setSrednica(int srednica) {
        this.srednica = srednica;
    }

    public String getKlasaErp() {
        return klasaErp;
    }

    public void setKlasaErp(String klasaErp) {
        this.klasaErp = klasaErp;
    }
}