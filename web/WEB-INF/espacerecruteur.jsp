<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="candidatures" scope="request" type="java.util.List" />

<html>
<head>
    <title>Espace Recruteur</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
        }
        th {
            text-align: left;
        }
    </style>
</head>
<body>
<p align="center">Bonjour ${sessionScope.sessionRecruteur.prenom}, ${sessionScope.sessionRecruteur.nom}</p>
<p align="center">Vous êtes connecté(e) avec l'adresse ${sessionScope.sessionRecruteur.email}, vous avez bien accès à l'espace recruteur.</p>
    <form action="validercandidature" method="post" style="width:500px;text-align:center">
        <table style="width:50%">
            <tr>
                <th>Formation</th>
                <th>Note</th>
                 <th>Candidat</th>
                <th>Action</th>
            </tr>
            <c:forEach var="candidature" items="${candidatures}">
                <c:if test="${candidature.statut != 'Validée'}" >
                    <tr>
                        <td>
                            <input name="libelle" value="${candidature.formation.libelle}" type="hidden">
                            ${candidature.formation.libelle}
                        </td>
                        <td>
                            <input name="note" value="${candidature.candidat.note}" type="hidden">
                             ${candidature.candidat.note}
                        </td>
                        <td>
                            <input name="email" value="${candidature.candidat.email}" type="hidden">
                            ${candidature.candidat.nom} ${candidature.candidat.prenom}
                        </td>
                        <td><button type="submit">Valider</button></td>
                    </tr>
                </c:if>
            </c:forEach>
        </table><br><br><br>
        <a href="deconnexion">
            <button type="button">Deconnexion</button>
        </a>
    </form>
</body>
</html>
