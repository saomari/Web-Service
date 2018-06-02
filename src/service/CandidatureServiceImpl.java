package service;

import model.Candidat;
import model.Candidature;
import model.Candidatures;
import parser.JaxParse;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CandidatureServiceImpl implements CandidatureService {

    private String chemin;

    public CandidatureServiceImpl(String chemin) {
        this.chemin = chemin;
        System.out.println(chemin);
    }

    @Override
    public List<Candidature> getAll() {
        return getCandidatures().getCandidature();
    }

    @Override
    public List<Candidature> getAll(Candidat candidat) {
        List<Candidature> candidatures = new ArrayList<>();
        for (Candidature candidature : getAll()) {
            if (candidature.getCandidat().equals(candidat)) {
                candidatures.add(candidature);
            }
        }
        return candidatures;
    }

    @Override
    public Candidature getOne(String email, String libelle) {
        for (Candidature candidature : getAll()) {
            if (candidature.getCandidat().getEmail().equals(email) && candidature.getFormation().getLibelle().equals(libelle)) {
                return candidature;
            }
        }
        return null;
    }

    @Override
    public void create(Candidature candidature) {
        Candidatures candidatures = getCandidatures();
        if (!candidatures.getCandidature().contains(candidature)) {
            candidatures.getCandidature().add(candidature);
            setCandidatures(candidatures);
        }
    }

    @Override
    public void delete(String email, String libelle) {
        Candidatures candidatures = getCandidatures();
        candidatures.getCandidature().remove(getOne(email, libelle));
        setCandidatures(candidatures);
    }

    @Override
    public void validate(String email, String libelle) {
        Candidatures candidatures = getCandidatures();
        for (Candidature candidature : candidatures.getCandidature()) {
            if (candidature.getCandidat().getEmail().equals(email) && candidature.getFormation().getLibelle().equals(libelle)) {
                candidature.setStatut("Validée");
            }
        }
        setCandidatures(candidatures);
    }

    private Candidatures getCandidatures() {
        try {
            return JaxParse.unmarshal(Candidatures.class, new File(chemin));
        } catch (JAXBException e) {
            return null;
        }
    }

    private void setCandidatures(Candidatures candidatures) {
        try {
            JaxParse.marshal(candidatures, chemin, new File(chemin));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
