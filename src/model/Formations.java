package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "formation"
})
@XmlRootElement(name = "formations")
public class Formations {

    @XmlElement(required = true)
    protected List<Formation> formation;

    public List<Formation> getFormation() {
        if (formation == null) {
            formation = new ArrayList<Formation>();
        }
        return this.formation;
    }

    public void ajouterFormation(Formation formation) {
        this.formation.add(formation);
    }
}
