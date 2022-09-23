-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 20 Agu 2022 pada 13.31
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistem_penjualan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `daftar_mandi`
--

CREATE TABLE `daftar_mandi` (
  `no_antrian` int(11) NOT NULL,
  `nama_pemilik` varchar(50) NOT NULL,
  `nama_hewan` varchar(50) NOT NULL,
  `jenis_mandi` varchar(50) NOT NULL,
  `harga` double NOT NULL,
  `format_harga` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `daftar_mandi`
--

INSERT INTO `daftar_mandi` (`no_antrian`, `nama_pemilik`, `nama_hewan`, `jenis_mandi`, `harga`, `format_harga`) VALUES
(1, 'Rayhan', 'Tes1', 'Mandi Biasa', 50000, 'Rp. 50,000'),
(2, 'Aho', 'Tes2', 'Mandi Kutu', 70000, 'Rp. 70,000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_barang`
--

CREATE TABLE `data_barang` (
  `kode_barang` varchar(50) NOT NULL,
  `kategori_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `harga_barang` double NOT NULL,
  `format_harga_satuan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_barang`
--

INSERT INTO `data_barang` (`kode_barang`, `kategori_barang`, `nama_barang`, `harga_barang`, `format_harga_satuan`) VALUES
('KB-001', 'Makanan', 'Bolt 1kg', 30000, 'Rp. 30,000'),
('KB-002', 'Pasir', 'Vetsand 20L', 80000, 'Rp. 80,000'),
('KB-003', 'Makanan', 'Felibite 800g', 40000, 'Rp. 40,000'),
('KB-004', 'Vitamin/Obat', 'Flu Cat 15mL', 15000, 'Rp. 15,000'),
('KB-005', 'Vitamin/Obat', 'Scandik 20mL', 30000, 'Rp. 30,000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE `pembelian` (
  `nama_barang` varchar(50) NOT NULL,
  `kategori_barang` varchar(50) NOT NULL,
  `jumlah` varchar(50) NOT NULL,
  `harga_barang` double NOT NULL,
  `format_harga` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `total_harga` varchar(50) NOT NULL,
  `uang_bayar` varchar(50) NOT NULL,
  `uang_kembalian` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi_mandi`
--

CREATE TABLE `transaksi_mandi` (
  `nama_pemilik` varchar(50) NOT NULL,
  `nama_hewan` varchar(50) NOT NULL,
  `jenis_mandi` varchar(50) NOT NULL,
  `harga` varchar(50) NOT NULL,
  `uang_bayar` varchar(50) NOT NULL,
  `uang_kembali` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `daftar_mandi`
--
ALTER TABLE `daftar_mandi`
  ADD PRIMARY KEY (`no_antrian`);

--
-- Indeks untuk tabel `data_barang`
--
ALTER TABLE `data_barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indeks untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`nama_barang`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`total_harga`);

--
-- Indeks untuk tabel `transaksi_mandi`
--
ALTER TABLE `transaksi_mandi`
  ADD PRIMARY KEY (`nama_hewan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
