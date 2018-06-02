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

@WebServlet(urlPatterns = "/espacerecruteur")
/**
 * 
 * @author Sarra
 * Récupération de la session depuis la requête et vérification de l'objet 
 * utilisateur s'il existe dans la session en cours, alors l'utilisateur 
 * est connecté et redirigé vers l'espace recruteur, sinon redirection 
 * vers la page de connexion 
 */
public class EspaceRecruteurServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(EspaceRecruteurServlet.class.getCanonicalName());

    private static final String ACCES_PUBLIC = "/";
    private static final String ATT_ESPACE_RECRUTEUR = "/WEB-INF/espacerecruteur.jsp";
    private static final String ATT_SESSION_RECRU = "sessionRecruteur";
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
        if (session.getAttribute(ATT_ESPACE_RECRUTEUR) == null) {
            LOGGER.log(Level.INFO, "Session Invalide");
            /* Redirection vers la page de connexion */
            resp.sendRedirect(req.getContextPath() + ACCES_PUBLIC);
        } else {
            LOGGER.log(Level.INFO, "Session Valide");
            String chemin = getServletContext().getInitParameter(DOSSIER_XML);
            CandidatureServiceImpl candidatureService = new CandidatureServiceImpl(chemin + CANDIDATURES_XML);
            LOGGER.log(Level.INFO, candidatureService.getAll().toString());
            req.setAttribute("candidatures", candidatureService.getAll());
            this.getServletContext().getRequestDispatcher(ATT_ESPACE_RECRUTEUR).forward(req, resp);
        }
    }
}
