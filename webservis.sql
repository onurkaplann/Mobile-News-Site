-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 02 Şub 2020, 12:38:07
-- Sunucu sürümü: 10.1.38-MariaDB
-- PHP Sürümü: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `webservis`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `haber`
--

CREATE TABLE `haber` (
  `id` int(11) NOT NULL,
  `haberresim` text COLLATE utf8_turkish_ci,
  `haberbaslik` text COLLATE utf8_turkish_ci,
  `habericerik` text COLLATE utf8_turkish_ci,
  `haberturu` text COLLATE utf8_turkish_ci,
  `yayintarihi` text COLLATE utf8_turkish_ci,
  `begendi` int(11) NOT NULL,
  `begenmedi` int(11) NOT NULL,
  `goruntulenme` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `haber`
--

INSERT INTO `haber` (`id`, `haberresim`, `haberbaslik`, `habericerik`, `haberturu`, `yayintarihi`, `begendi`, `begenmedi`, `goruntulenme`) VALUES
(10, 'https://www.aylemoda.com/image/cache/catalog/sifon_sal_butun_renkler/59-Acik_Pudra-Sedef_Sifon_Sal-AYLE_MODA-228x228.jpg', 'DENEME', 'DENEME', 'sondakika', '2020-02-20', 1, 0, 2),
(11, 'https://im.haberturk.com/2018/03/15/ver1521109770/1877475_620x410.jpg', 'DENEME2', 'DEMEME2', 'spor', '2020-02-04', 0, 1, 1);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `haber`
--
ALTER TABLE `haber`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `haber`
--
ALTER TABLE `haber`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
