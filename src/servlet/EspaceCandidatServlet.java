package servlet;

import model.Candidat;
import service.CandidatureServiceImpl;
import service.FormationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/espacecandidat")
/**
 * 
 * @author Sarra
 * Récupération de la session depuis la requête et vérification de l'objet 
 * utilisateur s'il existe dans la session en cours, alors l'utilisateur 
 * est connecté et redirigé vers l'espace candidat, sinon redirection 
 * vers la page de connexion
 */
public class EspaceCandidatServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(EspaceCandidatServlet.class.getCanonicalName());

    private static final String ACCES_PUBLIC = "/";
    private static final String ACCES_ESPACE_CANDIDAT = "/WEB-INF/espacecandidat.jsp";
    private static final String ATT_SESSION_CANDIDAT = "sessionCandidat";
    private static final String FORMATIONS_XML = "/formations.xml";
    private static final String DOSSIER_XML = "localDirectoryPath";
    private static final String CANDIDATURES_XML = "/candidatures.xml";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Récupération de la session depuis la requête */
        HttpSession session = req.getSession();

        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if (session.getAttribute(ATT_SESSION_CANDIDAT) == null) {
            LOGGER.log(Level.INFO, "Session Invalide");
            /* Redirection vers la page de connexion */
            resp.sendRedirect(req.getContextPath() + ACCES_PUBLIC);
        } else {
            LOGGER.log(Level.INFO, "Session Valide");
            String chemin = getServletContext().getInitParameter(DOSSIER_XML);
            FormationServiceImpl formationService = new FormationServiceImpl(chemin + FORMATIONS_XML);
            LOGGER.log(Level.INFO, formationService.getAll().toString());
            CandidatureServiceImpl candidatureService = new CandidatureServiceImpl(chemin + CANDIDATURES_XML);
            Candidat candidat = (Candidat) session.getAttribute(ATT_SESSION_CANDIDAT);
            req.setAttribute("formations", formationService.getAll());
            req.setAttribute("candidatures", candidatureService.getAll(candidat));
            this.getServletContext().getRequestDispatcher(ACCES_ESPACE_CANDIDAT).forward(req, resp);
        }
    }
}
