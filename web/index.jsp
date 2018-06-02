<%--
  Created by IntelliJ IDEA.
  User: Lincoln
  Date: 5/25/2018
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="res/css/styles.css">
    <title>$Title$</title>
  </head>
  <body>
  <form id="regForm" action="connexion" method="post">
    <div>
      <p>
        <label for="email">Email</label>
        <input id="email" placeholder="Saisir votre email..." oninput="this.className = ''" name="email" type="email">
      </p>
      <p>
        <label for="mdp">Mot de Passe</label>
        <input id="mdp" placeholder="Saisir votre mot de passe..." oninput="this.className = ''" name="mdp" type="password">
      </p>
      <div style="float:right;">
        <button id="connexion" type="submit">Connexion</button>
        <a href="enregistrement">
        	<button id="connexion" type="button">Inscription</button>
        </a>
      </div>
    </div>
    <br><br>
  </form>
  </body>
</html>
