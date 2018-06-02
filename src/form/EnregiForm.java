package form;

import model.Candidat;
import model.Candidats;
import parser.JaxParse;
import service.CandidatServiceImpl;
import service.CandidatureServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnregiForm {
	/* ********** Logging ********** */
	private static final Logger LOGGER = Logger.getLogger(EnregiForm.class.getCanonicalName());

	private static final String CHEMIN_CANDIDATS = "/candidats.xml";

	/* ********** Declaring Candidacy Variables ********** */
	private static final String CANDID_NOM = "nom";
	private static final String CANDID_PRENOM = "prenom";
	private static final String CANDID_EMAIL = "email";
	private static final String CANDID_MDP1 = "mdp1";
	private static final String CANDID_MDP2 = "mdp2";
	private static final String CANDID_GENRE = "genre";
	private static final String CANDID_NATIONALITE = "nationalite";
	private static final String CANDID_TELEPHONE = "telephone";
	private static final String CANDID_ANIVESSAIRE = "aniverssaire";
	private static final String CANDID_ETABLISSEMENT = "etablissement";
	private static final String CANDID_DIPLOME = "diplome";
	private static final String CANDID_NOTE = "note";
	private static final String CANDID_MOTIVATION = "motivation";

	/**
	 * Récuperer les paramètres saisis par l'utilisateur, créer un candidat avec ces
	 * paramètres et le stocker dans le chemin passé en argument
	 * 
	 * @param request
	 *            : requete reçu à partir de la page web
	 * @param chemin
	 *            : chemin de sauvegarde du candidat
	 * @return Le candidat enregistré
	 */
	public Candidat enregistrement(HttpServletRequest request, String chemin) {

		final String nom = request.getParameter(CANDID_NOM);
		final String prenom = request.getParameter(CANDID_PRENOM);
		final String email = request.getParameter(CANDID_EMAIL);
		final String mdp1 = request.getParameter(CANDID_MDP1);
		final String mdp2 = request.getParameter(CANDID_MDP2);
		final String genre = request.getParameter(CANDID_GENRE);
		final String nationalite = request.getParameter(CANDID_NATIONALITE);
		final String telephone = request.getParameter(CANDID_TELEPHONE);
		final String aniverssaire = request.getParameter(CANDID_ANIVESSAIRE);
		final String etablissement = request.getParameter(CANDID_ETABLISSEMENT);
		final String diplome = request.getParameter(CANDID_DIPLOME);
		final String note = request.getParameter(CANDID_NOTE);
		final String motivation = request.getParameter(CANDID_MOTIVATION);

		if (!mdp1.equals(mdp2)) {
			LOGGER.log(Level.INFO, "Mots de passe ne correspondent pas");
			return null;
		}

		Candidat candidat = new Candidat();
		candidat.setNom(nom);
		candidat.setPrenom(prenom);
		candidat.setEmail(email);
		candidat.setMdp(mdp1);
		candidat.setGenre(genre);
		candidat.setNationalite(nationalite);
		candidat.setTelephone(telephone);
		candidat.setAniverssaire(aniverssaire);
		candidat.setEtablissement(etablissement);
		candidat.setDiplome(diplome);
		candidat.setNote(Float.parseFloat(note));
		candidat.setMotivation(motivation);

		CandidatServiceImpl candidatService = new CandidatServiceImpl(chemin);
		candidatService.create(candidat);

		LOGGER.log(Level.INFO, candidat.toString());

		return candidat;
	}
}
