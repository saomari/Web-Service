<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="formations" scope="request" type="java.util.List" />
<jsp:useBean id="candidatures" scope="request" type="java.util.List" />

<html>
<head>
    <title>Espace Candidat</title>
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
    <p align="center">Bonjour ${sessionScope.sessionCandidat.prenom}, ${sessionScope.sessionCandidat.nom}</p>
    <p align="center">Vous êtes connecté(e) avec l'adresse ${sessionScope.sessionCandidat.email}, vous avez bien accès à l'espace candidat.</p>
    <p align="center">Vous êtes du genre ${sessionScope.sessionCandidat.genre}, et votre date de naissance est ${sessionScope.sessionCandidat.aniverssaire}</p>
    <p align="center">Vos motivations sont : ${sessionScope.sessionCandidat.motivation}</p>
    <form action="ajouterformation" method="post" style="width:500px;text-align:center">
        <label>
            <select name="formation" required style="width: 50%">
                <c:forEach var="formation" items="${formations}">
                    <option value="${formation.libelle}">${formation.libelle}</option>
                </c:forEach>
            </select>
        </label>
        <a>
            <button type="submit">Ajouter Formation</button>
        </a>
        <a href="deconnexion">
            <button type="button">Deconnexion</button>
        </a>
    </form>
    <table style="width:50%">
        <tr>
            <th>Formation</th>
            <th>Statut</th>
        </tr>
        <c:forEach var="candidature" items="${candidatures}">
            <tr>
                <td>${candidature.formation.libelle}</td>
                <td>${candidature.statut}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
