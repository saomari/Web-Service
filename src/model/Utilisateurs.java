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
    "utilisateur"
})
@XmlRootElement(name = "utilisateurs")
public class Utilisateurs {

    @XmlElement(required = true)
    protected List<Utilisateur> utilisateur;

    public List<Utilisateur> getUtilisateur() {
        if (utilisateur == null) {
            utilisateur = new ArrayList<Utilisateur>();
        }
        return this.utilisateur;
    }

}
