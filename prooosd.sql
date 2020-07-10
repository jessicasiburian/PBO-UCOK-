-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Jul 2020 pada 01.39
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prooosd`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `carapenyebaran`
--

CREATE TABLE `carapenyebaran` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `isi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `dampak`
--

CREATE TABLE `dampak` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `isi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `dampak`
--

INSERT INTO `dampak` (`id`, `judul`, `isi`) VALUES
(1, 'Dampak Covid-19', 'Virus Corona memiliki dampak yang besar terhadap sejumlah kota di Indonesia, termasuk Sumatera Utara khususnya kota Medan. Berikut ini adalah beberapa dampak Virus Corona di Kota Medan : \n                        -Stok darah yang tersedia di Unit Donor Darah(UDD) Palang Merah Indonesia(PMI) kota Medan menjadi langka.\n                        -Banyak perusahaan yang mengalami kerugian, dan harus merumahkan pekerjanya.\n                        -Perekonomian masyarakat semakin melemah. Pekerja informal tidak memiliki penghasilan.');

-- --------------------------------------------------------

--
-- Struktur dari tabel `gejalaterinfeksi`
--

CREATE TABLE `gejalaterinfeksi` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `isi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `gejalaterinfeksi`
--

INSERT INTO `gejalaterinfeksi` (`id`, `judul`, `isi`) VALUES
(1, 'Gejala Terinfeksi Covid-19', '1.Batuk-batuk\n2.Mulai lemas');

-- --------------------------------------------------------

--
-- Struktur dari tabel `handsanatizer`
--

CREATE TABLE `handsanatizer` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `isi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `handsanatizer`
--

INSERT INTO `handsanatizer` (`id`, `judul`, `isi`) VALUES
(1, 'Cara Pembuatan Handsanitizer', '1. Pertama siapkan mangkuk dan sendok untuk medianya.\n\n2. Kemudian campur alkohol Isopropyl dengan gel lidah buaya hingga tercampur rata.\n\n3. Setelah bahan tercampur rata, tambahkan 8 hingga 10 tetes minyak esensial yang memiliki aroma atau wangi, kemudian aduk rata.\n\nArtikel ini telah tayang di Tribunnews.com dengan judul Cara Membuat Hand Sanitizer Sendiri yang Mudah, Cukup Siapkan 3 Bahan Utama Ini, https://www.tribunnews.com/nasional/2020/03/27/cara-membuat-hand-sanitizer-sendiri-yang-mudah-cukup-siapkan-3-bahan-utama-ini?page=2.\nPenulis: Oktaviani Wahyu Widayanti\nEditor: Miftah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `informasikasuscovid`
--

CREATE TABLE `informasikasuscovid` (
  `id` int(11) NOT NULL,
  `positif` int(11) NOT NULL,
  `sembuh` int(11) NOT NULL,
  `meningal` int(11) NOT NULL,
  `tanggal_buat` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `informasikasuscovid`
--

INSERT INTO `informasikasuscovid` (`id`, `positif`, `sembuh`, `meningal`, `tanggal_buat`) VALUES
(1, 2, 2, 2, '2020-06-03 06:51:14'),
(2, 4, 4, 4, '2020-06-03 06:51:14'),
(6, 5, 2, 4, '2020-07-09 01:24:45');

-- --------------------------------------------------------

--
-- Struktur dari tabel `latarbelakang`
--

CREATE TABLE `latarbelakang` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `isi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `latarbelakang`
--

