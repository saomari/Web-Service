package service;

import model.Candidat;
import model.Candidats;
import parser.JaxParse;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class CandidatServiceImpl implements CandidatService {

    private String chemin;

    public CandidatServiceImpl(String chemin) {
        this.chemin = chemin;
    }

    @Override
    public List<Candidat> getAll() {
        return getCandidats().getCandidat();
    }

    @Override
    public Candidat getOne(String email) {
        for (Candidat candidat : getAll()) {
            if (candidat.getEmail().equals(email)) {
                return candidat;
            }
        }
        return null;
    }

    @Override
    public void create(Candidat candidat) {
        Candidats candidats = getCandidats();
        candidats.getCandidat().add(candidat);
        setCandidats(candidats);
    }

    @Override
    public void delete(String email) {
        Candidats candidats = getCandidats();
        candidats.getCandidat().remove(getOne(email));
        setCandidats(candidats);
    }

    private Candidats getCandidats() {
        try {
            return JaxParse.unmarshal(Candidats.class, new File(chemin));
        } catch (JAXBException e) {
            return null;
        }
    }

    private void setCandidats(Candidats candidats) {
        try {
            JaxParse.marshal(candidats, chemin, new File(chemin));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
