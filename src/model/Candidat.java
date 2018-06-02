package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candidat", propOrder = {
    "genre",
    "nationalite",
    "telephone",
    "aniverssaire",
    "etablissement",
    "diplome",
    "note",
    "motivation"
})
public class Candidat
    extends Utilisateur
{

    @XmlElement(required = true)
    protected String genre;
    @XmlElement(required = true)
    protected String nationalite;
    @XmlElement(required = true)
    protected String telephone;
    @XmlElement(required = true)
    protected String aniverssaire;
    @XmlElement(required = true)
    protected String etablissement;
    @XmlElement(required = true)
    protected String diplome;
    protected float note;
    @XmlElement(required = true)
    protected String motivation;

    /**
     * Gets the value of the genre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Gets the value of the nationalite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * Sets the value of the nationalite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalite(String value) {
        this.nationalite = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the aniverssaire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAniverssaire() {
        return aniverssaire;
    }

    /**
     * Sets the value of the aniverssaire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAniverssaire(String value) {
        this.aniverssaire = value;
    }

    /**
     * Gets the value of the etablissement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtablissement() {
        return etablissement;
    }

    /**
     * Sets the value of the etablissement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtablissement(String value) {
        this.etablissement = value;
    }

    /**
     * Gets the value of the diplome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiplome() {
        return diplome;
    }

    /**
     * Sets the value of the diplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiplome(String value) {
        this.diplome = value;
    }

    /**
     * Gets the value of the note property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public float getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * @param value
     * allowed object is
     *     {@link String }
     */
    public void setNote(float value) {
        this.note = value;
    }

    /**
     * Gets the value of the motivation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivation() {
        return motivation;
    }

    /**
     * Sets the value of the motivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivation(String value) {
        this.motivation = value;
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", genre='" + genre + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", telephone='" + telephone + '\'' +
                ", aniverssaire='" + aniverssaire + '\'' +
                ", etablissement='" + etablissement + '\'' +
                ", diplome='" + diplome + '\'' +
                ", note=" + note +
                ", motivation='" + motivation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidat)) return false;
        Candidat candidat = (Candidat) o;
        return Float.compare(candidat.note, note) == 0 &&
                Objects.equals(genre, candidat.genre) &&
                Objects.equals(nationalite, candidat.nationalite) &&
                Objects.equals(telephone, candidat.telephone) &&
                Objects.equals(aniverssaire, candidat.aniverssaire) &&
                Objects.equals(etablissement, candidat.etablissement) &&
                Objects.equals(diplome, candidat.diplome) &&
                Objects.equals(motivation, candidat.motivation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre, nationalite, telephone, aniverssaire, etablissement, diplome, note, motivation);
    }
}
