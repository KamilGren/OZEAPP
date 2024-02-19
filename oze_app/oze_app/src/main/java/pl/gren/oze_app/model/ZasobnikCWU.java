package pl.gren.oze_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class ZasobnikCWU {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Proszę podać producenta")
        private String producent;

        @NotBlank(message = "Proszę podać model")
        private String model;

        @NotBlank(message = "Proszę podać nazwę")
        private String nazwa;

        @NotNull(message = "Proszę podać cenę katalogową")
        @DecimalMin(value = "0.0", inclusive = false, message = "Cena katalogowa musi być większa niż 0.0")
        private Double cenaKatalogowa;

        @NotNull(message = "Proszę podać rabat")
        @DecimalMin(value = "0.0", message = "Rabat musi być większy lub równy 0.0")
        @DecimalMax(value = "1.0", message = "Rabat nie może przekraczać 1.0")
        private Double rabat;

        @NotNull(message = "Proszę podać cenę zakupu")
        @DecimalMin(value = "0.0", inclusive = false, message = "Cena zakupu musi być większa niż 0.0")
        private Double cenaZakupu;

        @NotBlank(message = "Proszę podać materiał")
        private String material;

        @NotNull(message = "Proszę podać pojemność")
        @Min(value = 0, message = "Pojemność musi być nieujemna")
        private Integer pojemnosc;

        private Double wezownica;

        @Min(value = 0, message = "Wysokość musi być nieujemna")
        private Integer wysokosc;

        @Min(value = 0, message = "Średnica musi być nieujemna")
        private Integer srednica;

        @NotBlank(message = "Proszę podać klasę ERP")
        private String klasaErp;

        @NotBlank(message = "Proszę podać informację o grzałce")
        private String grzalka;

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

    public Double getCenaKatalogowa() {
        return cenaKatalogowa;
    }

    public void setCenaKatalogowa(Double cenaKatalogowa) {
        this.cenaKatalogowa = cenaKatalogowa;
    }

    public Double getRabat() {
        return rabat;
    }

    public void setRabat(Double rabat) {
        this.rabat = rabat;
    }

    public Double getCenaZakupu() {
        return cenaZakupu;
    }

    public void setCenaZakupu(Double cenaZakupu) {
        this.cenaZakupu = cenaZakupu;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(Integer pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public Double getWezownica() {
        return wezownica;
    }

    public void setWezownica(Double wezownica) {
        this.wezownica = wezownica;
    }

    public Integer getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(Integer wysokosc) {
        this.wysokosc = wysokosc;
    }

    public Integer getSrednica() {
        return srednica;
    }

    public void setSrednica(Integer srednica) {
        this.srednica = srednica;
    }

    public String getKlasaErp() {
        return klasaErp;
    }

    public void setKlasaErp(String klasaErp) {
        this.klasaErp = klasaErp;
    }

    public String getGrzalka() {
        return grzalka;
    }

    public void setGrzalka(String grzalka) {
        this.grzalka = grzalka;
    }

}
