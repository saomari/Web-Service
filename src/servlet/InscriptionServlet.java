package servlet;

import form.EnregiForm;
import model.Candidat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/enregistrement")
/**
 * 
 * @author Sarra
 * Préparation de l'objet formulaire, traitement de la requête 
 * et récupération du bean en résultant et à la fin effectuer 
 * le stockage du bean dans l'objet request
 */
public class InscriptionServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(InscriptionServlet.class.getCanonicalName());

    private static final String ATT_USER = "candidat";
    private static final String VUE = "/WEB-INF/views/enregistrement.jsp";
    private static final String RED = "/";
    private static final String CANDIDATS_XML = "/candidats.xml";
    private static final String DOSSIER_XML = "localDirectoryPath";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String chemin = getServletContext().getInitParameter(DOSSIER_XML);

        /* Préparation de l'objet formulaire */
        EnregiForm form = new EnregiForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Candidat candidat = form.enregistrement(req, chemin + CANDIDATS_XML);

        /* Stockage du bean dans l'objet request */
        req.setAttribute(ATT_USER, candidat);

        this.getServletContext().getRequestDispatcher(RED).forward(req, resp);
    }
}
