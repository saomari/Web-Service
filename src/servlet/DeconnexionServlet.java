package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/deconnexion")
/**
 * 
 * @author Sarra
 * Servlet assurant la déconnexion de l'utilisateur après le clic sur le bouton 'Déconnexion'
 */
public class DeconnexionServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(DeconnexionServlet.class.getCanonicalName());

    private static final String VUE = "/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */
        HttpSession session = req.getSession();
        session.invalidate();

        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
    }
}
