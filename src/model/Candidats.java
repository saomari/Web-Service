package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "candidat"
})
@XmlRootElement(name = "candidats")
public class Candidats {

    @XmlElement(required = true)
    protected List<Candidat> candidat;

    public List<Candidat> getCandidat() {
        if (candidat == null) {
            candidat = new ArrayList<Candidat>();
        }
        return this.candidat;
    }

    public void ajouterCandidat(Candidat candidat) {
        this.candidat.add(candidat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidats)) return false;
        Candidats candidats = (Candidats) o;
        return Objects.equals(candidat, candidats.candidat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidat);
    }

    @Override
    public String toString() {
        return "Candidats{" +
                "candidat=" + candidat +
                '}';
    }
}
