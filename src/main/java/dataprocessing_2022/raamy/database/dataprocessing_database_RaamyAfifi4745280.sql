-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 09 mei 2022 om 11:32
-- Serverversie: 10.4.6-MariaDB
-- PHP-versie: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dataprocessing`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `anime`
--

CREATE TABLE `anime` (
  `uid` int(5) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `genre` varchar(153) DEFAULT NULL,
  `aired` int(4) DEFAULT NULL,
  `episodes` int(5) DEFAULT NULL,
  `members` int(7) DEFAULT NULL,
  `score` varchar(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `anime`
--

INSERT INTO `anime` (`uid`, `title`, `genre`, `aired`, `episodes`, `members`, `score`) VALUES
(1, 'Sword art online', '[\'Fantasy\', \'Drama\', \'Sci-Fi\']', 2020, 5, 45, '8'),
(2, 'Cowboy Bebop: Tengoku no Tobira', '[\'Action\', \'Drama\', \'Mystery\', \'Sci-Fi\', \'Space\']', 2001, 1, 223199, '8.4'),
(3, 'Trigun', '[\'Action\', \'Sci-Fi\', \'Adventure\', \'Comedy\', \'Drama\', \'Shounen\']', 1998, 26, 460146, '8.3'),
(4, 'Witch Hunter Robin', '[\'Action\', \'Magic\', \'Police\', \'Supernatural\', \'Drama\', \'Mystery\']', 2002, 26, 85182, '7.2'),
(5, 'Death Note', '[\'Action\', \'Drama\']', 2015, 12, 5, '4'),
(6, 'One Piece', '[\'Magic\']', 0, 25, 65, '8.0'),
(7, 'Boruto', '[\'Action\', \'Sci-Fi\', \'Space\']', 2019, 50, 45, '10'),
(8, 'Naturo', '[\'Action\', \'Drama\', \'Mystery\', \'Sci-Fi\', \'Space\']', 2007, 5, 45, '8'),
(9, 'Demon Slayer', '[\'Action\', \'Drama\', \'Mystery\']', 2016, 65, 120, '9');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(10);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `profile`
--

CREATE TABLE `profile` (
  `profile` varchar(17) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `birthday` varchar(12) DEFAULT NULL,
  `favorites_anime` varchar(179) DEFAULT NULL,
  `link` varchar(49) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `profile`
--

INSERT INTO `profile` (`profile`, `gender`, `birthday`, `favorites_anime`, `link`) VALUES
('CRYPHTIC', 'Neutral', '14 Oct, 1996', '[\'1\', \'2\']', 'https://myanimelist.net/profile/CRYPHTIC'),
('KingStormy', 'Man', '20 Sep, 2005', '[\'2\', \'4\']', 'https://myanimelist.net/profile/KingStormy'),
('Deury', 'Man', '20 Sep, 2005', '[\'2\', \'3\', \'4\']', 'https://myanimelist.net/profile/Deury'),
('WhiteTiger', 'Women', '10 Aug, 2000', '[\'1\', \'4\']', 'https://myanimelist.net/profile/WhiteTiger'),
('KingCrow', 'Man', '8 Jun, 1999', '[4, 5]', 'https://myanimelist.net/profile/KingCrow'),
('', '', '', '', '');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `review`
--

CREATE TABLE `review` (
  `uid` int(6) NOT NULL,
  `profile` varchar(16) DEFAULT NULL,
  `anime_uid` int(5) DEFAULT NULL,
  `score` int(2) DEFAULT NULL,
  `link` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `review`
--

INSERT INTO `review` (`uid`, `profile`, `anime_uid`, `score`, `link`) VALUES
(1, 'KingStormy', 4, 7, 'https://myanimelist.net/reviews.php?id=1'),
(2, 'KingCrow', 2, 8, 'https://myanimelist.net/reviews.php?id=2'),
(3, 'WhiteTiger', 2, 6, 'https://myanimelist.net/reviews.php?id=3'),
(4, 'Deury', 4, 9, 'https://myanimelist.net/reviews.php?id=4'),
(5, 'Deury', 3, 7, 'https://myanimelist.net/reviews.php?id=5');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `anime`
--
ALTER TABLE `anime`
  ADD PRIMARY KEY (`uid`);

--
-- Indexen voor tabel `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `anime`
--
ALTER TABLE `anime`
  MODIFY `uid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=431;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
