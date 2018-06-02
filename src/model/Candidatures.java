package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "candidature"
})
@XmlRootElement(name = "candidatures")
public class Candidatures {

    protected List<Candidature> candidature;

    public List<Candidature> getCandidature() {
        if (candidature == null) {
            candidature = new ArrayList<Candidature>();
        }
        return this.candidature;
    }

    public void ajouterCandidature(Candidature candidature) {
        this.candidature.add(candidature);
    }

}
