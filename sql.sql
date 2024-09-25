create database qlbanhang

use qlbanhang

-- tao bang khach hang
CREATE TABLE KHACHHANG(
	MaKhachHANG VARCHAR (30) PRIMARY KEY,
	TenCongTY NVARCHAR (50),
	TenGiaoDich VARCHAR (20),
	DiaChi NVARCHAR (100),
	Email VARCHAR (50),
	DienThoai INT,
	Fax INT
)

CREATE TABLE NHANVIEN(
	MaNhanVien VARCHAR (20),
	Ho NVARCHAR (10),
	Ten NVARCHAR (10),
	NgaySinh date,
	NgayLamViec DATETIME,
	DiaChi NVARCHAR (100),
	DienThoai INT,
	LuongCoBan VARCHAR (20),
	PhuCap VARCHAR (20),
	PRIMARY KEY (MaNhanVien),
)

CREATE TABLE NHACUNGCAP(
	MaCongTy VARCHAR (30) not null,
	TenCongTy NVARCHAR (50) not null,
	TenGiaoDich VARCHAR (30) not null,
	DiaChi NVARCHAR (50) not null,
	DienThoai INT not null,
	Fax INT,
	Email VARCHAR(50) not null,
	PRIMARY KEY (MaCongTy),
)

CREATE TABLE LOAIHANG(
	MaLoaiHang NVARCHAR (30) not null,
	TenLoaiHang NVARCHAR (50),
	PRIMARY KEY (MaLoaiHang),
	)

CREATE TABLE MATHANG(
	MaHang VARCHAR (50) not null,
	TenHang NVARCHAR (50),
	MaCongTy VARCHAR (30) not null,
	MaLoaiHang NVARCHAR (30) not null,
	SoLuong int not null,
	DonViTinh int,
	GiaHang int,
	PRIMARY KEY (MaHang),
	)
	DROP TABLE MATHANG;

CREATE TABLE DONDATHANG(
	SoHoaDon int,
	MaHang VARCHAR (50),
	MaNhanVien VARCHAR (20),
	NgayDatHang datetime,
	NgayGiaoHang datetime,
	NgayChuyenHang datetime,
	NoiGiaoHang NVARCHAR (50),
	PRIMARY KEY (SoHoaDon),
	FOREIGN KEY (MaNhanVien) REFERENCES NHANVIEN(MaNhanVien),
	FOREIGN KEY (MaHang) REFERENCES MATHANG(MaHang)
)

CREATE TABLE ChiTietDatHang(
	SoHoaDon int,
	MaHang VARCHAR (50) not null,
	GiaBan int,
	SoLuong int,
	MucGiamGia int,
	PRIMARY KEY (SoHoaDon),
	FOREIGN KEY (MaHang) REFERENCES KHACHHANG(MaKhachHANG))
ALTER TABLE ChiTietDatHang
		ADD FOREIGN KEY (MaHang) REFERENCES MATHANG(MaHang);
DROP TABLE ChiTietDatHang;
DROP TABLE DONDATHANG;
DROP TABLE KHACHHANG;