INSERT INTO `latarbelakang` (`id`, `judul`, `isi`) VALUES
(1, 'Latar Belakang Covid-19', 'Adanya sebuah virus yang mewabah pertama kali di cina');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penangan`
--

CREATE TABLE `penangan` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `isi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penangan`
--

INSERT INTO `penangan` (`id`, `judul`, `isi`) VALUES
(1, 'Penanganan Covid-19', 'Tetap di Rumah\nCara penanganan yang pertama bagi Anda yang mengalami sakit atau gejala ringan COVID-19 dapat pulih di rumah. Hindari keluar rumah, kecuali untuk mendapatkan perawatan medis.\n\nSelain itu, hindari mengunjungi tempat umum dan berkerumunnya orang-orang. Tetap berkomunikasi dengan dokter Anda, dan hubungi sebelum Anda mendapatkan perawatan medis.\n\nPastikan untuk mendapatkan perawatan apabila Anda merasa lebih buruk atau Anda pikir ini parah dari sebelumnya, seperti napas setengah-setengah dalam waktu lama atau kepala pusing seperti semuanya berputar.\n\n2 dari 9 halaman\nHindari Transportasi Umum\nHindari menggunakan transportasi umum, berbagi perjalanan dengan orang lain, atau taksi. Menggunakan transportasi umum yang dipenuhi banyak orang, bisa memicu mereka untuk tertular. Bagi Anda yang merasa sakit ringan, sebainya banyak istirahat di rumah.\n\nJaga Jarak dengan Anggota Keluarga\n\nCara penanganan virus corona bila Anda merasakan gejala ringannya, pastikan untuk menjaga jarak dengan anggota keluarga lain supaya tidak tertular.\n\nGunakan kamar tidur sendiri, serta jika tersedia dan memungkikan menggunakan kamar mandi terpisah.\n\n3 dari 9 halaman\nBatasi Kontak dengan Hewan Peliharaan\nCara penanganan selanjutnya, membatasi kontak dengan hewan peliharaan dan hewan lain. Meskipun belum ada laporan tentang hewan peliharaan atau hewan lain yang sakit dengan COVID-19.\n\nMasih disarankan oleh para ahli supaya orang dengan gejala virus corona membatasi kontak dengan hewan sampai hasil penelitian secara pasti disampaikan.\n\nJika memungkinkan, mintalah anggota keluarga lain yang merawat hewan peliharaan saat Anda sakit COVID-19.\n\nApabila Anda harus merawat hewan peliharaan, pastikan untuk mencuci tangan sebelum dan setelah Anda berinteraksi dengan mereka. Pantau selalu informasi mengenai COVID-19 dan hewan untuk lebih lanjut.');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pencegahan`
--

CREATE TABLE `pencegahan` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `isi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `username` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`username`, `nama`, `password`, `role`) VALUES
('joh', 'Johannes PM Manurung', '123', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penyebab`
--

CREATE TABLE `penyebab` (
  `id` int(11) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `isi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `rumahsakitrujukan`
--

CREATE TABLE `rumahsakitrujukan` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `nomor telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `rumahsakitrujukan`
--

INSERT INTO `rumahsakitrujukan` (`id`, `nama`, `alamat`, `nomor telepon`) VALUES
(1, 'Adam Malik', 'Medan', '0822');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `carapenyebaran`
--
ALTER TABLE `carapenyebaran`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `dampak`
--
ALTER TABLE `dampak`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `gejalaterinfeksi`
--
ALTER TABLE `gejalaterinfeksi`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `handsanatizer`
--
ALTER TABLE `handsanatizer`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `informasikasuscovid`
--
ALTER TABLE `informasikasuscovid`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `latarbelakang`
--
ALTER TABLE `latarbelakang`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `penangan`
--
ALTER TABLE `penangan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pencegahan`
--
ALTER TABLE `pencegahan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `rumahsakitrujukan`
--
ALTER TABLE `rumahsakitrujukan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `carapenyebaran`
--
ALTER TABLE `carapenyebaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `dampak`
--
ALTER TABLE `dampak`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `gejalaterinfeksi`
--
ALTER TABLE `gejalaterinfeksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `handsanatizer`
--
ALTER TABLE `handsanatizer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `informasikasuscovid`
--
ALTER TABLE `informasikasuscovid`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `latarbelakang`
--
ALTER TABLE `latarbelakang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `penangan`
--
ALTER TABLE `penangan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `pencegahan`
--
ALTER TABLE `pencegahan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `rumahsakitrujukan`
--
ALTER TABLE `rumahsakitrujukan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
