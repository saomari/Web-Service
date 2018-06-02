package servlet;

import model.Candidature;
import service.CandidatureServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/validercandidature")
/**
 * 
 * @author Sarra
 * Récuperer les informations (email et libellé) de la session
 * et ensuite valider la candidature correspondante
 */
public class ValiderCandidatureServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(ValiderCandidatureServlet.class.getCanonicalName());

    private static final String ATT_ESPACE_RECRUTEUR = "/WEB-INF/espacerecruteur.jsp";
    private static final String ATT_SESSION_CANDI = "sessionCandidat";
    private static final String DOSSIER_XML = "localDirectoryPath";
    private static final String FORMATIONS_XML = "/formations.xml";
    private static final String CANDIDATURES_XML = "/candidatures.xml";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "Session Valide");

        String chemin = getServletContext().getInitParameter(DOSSIER_XML);
        CandidatureServiceImpl candidatureService = new CandidatureServiceImpl(chemin + CANDIDATURES_XML);

        String email = req.getParameter("email");
        String libelle = req.getParameter("libelle");

        LOGGER.log(Level.INFO, email);
        LOGGER.log(Level.INFO, libelle);

        candidatureService.validate(email, libelle);

        LOGGER.log(Level.INFO, candidatureService.getAll().toString());
        req.setAttribute("candidatures", candidatureService.getAll());
        this.getServletContext().getRequestDispatcher(ATT_ESPACE_RECRUTEUR).forward(req, resp);
    }
}
