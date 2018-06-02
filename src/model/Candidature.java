package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candidature", propOrder = {
    "candidat",
    "formation",
    "statut"
})
public class Candidature {

    @XmlElement(required = true)
    protected Candidat candidat;
    @XmlElement(required = true)
    protected Formation formation;
    @XmlElement(required = true)
    protected String statut;

    /**
     * Gets the value of the candidat property.
     * 
     * @return
     *     possible object is
     *     {@link Candidat }
     *     
     */
    public Candidat getCandidat() {
        return candidat;
    }

    /**
     * Sets the value of the candidat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Candidat }
     *     
     */
    public void setCandidat(Candidat value) {
        this.candidat = value;
    }

    /**
     * Gets the value of the formation property.
     * 
     * @return
     *     possible object is
     *     {@link Formation }
     *     
     */
    public Formation getFormation() {
        return formation;
    }

    /**
     * Sets the value of the formation property.
     *
     * @param value
     *     allowed object is
     *     {@link Formation }
     *
     */
    public void setFormation(Formation value) {
        this.formation = value;
    }

    /**
     * Sets the value of the formation property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatut() {
        return statut;
    }

    /**
     * Sets the value of the formation property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatut(String value) {
        this.statut = value;
    }

    @Override
    public String toString() {
        return "Candidature{" +
                "candidat=" + candidat +
                ", formation=" + formation +
                ", statut='" + statut + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidature)) return false;
        Candidature that = (Candidature) o;
        return Objects.equals(candidat, that.candidat) &&
                Objects.equals(formation, that.formation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(candidat, formation);
    }
}
