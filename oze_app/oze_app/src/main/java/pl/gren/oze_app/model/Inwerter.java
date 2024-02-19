package pl.gren.oze_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

    @Entity
    public class Inwerter {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Nazwa nie może być pusta")
        private String nazwa;

        private String dodatkowo;

        @NotNull(message = "Sprawność nie może być pusta")
        @DecimalMin(value = "0.0", message = "Sprawność nie może być mniejsza niż 0.0")
        @DecimalMax(value = "100.0", message = "Sprawność nie może być większa niż 100.0")
        private Double sprawnosc;

        @Min(value = 1, message = "Ilość faz musi być co najmniej 1")
        private Integer iloscFaz;

        @Min(value = 1, message = "Ilość MPPT musi być co najmniej 1")
        private Integer iloscMPPT;

        @Column(name = "c_katalogowa")
        private Double cKatalogowa;

        @Column(name = "netto")
        private Double netto;

        @Column(name = "brutto")
        private Double brutto;

        @Column(name = "nom_W")
        private Double nomW;

        @Column(name = "min_W")
        private Double minW;

        @Column(name = "max_W")
        private Double maxW;

        @Column(name = "procent")
        private Double procent;

        @Column(name = "max_V_string")
        private String maxVString;

        @Column(name = "zabezpieczenia_AC")
        private String zabezpieczeniaAC;

        @Column(name = "gwarancja")
        private String gwarancja;

        @Column(name = "zdjecie_inwerter")
        private String zdjecieInwerter;

        @Column(name = "max_A_DC")
        private Double maxADC;

        @Column(name = "zakres_DC")
        private String zakresDC;

        @Column(name = "THDi")
        private String thdi;

        @Column(name = "min_DC")
        private Double minDC;

        public Inwerter() {

        }

        public Inwerter(Long id, String nazwa, String dodatkowo, Double sprawnosc, Integer iloscFaz, Integer iloscMPPT, Double cKatalogowa, Double netto, Double brutto, Double nomW, Double minW, Double maxW, Double procent, String maxVString, String zabezpieczeniaAC, String gwarancja, String zdjecieInwerter, Double maxADC, String zakresDC, String thdi, Double minDC) {
            this.id = id;
            this.nazwa = nazwa;
            this.dodatkowo = dodatkowo;
            this.sprawnosc = sprawnosc;
            this.iloscFaz = iloscFaz;
            this.iloscMPPT = iloscMPPT;
            this.cKatalogowa = cKatalogowa;
            this.netto = netto;
            this.brutto = brutto;
            this.nomW = nomW;
            this.minW = minW;
            this.maxW = maxW;
            this.procent = procent;
            this.maxVString = maxVString;
            this.zabezpieczeniaAC = zabezpieczeniaAC;
            this.gwarancja = gwarancja;
            this.zdjecieInwerter = zdjecieInwerter;
            this.maxADC = maxADC;
            this.zakresDC = zakresDC;
            this.thdi = thdi;
            this.minDC = minDC;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNazwa() {
            return nazwa;
        }

        public void setNazwa(String nazwa) {
            this.nazwa = nazwa;
        }

        public String getDodatkowo() {
            return dodatkowo;
        }

        public void setDodatkowo(String dodatkowo) {
            this.dodatkowo = dodatkowo;
        }

        public Double getcKatalogowa() {
            return cKatalogowa;
        }

        public void setcKatalogowa(Double cKatalogowa) {
            this.cKatalogowa = cKatalogowa;
        }

        public Double getNetto() {
            return netto;
        }

        public void setNetto(Double netto) {
            this.netto = netto;
        }

        public Double getBrutto() {
            return brutto;
        }

        public void setBrutto(Double brutto) {
            this.brutto = brutto;
        }

        public Double getNomW() {
            return nomW;
        }

        public void setNomW(Double nomW) {
            this.nomW = nomW;
        }

        public Double getMinW() {
            return minW;
        }

        public void setMinW(Double minW) {
            this.minW = minW;
        }

        public Double getMaxW() {
            return maxW;
        }

        public void setMaxW(Double maxW) {
            this.maxW = maxW;
        }

        public Double getProcent() {
            return procent;
        }

        public void setProcent(Double procent) {
            this.procent = procent;
        }

        public String getMaxVString() {
            return maxVString;
        }

        public void setMaxVString(String maxVString) {
            this.maxVString = maxVString;
        }

        public String getZabezpieczeniaAC() {
            return zabezpieczeniaAC;
        }

        public void setZabezpieczeniaAC(String zabezpieczeniaAC) {
            this.zabezpieczeniaAC = zabezpieczeniaAC;
        }

        public String getGwarancja() {
            return gwarancja;
        }

        public void setGwarancja(String gwarancja) {
            this.gwarancja = gwarancja;
        }

        public Double getSprawnosc() {
            return sprawnosc;
        }

        public void setSprawnosc(Double sprawnosc) {
            this.sprawnosc = sprawnosc;
        }

        public Integer getIloscFaz() {
            return iloscFaz;
        }

        public void setIloscFaz(Integer iloscFaz) {
            this.iloscFaz = iloscFaz;
        }

        public Integer getIloscMPPT() {
            return iloscMPPT;
        }

        public void setIloscMPPT(Integer iloscMPPT) {
            this.iloscMPPT = iloscMPPT;
        }

        public String getZdjecieInwerter() {
            return zdjecieInwerter;
        }

        public void setZdjecieInwerter(String zdjecieInwerter) {
            this.zdjecieInwerter = zdjecieInwerter;
        }

        public Double getMaxADC() {
            return maxADC;
        }

        public void setMaxADC(Double maxADC) {
            this.maxADC = maxADC;
        }

        public String getZakresDC() {
            return zakresDC;
        }

        public void setZakresDC(String zakresDC) {
            this.zakresDC = zakresDC;
        }

        public String getThdi() {
            return thdi;
        }

        public void setThdi(String thdi) {
            this.thdi = thdi;
        }

        public Double getMinDC() {
            return minDC;
        }

        public void setMinDC(Double minDC) {
            this.minDC = minDC;
        }
    }
