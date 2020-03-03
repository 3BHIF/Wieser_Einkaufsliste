/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wiese_ko8fa
 */
@XmlRootElement(name = "Eintrag")
public class Eintrag {
    private String gruppe;
    private String produkt;
    private int anzahl;

    public Eintrag() {
    }

    public Eintrag(String gruppe, String produkt, int anzahl) {
        this.gruppe = gruppe;
        this.produkt = produkt;
        this.anzahl = anzahl;
    }

    @XmlElement
    public String getGruppe() {
        return gruppe;
    }

    public void setGruppe(String gruppe) {
        this.gruppe = gruppe;
    }

    @XmlElement
    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    @XmlElement
    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
    
    public Object[] toArray()
    {
        Object[] arr = {this.getGruppe(), this.getProdukt(), this.getAnzahl()};
        return arr;
    }
}
