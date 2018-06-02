package service;

import model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    public List<Utilisateur> getAll();
    public Utilisateur getOne(String email);
    public void create(Utilisateur utilisateur);
    public void delete(String email);
}
