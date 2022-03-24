-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 24 mrt 2022 om 23:12
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
  `aired` varchar(28) DEFAULT NULL,
  `episodes` varchar(5) DEFAULT NULL,
  `members` int(7) DEFAULT NULL,
  `score` varchar(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `anime`
--

INSERT INTO `anime` (`uid`, `title`, `genre`, `aired`, `episodes`, `members`, `score`) VALUES
(1, 'Cowboy Bebop', '[\'Action\', \'Adventure\', \'Comedy\', \'Drama\', \'Sci-Fi\', \'Space\']', 'Apr 3, 1998 to Apr 24, 1999', '26.0', 930311, '8.81'),
(2, 'Cowboy Bebop: Tengoku no Tobira', '[\'Action\', \'Drama\', \'Mystery\', \'Sci-Fi\', \'Space\']', 'Sep 1, 2001', '1.0', 223199, '8.4'),
(3, 'Trigun', '[\'Action\', \'Sci-Fi\', \'Adventure\', \'Comedy\', \'Drama\', \'Shounen\']', 'Apr 1, 1998', '26.0', 460146, '8.3'),
(4, 'Witch Hunter Robin', '[\'Action\', \'Magic\', \'Police\', \'Supernatural\', \'Drama\', \'Mystery\']', 'Jul 2, 2002', '26.0', 85182, '7.2'),
(5, 'Bouken Ou Beet', '[\'Adventure\', \'Fantasy\', \'Shounen\', \'Supernatural\']', 'Sep 30, 2004', '52.0', 12319, '7.0');

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
('KingCrow', 'Man', '8 Jun, 1999', '[4, 5]', 'https://myanimelist.net/profile/KingCrow');

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
  MODIFY `uid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
