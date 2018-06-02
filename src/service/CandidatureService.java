package service;

import model.Candidat;
import model.Candidature;

import java.util.List;

public interface CandidatureService {
    public List<Candidature> getAll();
    public List<Candidature> getAll(Candidat candidat);
    public Candidature getOne(String email, String libelle);
    public void create(Candidature candidature);
    public void delete(String email, String libelle);
    public void validate(String email, String libelle);
}
