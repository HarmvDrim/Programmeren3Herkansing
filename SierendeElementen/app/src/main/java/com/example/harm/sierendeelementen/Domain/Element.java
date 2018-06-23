package com.example.harm.sierendeelementen.Domain;

import java.io.Serializable;

/**
 * Created by harm on 23-6-2018.
 */

public class Element implements Serializable {
    private String idNummer;
    private String naamObject;
    private String geoLigging;
    private String imageElement;
    private String kunstenaar;
    private String beschrijving;
    private String materiaal;
    private String ondergrond;

    public Element(String idNummer, String naamObject, String geoLigging, String imageElement, String kunstenaar, String beschrijving, String materiaal, String ondergrond) {
        this.idNummer = idNummer;
        this.naamObject = naamObject;
        this.geoLigging = geoLigging;
        this.imageElement = imageElement;
        this.kunstenaar = kunstenaar;
        this.beschrijving = beschrijving;
        this.materiaal = materiaal;
        this.ondergrond = ondergrond;
    }

    public String getIdNummer() {
        return idNummer;
    }

    public String getNaamObject() {
        return naamObject;
    }

    public String getGeoLigging() {
        return geoLigging;
    }

    public String getImageElement() {
        return imageElement;
    }

    public String getKunstenaar() {
        return kunstenaar;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getMateriaal() {
        return materiaal;
    }

    public String getOndergrond() {
        return ondergrond;
    }
}
