package service;

import model.Candidat;

import java.util.List;

public interface CandidatService {
    public List<Candidat> getAll();
    public Candidat getOne(String email);
    public void create(Candidat candidat);
    public void delete(String email);
}
