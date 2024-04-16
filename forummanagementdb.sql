-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 06 fév. 2024 à 21:32
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `forummanagementdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `application`
--

CREATE TABLE `application` (
  `id_application` bigint(20) NOT NULL,
  `discussion` bit(1) NOT NULL,
  `is_accepted` bit(1) NOT NULL,
  `offer_application_id_offer` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `blog`
--

CREATE TABLE `blog` (
  `id_blog` bigint(20) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_blog_id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `feed_back`
--

CREATE TABLE `feed_back` (
  `id_feed_back` bigint(20) NOT NULL,
  `rating` bigint(20) NOT NULL,
  `feed_back_content` varchar(255) DEFAULT NULL,
  `feed_back_type` enum('Bug_Report','Feature_Request','General_FeedBack') DEFAULT NULL,
  `priority` enum('High','Low','Medium') DEFAULT NULL,
  `submited_date` date DEFAULT NULL,
  `user_feed_back_id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `interview`
--

CREATE TABLE `interview` (
  `id_interview` bigint(20) NOT NULL,
  `class_room` varchar(255) DEFAULT NULL,
  `interview_date` date DEFAULT NULL,
  `interview_type` enum('INPERSON','ONLINE') DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `application_interview_id_application` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `messaging`
--

CREATE TABLE `messaging` (
  `id_message` bigint(20) NOT NULL,
  `is_seen` bit(1) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `response` varchar(255) DEFAULT NULL,
  `sending_date` date DEFAULT NULL,
  `user_messaging_id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `offer`
--

CREATE TABLE `offer` (
  `id_offer` bigint(20) NOT NULL,
  `closing_date` date DEFAULT NULL,
  `employement_type` enum('FullTimeJob','Internship','PartTimeJob') DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `offer_description` varchar(255) DEFAULT NULL,
  `offer_status` varchar(255) DEFAULT NULL,
  `offer_title` varchar(255) DEFAULT NULL,
  `posting_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `offer_users_offer`
--

CREATE TABLE `offer_users_offer` (
  `offers_id_offer` bigint(20) NOT NULL,
  `users_offer_id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `request`
--

CREATE TABLE `request` (
  `id_request` bigint(20) NOT NULL,
  `cv` varchar(255) DEFAULT NULL,
  `user_request_id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `stand`
--

CREATE TABLE `stand` (
  `id_stand` bigint(20) NOT NULL,
  `gallery` varchar(255) DEFAULT NULL,
  `immatriculation_stand` varchar(255) DEFAULT NULL,
  `is_finished` bit(1) NOT NULL,
  `is_partner` bit(1) NOT NULL,
  `is_reserved` bit(1) NOT NULL,
  `pack` enum('DIAMOND','GOLD','SILVER','UNPAYED') DEFAULT NULL,
  `price` float NOT NULL,
  `reservation_date` date DEFAULT NULL,
  `user_stand_id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` bigint(20) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `domain_of_studies` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `immatriculation_number` varchar(255) DEFAULT NULL,
  `inscription_date` date DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `level_of_studies` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('Admin','Alumny','Exposant','Professor','Student','Supplier') DEFAULT NULL,
  `sector_of_activity` enum('Bussiness','Civil_Engineering','Electromechanical','IT') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user_applications`
--

CREATE TABLE `user_applications` (
  `user_id_user` bigint(20) NOT NULL,
  `applications_id_application` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`id_application`),
  ADD KEY `FKlxagrgk6d4ccu5ebr6ohbknbu` (`offer_application_id_offer`);

--
-- Index pour la table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id_blog`),
  ADD KEY `FK39yfg5dwnbaj0v2bfn6snalck` (`user_blog_id_user`);

--
-- Index pour la table `feed_back`
--
ALTER TABLE `feed_back`
  ADD PRIMARY KEY (`id_feed_back`),
  ADD KEY `FKq08pr58qf9pd8nl990vd9gw3r` (`user_feed_back_id_user`);

--
-- Index pour la table `interview`
--
ALTER TABLE `interview`
  ADD PRIMARY KEY (`id_interview`),
  ADD UNIQUE KEY `UK_eut2wbnpbg6bcr3qeumvvu6w1` (`application_interview_id_application`);

--
-- Index pour la table `messaging`
--
ALTER TABLE `messaging`
  ADD PRIMARY KEY (`id_message`),
  ADD KEY `FK8wj917dhvqr5rge9qnv04uper` (`user_messaging_id_user`);

--
-- Index pour la table `offer`
--
ALTER TABLE `offer`
  ADD PRIMARY KEY (`id_offer`);

--
-- Index pour la table `offer_users_offer`
--
ALTER TABLE `offer_users_offer`
  ADD PRIMARY KEY (`offers_id_offer`,`users_offer_id_user`),
  ADD KEY `FKfpfs8h57g7sya5pcqbi48og2t` (`users_offer_id_user`);

--
-- Index pour la table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id_request`),
  ADD KEY `FKdofrtdc11n551yfboiw8dynkq` (`user_request_id_user`);

--
-- Index pour la table `stand`
--
ALTER TABLE `stand`
  ADD PRIMARY KEY (`id_stand`),
  ADD KEY `FKs681t74ln60lngbhd36mr3jhn` (`user_stand_id_user`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Index pour la table `user_applications`
--
ALTER TABLE `user_applications`
  ADD PRIMARY KEY (`user_id_user`,`applications_id_application`),
  ADD UNIQUE KEY `UK_cul3s3c5ri1v0ksa943e6lfxn` (`applications_id_application`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `application`
--
ALTER TABLE `application`
  MODIFY `id_application` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `blog`
--
ALTER TABLE `blog`
  MODIFY `id_blog` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `feed_back`
--
ALTER TABLE `feed_back`
  MODIFY `id_feed_back` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `interview`
--
ALTER TABLE `interview`
  MODIFY `id_interview` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `messaging`
--
ALTER TABLE `messaging`
  MODIFY `id_message` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `offer`
--
ALTER TABLE `offer`
  MODIFY `id_offer` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `request`
--
ALTER TABLE `request`
  MODIFY `id_request` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `stand`
--
ALTER TABLE `stand`
  MODIFY `id_stand` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `FKlxagrgk6d4ccu5ebr6ohbknbu` FOREIGN KEY (`offer_application_id_offer`) REFERENCES `offer` (`id_offer`);

--
-- Contraintes pour la table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `FK39yfg5dwnbaj0v2bfn6snalck` FOREIGN KEY (`user_blog_id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `feed_back`
--
ALTER TABLE `feed_back`
  ADD CONSTRAINT `FKq08pr58qf9pd8nl990vd9gw3r` FOREIGN KEY (`user_feed_back_id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `interview`
--
ALTER TABLE `interview`
  ADD CONSTRAINT `FKfo1tiqlydo2ss4f7mpcael1by` FOREIGN KEY (`application_interview_id_application`) REFERENCES `application` (`id_application`);

--
-- Contraintes pour la table `messaging`
--
ALTER TABLE `messaging`
  ADD CONSTRAINT `FK8wj917dhvqr5rge9qnv04uper` FOREIGN KEY (`user_messaging_id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `offer_users_offer`
--
ALTER TABLE `offer_users_offer`
  ADD CONSTRAINT `FKfpfs8h57g7sya5pcqbi48og2t` FOREIGN KEY (`users_offer_id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FKqt2m9iu6ofl3310yudwrooc13` FOREIGN KEY (`offers_id_offer`) REFERENCES `offer` (`id_offer`);

--
-- Contraintes pour la table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `FKdofrtdc11n551yfboiw8dynkq` FOREIGN KEY (`user_request_id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `stand`
--
ALTER TABLE `stand`
  ADD CONSTRAINT `FKs681t74ln60lngbhd36mr3jhn` FOREIGN KEY (`user_stand_id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `user_applications`
--
ALTER TABLE `user_applications`
  ADD CONSTRAINT `FK1p3kb5v6dw2q9mxrl65gggc0q` FOREIGN KEY (`applications_id_application`) REFERENCES `application` (`id_application`),
  ADD CONSTRAINT `FKctwmwl3ur4vij4nkd17mi8vel` FOREIGN KEY (`user_id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
