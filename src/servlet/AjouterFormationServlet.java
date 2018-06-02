package servlet;

import model.Candidat;
import model.Candidature;
import model.Formation;
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

@WebServlet(urlPatterns = "/ajouterformation")
/**
 * 
 * @author Sarra
 *
 */
public class AjouterFormationServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(AjouterFormationServlet.class.getCanonicalName());

    private static final String ACCES_ESPACE_CANDIDAT = "/WEB-INF/espacecandidat.jsp";
    private static final String ATT_SESSION_CANDI = "sessionCandidat";
    private static final String DOSSIER_XML = "localDirectoryPath";
    private static final String FORMATIONS_XML = "/formations.xml";
    private static final String CANDIDATURES_XML = "/candidatures.xml";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String chemin = getServletContext().getInitParameter(DOSSIER_XML);

        Candidat candidat = (Candidat) session.getAttribute(ATT_SESSION_CANDI);
        LOGGER.log(Level.INFO, candidat.toString());

        FormationServiceImpl formationService = new FormationServiceImpl(chemin + FORMATIONS_XML);
        LOGGER.log(Level.INFO, formationService.getAll().toString());

        Formation formation = formationService.getOne(req.getParameter("formation"));

        CandidatureServiceImpl candidatureService = new CandidatureServiceImpl(chemin + CANDIDATURES_XML);
        Candidature candidature = new Candidature();
        candidature.setCandidat(candidat);
        candidature.setFormation(formation);
        candidature.setStatut("En Cours");
        candidatureService.create(candidature);

        session.setAttribute(ATT_SESSION_CANDI, candidat);
        req.setAttribute("formations", formationService.getAll());
        req.setAttribute("candidatures", candidatureService.getAll(candidat));

        LOGGER.log(Level.INFO, candidat.toString());
        this.getServletContext().getRequestDispatcher(ACCES_ESPACE_CANDIDAT).forward(req, resp);
    }
}
