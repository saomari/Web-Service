package servlet;

import model.Candidat;
import model.Utilisateur;
import service.CandidatServiceImpl;
import service.CandidatureServiceImpl;
import service.FormationServiceImpl;
import service.UtilisateurServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/connexion")
/**
 * 
 * @author Sarra 
 * Récupération de la session depuis la requête et si aucune erreur
 * de validation n'a eu lieu, alors ajout du bean Utilisateur à la
 * session, sinon suppression du bean de la session.
 */
public class ConnexionServlet extends HttpServlet {

	/* ********** Logging ********** */
	private static final Logger LOGGER = Logger.getLogger(ConnexionServlet.class.getCanonicalName());

	private static final String ATT_SESSION_CANDI = "sessionCandidat";
	private static final String ATT_SESSION_RECRU = "sessionRecruteur";
	private static final String ATT_ESPACE_CANDIDAT = "/WEB-INF/espacecandidat.jsp";
	private static final String ATT_ESPACE_RECRUTEUR = "/WEB-INF/espacerecruteur.jsp";
	private static final String VUE = "/";
	private static final String CANDIDATS_XML = "/candidats.xml";
	private static final String UTILISATEURS_XML = "/utilisateurs.xml";
	private static final String FORMATIONS_XML = "/formations.xml";
	private static final String CANDIDATURES_XML = "/candidatures.xml";
	private static final String DOSSIER_XML = "localDirectoryPath";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String chemin = getServletContext().getInitParameter(DOSSIER_XML);

		String email = req.getParameter("email").trim();
		String mdp = req.getParameter("mdp").trim();

		/* Récupération de la session depuis la requête */
		HttpSession session = req.getSession();

		/**
		 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean Utilisateur à
		 * la session, sinon suppression du bean de la session.
		 */
		UtilisateurServiceImpl utilisateurService = new UtilisateurServiceImpl(chemin + UTILISATEURS_XML);
		CandidatureServiceImpl candidatureService = new CandidatureServiceImpl(chemin + CANDIDATURES_XML);
		Utilisateur utilisateur = utilisateurService.getOne(email);
		if (utilisateur != null && utilisateur.getMdp().equals(mdp)) {
			LOGGER.log(Level.INFO, candidatureService.getAll().toString());
			session.setAttribute(ATT_SESSION_RECRU, utilisateur);
			req.setAttribute("candidatures", candidatureService.getAll());
			LOGGER.log(Level.INFO, utilisateur.toString());
			this.getServletContext().getRequestDispatcher(ATT_ESPACE_RECRUTEUR).forward(req, resp);
		} else {
			CandidatServiceImpl candidatService = new CandidatServiceImpl(chemin + CANDIDATS_XML);
			Candidat candidat = candidatService.getOne(email);
			if (candidat != null && candidat.getMdp().equals(mdp)) {
				FormationServiceImpl formationService = new FormationServiceImpl(chemin + FORMATIONS_XML);
				LOGGER.log(Level.INFO, formationService.getAll().toString());
				session.setAttribute(ATT_SESSION_CANDI, candidat);
				req.setAttribute("formations", formationService.getAll());
				req.setAttribute("candidatures", candidatureService.getAll(candidat));
				LOGGER.log(Level.INFO, candidat.toString());
				this.getServletContext().getRequestDispatcher(ATT_ESPACE_CANDIDAT).forward(req, resp);
			} else {
				LOGGER.log(Level.INFO, "Utilisateur est nul");
				session.setAttribute(ATT_SESSION_CANDI, null);
				req.setAttribute(ATT_SESSION_RECRU, null);
				this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
			}
		}
	}
}
