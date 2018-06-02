<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link rel="stylesheet" href="res/css/styles.css">
<title>Inscription</title>
</head>
<body>
	<form id="regForm" action="enregistrement" method="post">
		<h1>Inscription</h1>
		<!-- One "tab" for each step in the form: -->
		<div class="tab">
			<h3>Informations Candidat(e)</h3>
			<p>
				<input placeholder="Saisir votre prénom..."
					oninput="this.className = ''" name="prenom">
			</p>
			<p>
				<input placeholder="Saisir votre nom..."
					oninput="this.className = ''" name="nom">
			</p>
			<p>
				<input placeholder="Saisir votre email..."
					oninput="this.className = ''" name="email">
			</p>
			<p>
				<input placeholder="Saisir votre mot de passe..."
					oninput="this.className = ''" name="mdp1" type="password">
			</p>
			<p>
				<input placeholder="Confirmer votre mot de passe..."
					oninput="this.className = ''" name="mdp2" type="password">
			</p>
			<p>
<style>
						select:invalid {color: gray;}
				</style>
				<select name="genre" required>
					<option value="" disabled selected hidden>Saisir votre
						genre...</option>
					<option value="Masculin">Masculin</option>
					<option value="Féminin">Féminin</option>
				</select>
				</p>
			<p>
				<input placeholder="Saisir votre nationalité..."
					oninput="this.className = ''" name="nationalite">
			</p>
			<p>
				<input placeholder="Saisir votre téléphone..."
					oninput="this.className = ''" name="telephone"
					pattern="[0-9]{1,10}" maxlength="10" size="10">
			</p>

			<p>
				<input placeholder="Saisir votre aniverssaire..."
					oninput="this.className = ''" name="aniverssaire" type="date">
			</p>
		</div>
		<div class="tab">
			<h3>Informations Candidature</h3>
		<p>
				<input placeholder="Saisir votre établissement..."
					oninput="this.className = ''" name="etablissement" type="text">
			</p>
			<p>
				<input placeholder="Saisir votre diplôme..."
					oninput="this.className = ''" name="diplome" type="text">
			</p>
			<p>
				<input placeholder="Saisir votre note... (Entre 0 et 20)"
					oninput="this.className = ''" name="note" type="number" min="0" max="20" step=".01">
			</p>

			<p>
				<textarea placeholder="Saisir votre motivation..."
					oninput="this.className = ''" name="motivation" type="text"></textarea>
			</p>
		</div>
		<div style="overflow: auto;">
			<div style="float: right;">
				<button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
				<button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
			</div>
		</div>
		<!-- Circles which indicates the steps of the form: -->
		<div style="text-align: center; margin-top: 40px;">
			<span class="step"></span> <span class="step"></span>
		</div>
	</form>
	<script src="res/js/scripts.js"></script>
</body>
</html>
