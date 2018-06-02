package service;

import model.Utilisateur;
import model.Utilisateurs;
import parser.JaxParse;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class UtilisateurServiceImpl implements UtilisateurService {

    private String chemin;

    public UtilisateurServiceImpl(String chemin) {
        this.chemin = chemin;
    }

    @Override
    public List<Utilisateur> getAll() {
        return getUtilisateurs().getUtilisateur();
    }

    @Override
    public Utilisateur getOne(String email) {
        for (Utilisateur utilisateur : getAll()) {
            if (utilisateur.getEmail().equals(email)) {
                return utilisateur;
            }
        }
        return null;
    }

    @Override
    public void create(Utilisateur utilisateur) {
        Utilisateurs utilisateurs = getUtilisateurs();
        utilisateurs.getUtilisateur().add(utilisateur);
        setUtilisateurs(utilisateurs);
    }

    @Override
    public void delete(String email) {
        Utilisateurs utilisateurs = getUtilisateurs();
        utilisateurs.getUtilisateur().remove(getOne(email));
        setUtilisateurs(utilisateurs);
    }

    private Utilisateurs getUtilisateurs() {
        try {
            return JaxParse.unmarshal(Utilisateurs.class, new File(chemin));
        } catch (JAXBException e) {
            return null;
        }
    }

    private void setUtilisateurs(Utilisateurs utilisateurs) {
        try {
            JaxParse.marshal(utilisateurs, chemin, new File(chemin));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
