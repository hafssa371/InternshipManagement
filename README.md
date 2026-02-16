📌 Internship Management Application

📖 Description

Internship est une application web de gestion des stages permettant de connecter trois types d’utilisateurs :

👨‍💼 ADMIN

🏢 RECRUTEUR

🎓 CANDIDAT

L’application permet la gestion des offres de stage, des candidatures et des utilisateurs avec un système d’authentification sécurisé basé sur JWT (JSON Web Token) et Spring Security.

🚀 Fonctionnalités principales
🔐 Authentification & Sécurité

Inscription et connexion des utilisateurs

Authentification basée sur JWT

Gestion des rôles : ADMIN, RECRUTEUR, CANDIDAT

Autorisation d’accès basée sur les rôles (Role-Based Access Control)

👨‍💼 ADMIN

Gestion des utilisateurs

Supervision globale de la plateforme

🏢 RECRUTEUR

Création et gestion des offres de stage

Consultation des candidatures reçues

🎓 CANDIDAT

Consultation des offres disponibles

Soumission de candidatures

🛠️ Technologies utilisées
Backend

Java 21

Spring Boot

Spring Security

JWT

JPA / Hibernate

Oracle Database

Outils

DBeaver (gestion base de données)

Maven

Postman (tests API)

🗄️ Structure de la base de données
Table USERS

ID

EMAIL

NAME

PASSWORD (crypté avec BCrypt)

ROLE (ADMIN / RECRUTEUR / CANDIDAT)

Autres tables

OFFRES

CANDIDATURES

🔑 Sécurité

Les mots de passe sont cryptés avec BCrypt

Le JWT contient :

subject (email)

role

Accès sécurisé aux endpoints selon le rôle

📌 Objectif du projet

Ce projet a été développé pour :

Mettre en pratique Spring Boot & Spring Security

Implémenter une authentification JWT

Gérer les autorisations basées sur les rôles

Concevoir une architecture backend propre et sécurisée

#Réalisation Day1&2 :
Mise en place de l’environnement de développement avec l’ensemble des outils nécessaires (JDK, IDE, Git, etc.).
Création d’une application Spring Boot “Internship Management” afin de rafraîchir et consolider les bases en Java et Spring Boot.
Hébergement de l’application sur un repository GitLab afin de simuler un environnement de développement professionnel (gestion de versions, commits, branches).

#Réalisation Day3 :Approfondissement de la partie backend avec :

Création et configuration d’une base de données Oracle Database.

Mise en place de la connexion entre l’application Spring Boot et Oracle via le driver JDBC Oracle.

Configuration de JPA / Hibernate pour la génération automatique des tables dans Oracle et la gestion de la persistance des données.

Adaptation des types de données et des séquences Oracle pour assurer la compatibilité avec les entités JPA.

Ajout de nouvelles fonctionnalités métier à l’application

#Réalisation Day4 :Introduction à la sécurité applicative.
Implémentation d’une API d’authentification basée sur JWT.

Découverte et compréhension des concepts clés de JWT :

Architecture générale

Génération et validation des tokens

Converters et filtres de sécurité

Intégration de l’authentification JWT dans l’application.

#Réalisation Day5 : Mise en place d’un mécanisme de sécurité basé sur Spring Security intégré avec Keycloak pour la gestion centralisée des identités et des accès.

Approfondissement de Keycloak à travers la conception et le développement d’une API sécurisée permettant :

La gestion de l’authentification des utilisateurs

L’implémentation d’un système de rôles (Admin / User) avec contrôle d’accès basé sur les permissions

Restructuration de l’architecture de sécurité afin d’assurer une meilleure séparation des responsabilités, une configuration plus claire des filtres et une organisation conforme aux bonnes pratiques professionnelles.

#Réalisation Day6 : Mise en place de la documentation interactive de l’API à l’aide de Swagger, permettant la visualisation, la validation et le test des endpoints REST de manière structurée.
Configuration de l’outil pour générer automatiquement la documentation à partir des annotations du code, garantissant une meilleure lisibilité et maintenabilité de l’API.

Implémentation des tests unitaires avec JUnit afin de valider le bon fonctionnement des composants métier (services, méthodes, logique interne) de manière isolée.
Utilisation de Mockito pour simuler les dépendances et assurer une couverture de test fiable.

Développement des tests d’intégration avec Spring Boot afin de vérifier le comportement global de l’application (contrôleurs, services, accès base de données) dans un contexte proche de l’environnement réel.

Adoption d’une approche orientée qualité logicielle visant à améliorer la robustesse, la fiabilité et la maintenabilité du projet.

#Réalisation Day7 : Développement de la partie frontend de l’application avec React, en adoptant une architecture basée sur des composants réutilisables et modulaires.

Mise en place de la gestion des états et des interactions utilisateur à travers les Hooks (useState, useEffect) afin d’assurer une interface dynamique et réactive.

Intégration des APIs backend via des requêtes HTTP (Axios / Fetch) pour permettre la communication sécurisée entre le frontend et les services REST.

Implémentation du routage avec React Router pour organiser la navigation entre les différentes pages de l’application.

Structuration du projet selon les bonnes pratiques (séparation composants / services / pages), afin de garantir une meilleure maintenabilité, évolutivité et lisibilité du code.

Adoption d’une approche orientée expérience utilisateur (UI/UX) pour proposer une interface claire, fluide et professionnelle.

#Réalisation Day8 : Poursuite du développement de la partie frontend de l’application avec React.

Amélioration et structuration des composants existants pour une meilleure réutilisabilité.

Optimisation de la gestion des états et des appels API.

Intégration et test des nouvelles interfaces connectées au backend.

Amélioration de l’expérience utilisateur (UI/UX) et correction des bugs détectés.

Organisation du code selon une architecture plus claire (pages, composants, services).

Objectif : rendre l’interface plus fluide, maintenable et cohérente avec l’architecture globale du projet.




