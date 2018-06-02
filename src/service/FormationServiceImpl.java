package service;

import model.Formation;
import model.Formations;
import parser.JaxParse;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class FormationServiceImpl implements FormationService {

    private String chemin;

    public FormationServiceImpl(String chemin) {
        this.chemin = chemin;
    }

    @Override
    public List<Formation> getAll() {
        return getFormations().getFormation();
    }

    @Override
    public Formation getOne(String libelle) {
        for (Formation formation : getAll()) {
            if (formation.getLibelle().equals(libelle)) {
                return formation;
            }
        }
        return null;
    }

    @Override
    public void create(Formation formation) {
        Formations formations = getFormations();
        formations.getFormation().add(formation);
        setFormations(formations);
    }

    @Override
    public void delete(String libelle) {
        Formations formations = getFormations();
        formations.getFormation().add(getOne(libelle));
        setFormations(formations);
    }

    private Formations getFormations() {
        try {
            return JaxParse.unmarshal(Formations.class, new File(chemin));
        } catch (JAXBException e) {
            return null;
        }
    }

    private void setFormations(Formations formations) {
        try {
            JaxParse.marshal(formations, chemin, new File(chemin));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
