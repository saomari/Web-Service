package service;

import model.Formation;

import java.util.List;

public interface FormationService {
    public List<Formation> getAll();
    public Formation getOne(String libelle);
    public void create(Formation formation);
    public void delete(String libelle);
}
