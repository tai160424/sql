CREATE DATABASE QLBH
USE QLBH
CREATE TABLE KHACHHANG
(
	MaKhachHang	INT PRIMARY KEY,
	TenCongTy	NVARCHAR(50),
	TenGiaoDich	NVARCHAR(20),
	DiaChi		NVARCHAR(50),
	Email		VARCHAR(30),
	DienThoai	VARCHAR(15),
	Fax			VARCHAR(15),
)

CREATE TABLE NHACUNGCAP
(
	MaCongTy	CHAR(3) PRIMARY KEY(MaCongTy),
	TenCongTy	NVARCHAR(50),
	TenGiaoDich	NVARCHAR(20),
	DiaChi		NVARCHAR(50),
	DienThoai	VARCHAR(15),
	Fax			VARCHAR(15),
	Email		VARCHAR(30),
)

CREATE TABLE LOAIHANG
(
	MaLoaiHang	CHAR(2) PRIMARY KEY,
	TenLoaiHang	NVARCHAR(30),
)

CREATE TABLE MATHANG
(
	MaHang		CHAR(4) PRIMARY KEY,
	TenHang		NVARCHAR(30),
	MaCongTy	CHAR(3),
	MaLoaiHang	CHAR(2),
	SoLuong		INT,
	DonViTinh	NVARCHAR(10),
	GiaHang		INT,
	FOREIGN KEY(MaLoaiHang) REFERENCES LOAIHANG(MaLoaiHang),
	--CONSTRAINT FK_MATHANG_MaCongTy 
	FOREIGN KEY(MaCongTy) REFERENCES NHACUNGCAP(MaCongTy)
)

CREATE TABLE NHANVIEN
(
	MaNhanVien	CHAR(4)
				CONSTRAINT PK_NHANVIEN_MaKhachHang PRIMARY KEY,
	Ho			NVARCHAR(40),
	Ten			NVARCHAR(10),
	NgaySinh	DATETIME,
	NgayLamViec	DATETIME,
	DiaChi		NVARCHAR(60),
	DienThoai	VARCHAR(15),
	LuongCoBan	INT,
	PhuCap		INT,
)
CREATE TABLE DONDATHANG
(
	SoHoaDon		INT
					CONSTRAINT PK_DONDATHANG_SoHoaDon PRIMARY KEY,
	MaKhachHang		INT,
	MaNhanVien		CHAR(4),
	NgayDatHang		DATETIME,
	NgayGiaoHang	DATETIME,
	NgayChuyenHang	DATETIME,
	NoiGiaoHang		NVARCHAR(80),
	CONSTRAINT FK_DONDATHANG_MaKhachHang FOREIGN KEY(MaKhachHang)
			REFERENCES KHACHHANG(MaKhachHang),
	CONSTRAINT FK_DONDATHANG_MaNhanVien FOREIGN KEY(MaNhanVien)
			REFERENCES NHANVIEN(MaNhanVien),
)

CREATE TABLE CHITIETDATHANG
(
	SoHoaDon	INT,
	MaHang		CHAR(4),
	GiaBan		NUMERIC(10,2),
	SoLuong		INT,
	MucGiamGia	NUMERIC(10,2),
	CONSTRAINT  PK_CHITIETDATHANG_SoHoaDon_MaHang PRIMARY KEY(SoHoaDon, MaHang),
	CONSTRAINT  FK_CHITIETDATHANG_SoHoaDon FOREIGN KEY(SoHoaDon)
			REFERENCES DONDATHANG(SoHoaDon),
	CONSTRAINT  FK_CHITIETDATHANG_MaHang FOREIGN KEY(MaHang)
			REFERENCES MATHANG(MaHang),
)


INSERT INTO LOAIHANG VALUES('TP', N'Thực phẩm');
INSERT INTO LOAIHANG VALUES('DT', N'Ðiện tử');
INSERT INTO LOAIHANG VALUES('MM', N'May mặc');
INSERT INTO LOAIHANG VALUES('NT', N'Nội thất');
INSERT INTO LOAIHANG VALUES('DC', N'Dụng cụ học tập');

INSERT INTO KHACHHANG VALUES(1, N'Công ty sữa Việt Nam', 'VINAMILK', N'Hà Nội', 'vinamilk@vietnam.com', '04-891135', '');
INSERT INTO KHACHHANG VALUES(2, N'Công ty may mặc Việt Tiến', 'VIETTIEN', N'Sài Gòn', 'viettien@vietnam.com','08-808803','');
INSERT INTO KHACHHANG VALUES(3, N'Tổng công ty thực phẩm dinh dưỡng NUTRIFOOD', 'NUTRIFOOD', N'Sài Gòn', 'nutrifood@vietnam.com','08-809890','');
INSERT INTO KHACHHANG VALUES(4, N'Công ty điện máy Hà Nội', 'MACHANOI', N'Hà Nội', 'machanoi@vietnam.om','04-898399','');
INSERT INTO KHACHHANG VALUES(5, N'Hãng hàng không Việt Nam','VIETNAMAIRLINES',N'Sài Gòn','vietnamairlines@vietnam.com','08-888888','');
INSERT INTO KHACHHANG VALUES(6, N'Công ty dụng cụ học sinh MIC','MIC', N'Hà Nội','mic@vietnam.com','04-804408','');

INSERT INTO NHANVIEN VALUES('A001', N'Đậu Tố', N'Anh', '03/07/1986','03/01/2009', N'Quy Nhơn', '056-647995', 10000000, 1000000);
INSERT INTO NHANVIEN VALUES('H001', N'Lê Thị Bích', N'Hoa', '05/20/1986','03/01/2009', N'An Khê', '', 9000000, 1000000);
INSERT INTO NHANVIEN VALUES('H002', N'Ông Hoàng', N'Hải', '08/11/1987','03/01/2009', N'Đà Nẵng', '0905-611725', 12000000, 0);
INSERT INTO NHANVIEN VALUES('H003', N'Trần Nguyễn Đức', N'Hoàng', '04/09/1986','03/01/2009', N'Quy Nhơn','', 11000000, 0);
INSERT INTO NHANVIEN VALUES('P001', N'Nguyễn Hoài', N'Phong', '06/14/1986', '03/01/2009', N'Quy Nhơn','056-891135', 13000000, 0);
INSERT INTO NHANVIEN VALUES('Q001', N'Trương Thị Thế', N'Quang', '06/17/1987', '03/01/2009', N'Ayunpa','0979-792176', 10000000, 500000);
INSERT INTO NHANVIEN VALUES('T001', N'Nguyễn Đức', N'Thắng', '09/13/1984', '03/01/2009', N'Phù Mỹ', '0955-593893', 1200000,0);
INSERT INTO NHANVIEN VALUES('D001', N'Nguyễn Minh', N'Đăng', '12/29/1987', '03/01/2009', N'Quy Nhơn','0905-779919', 14000000, 0);
INSERT INTO NHANVIEN VALUES('M001', N'Hồ Thị Phương', N'Mai', '09/14/1987', '03/01/2009', N'Tây Sơn','', 9000000, 500000);

INSERT INTO NHACUNGCAP VALUES('VNM', N'Công ty sữa Việt Nam', 'VINAMILK', N'Hà Nội', '04-891135', '', 'vinamilk@vietnam.com');
INSERT INTO NHACUNGCAP VALUES('MVT', N'Công ty may mặc Việt Tiến', 'VIETTIEN', N'Sài Gòn', '08-808803', '', 'viettien@vietnam.com');
INSERT INTO NHACUNGCAP VALUES('SCM', N'Siêu thị Coop-mart', 'COOPMART', N'Quy Nhơn', '056-888666', '', 'coopmart@vietnam.com');
INSERT INTO NHACUNGCAP VALUES('DQV', N'Công ty máy tính Quang Vũ', 'QUANGVU', N'Quy Nhơn', '056-888777', '', 'quangvu@vietnam.com');
INSERT INTO NHACUNGCAP VALUES('DAF', N'Nội thất Đài Loan Dafuco', 'DAFUCO', N'Quy Nhơn', '056-888111', '', 'dafuco@vietnam.com');
INSERT INTO NHACUNGCAP VALUES('GOL', N'Công ty sản xuất dụng cụ học sinh Golden', 'GOLDEN', N'Quy Nhơn', '056-891135', '', 'golden@vietnam.com');

INSERT INTO MATHANG VALUES('TP01', N'Sửa hộp XYZ', 'VNM', 'TP', 10, N'Hộp', 4000);
INSERT INTO MATHANG VALUES('TP02', N'Sửa XO', 'VNM', 'TP', 12, N'Hộp', 180000);
INSERT INTO MATHANG VALUES('TP03', N'Sửa tươi Vinamilk không đường', 'VNM', 'TP', 5000, N'Hộp', 3500);
INSERT INTO MATHANG VALUES('TP04', N'Táo', 'SCM', 'TP', 12, N'Ký', 12000);
INSERT INTO MATHANG VALUES('TP05', N'Cà chua', 'SCM', 'TP', 15, N'Ký', 5000);
INSERT INTO MATHANG VALUES('TP06', N'Bánh AFC', 'SCM', 'TP', 100, N'Hộp', 3000);
INSERT INTO MATHANG VALUES('TP07', N'Mì tôm A-One', 'SCM', 'TP', 150, N'Thùng', 40000);
INSERT INTO MATHANG VALUES('MM01', N'Đồng phục công sở nữ', 'MVT', 'MM', 140, N'Bộ', 340000);
INSERT INTO MATHANG VALUES('MM02', N'Veston nam', 'MVT', 'MM', 30, N'Bộ', 500000);
INSERT INTO MATHANG VALUES('MM03', N'Áo sơ mi nam', 'MVT', 'MM', 20, N'Cái', 75000);
INSERT INTO MATHANG VALUES('DT01', N'LCD Nec', 'DQV', 'DT', 10, N'Cái', 3100000);
INSERT INTO MATHANG VALUES('DT02', N'Ổ cứng 80GB', 'DQV', 'DT', 20, N'Cái', 800000);
INSERT INTO MATHANG VALUES('DT03', N'Bàn phím Mitsumi', 'DQV', 'DT', 20 , N'Cái', 150000);
INSERT INTO MATHANG VALUES('DT04', N'Tivi LCD', 'DQV', 'DT', 10, N'Cái', 20000000);
INSERT INTO MATHANG VALUES('DT05', N'Máy tính xách tay NEC', 'DQV', 'DT', 60, N'Cái', 18000000);
INSERT INTO MATHANG VALUES('NT01', N'Bàn ghế ăn', 'DAF', 'NT', 20, N'Bộ', 1000000);
INSERT INTO MATHANG VALUES('NT02', N'Bàn ghế Salon', 'DAF', 'NT', 20, N'Bộ', 150000);
INSERT INTO MATHANG VALUES('DC01', N'Vở học sinh cao cấp', 'GOL', 'DC', 20000 , N'Ram', 48000);
INSERT INTO MATHANG VALUES('DC02', N'Viết bi học sinh', 'GOL', 'DC', 2000 , N'Cây', 2000);
INSERT INTO MATHANG VALUES('DC03', N'Hộp màu tô', 'GOL', 'DC', 2000 , N'Hộp', 7500);
INSERT INTO MATHANG VALUES('DC04', N'Viết mực cao cấp', 'GOL', 'DC', 2000 , N'Cây', 20000);
INSERT INTO MATHANG VALUES('DC05', N'Viết chì 2B', 'GOL', 'DC', 2000 , N'Cây', 3000);
INSERT INTO MATHANG VALUES('DC06', N'Viết chì 4B', 'GOL', 'DC', 2000 , N'Cây', 6000);

INSERT INTO DONDATHANG VALUES(1, 1, 'A001', '09/20/2007', '10/01/2007', '10/01/2007', N'Hà Nội');
INSERT INTO DONDATHANG VALUES(2, 1, 'H001', '09/20/2007', '10/01/2007', '10/01/2007', N'Hà Nội');
INSERT INTO DONDATHANG VALUES(3, 2, 'H002', '09/20/2007', '10/01/2007', '10/01/2007', N'Sài Gòn');
INSERT INTO DONDATHANG VALUES(4, 3, 'H003', '09/20/2007', '10/01/2007', '10/01/2007', N'Sài Gòn');
INSERT INTO DONDATHANG VALUES(5, 4, 'P001', '09/20/2007', '10/01/2007', '10/01/2007', N'Hà Nội');
INSERT INTO DONDATHANG VALUES(6, 5, 'D001', '09/20/2007', '10/01/2007', '10/01/2007', N'Hà Nội');
INSERT INTO DONDATHANG VALUES(7, 6, 'M001', '09/20/2007', '10/01/2007', '10/01/2007', N'Hà Nội');
INSERT INTO DONDATHANG VALUES(8, 2, 'Q001', '09/20/2007', '10/01/2007', '10/01/2007', N'Sài Gòn');
INSERT INTO DONDATHANG VALUES(9, 3, 'T001', '09/20/2007', '10/01/2007', '10/01/2007', N'Sài Gòn');


INSERT INTO CHITIETDATHANG VALUES(9, 'DC01', 48000, 1000, 0);
INSERT INTO CHITIETDATHANG VALUES(9, 'DC02', 2000, 1000, 0);
INSERT INTO CHITIETDATHANG VALUES(9, 'DC03', 7500, 1000, 0);
INSERT INTO CHITIETDATHANG VALUES(8, 'DT04', 20000000, 2, 1000000);
INSERT INTO CHITIETDATHANG VALUES(7, 'TP03', 3000, 200, 0);
INSERT INTO CHITIETDATHANG VALUES(4, 'MM01', 340000, 80, 10000);
INSERT INTO CHITIETDATHANG VALUES(5, 'TP03', 3000, 1000, 0);
INSERT INTO CHITIETDATHANG VALUES(6, 'DT05', 18000000, 20, 1000000);
INSERT INTO CHITIETDATHANG VALUES(6, 'DT01', 3100000, 2, 100000);
INSERT INTO CHITIETDATHANG VALUES(3, 'MM01', 340000, 30, 10000);
INSERT INTO CHITIETDATHANG VALUES(3, 'MM02', 500000, 30, 20000);
INSERT INTO CHITIETDATHANG VALUES(2, 'MM02', 500000, 20, 20000);
INSERT INTO CHITIETDATHANG VALUES(2, 'MM01', 340000, 30, 10000);
INSERT INTO CHITIETDATHANG VALUES(1, 'TP01', 4000, 5, 0);
INSERT INTO CHITIETDATHANG VALUES(1, 'TP02', 180000, 5, 5000);
INSERT INTO CHITIETDATHANG VALUES(1, 'TP03', 12000, 5, 0);
INSERT INTO CHITIETDATHANG VALUES(1, 'TP06', 3000, 50, 0);
INSERT INTO CHITIETDATHANG VALUES(1, 'TP07', 40000,100, 0);

---câu 1: cho biết danh sách các đối tác cung cấp hàng hoá cho công ty
SELECT thuộc tính
FROM bảng
WHERE điều kiện

SELECT MaCongTy, TenCongty
FROM NHACUNGCAP

---câu 2: mã hàng, tên hàng, và số lượng của các mặt hàng hiện có trong công ty
 
SELECT MaHang, TenHang,SoLuong
FROM MATHANG

---câu 3: họ tên, địa chỉ và năm bắt đầu làm việc của các nhân viên trong công ty

SELECT Ho +' '+ Ten as HoTen, DiaChi, year(NgayLamViec) as NamLamViec
FROM NHANVIEN

---câU 4: địa chỉ, điện thoại của nhà cung cấp có tên giao dịch Vinamilk

SELECT TenGiaoDich, DiaChi, DienThoai
FROM NHACUNGCAP 
WHERE TenGiaoDich LIKE 'VINAMILK'

---câu 5: mã và tên của các mặt hàng có giá trị lớn hơn 100000 và số lượng hiện có ít hơn 50

SELECT MaHang, TenHang, GiaHang, SoLuong
FROM MATHANG
WHERE GiaHang > 100000 and SoLuong < 50

---câu 6: cho biết mỗi mặt hàng trong công ty do ai cung cấp.

---cách 1:
SELECT tenhang, tencongty
FROM MATHANG mh, NHACUNGCAP ncc
WHERE mh.MaCongTy = ncc.MaCongTy 
 

---câu 7: công ty việt tiến đã cung cấp những mặt hàng nào.

SELECT  MaHang, TenHang
FROM MATHANG mh, NHACUNGCAP ncc
WHERE  mh.MaCongTy = ncc.MaCongTy AND ncc.TenCongTy Like  N'%Việt Tiến%' /* do VIỆT TIẾN NẰM TRONG NÊN LÀ 2 DẤU % */

---câu 8: loại hàng thực phẩm do những công ty nào cung cấp, địa chỉ của công ty đó.

SELECT	tencongty, diachi
FROM	MATHANG mh, NHACUNGCAP ncc, LOAIHANG lh
WHERE	mh.MaCongTy=ncc.MaCongTy AND mh.MaLoaiHang = lh.MaLoaiHang AND lh.TenLoaiHang Like N'Thực phẩm'

--câu 9: Những khách hàng nào(ten giao dich) đã đặt mua mặt hàng sữa hộp của công ty.

SELECT	tengiaodich 
FROM	KHACHHANG kh, DONDATHANG ddh, CHITIETDATHANG ct,   MATHang mh
WHERE	kh.MaKhachHang = ddh.MaKhachHang ANd ddh.SoHoaDon = ct.SoHoaDon AND ct.MaHang = mh.MaHang and mh.TenHang Like N'Sửa hộp XYZ'

--câu 10: 

SELECT nv.MaNhanVien, nv.Ten, ddh.NoiGiaoHang, ddh.NgayGiaoHang
FROM	NHANVIEN nv, DONDATHANG ddh
WHERE	nv.MaNhanVien = ddh.MaNhanVien AND ddh.SoHoaDon LIKE 1

--câu 11

SELECT	Ten, (LuongCoBan + PhuCap) AS luong
FROM	NHANVIEN

--câu 12

SELECT mh.MaHang, ct.GiaBan, ((ct.SoLuong * GiaBan) - (ct.SoLuong * GiaBan * MucGiamGia /100)) AS TIENPHAITRA
FROM CHITIETDATHANG ct, MATHANG mh
WHERE ct.MaHang = mh.MaHang and ct.SoHoaDon LIKE 3

--câu 13 

SELECT	kh.TenCongTy
FROM	KHACHHANG kh, DONDATHANG ddh, CHITIETDATHANG ct, MATHANG mh, NHACUNGCAP ncc
WHERE	kh.MaKhachHang = ddh.MaKhachHang
AND ddh.SoHoaDon = ct.SoHoaDon
		AND ct.MaHang = mh.MaHang 
		AND mh.MaCongTy = ncc.MaCongTy
		AND kh.TenGiaoDich = ncc.TenGiaoDich

--câu 14

SELECT	v1.MaNhanVien, v2.MaNhanVien
FROM	NHANVIEN v1, NHANVIEN v2
WHERE	 v1.NgaySinh = v2.NgaySinh
		AND v1.MaNhanVien <> v2.MaNhanVien

--câu 15

SELECT	ddh.SoHoaDon, kh.TenCongTy
FROM	DONDATHANG ddh, KHACHHANG kh, NHACUNGCAP ncc
WHERE   kh.DiaChi = ncc.DiaChi AND ddh.MaKhachHang = kh.MaKhachHang

---câu 16: Cho biết tên công ty, tên giao dịch, địa chỉ và điện thoại của các nhà cung cấp hàng cho công ty

(SELECT TenCongTy, TenGiaoDich , DiaChi , DienThoai
FROM KHACHHANG)
UNION  ---phép hợp
(SELECT TenCongTy , TenGiaoDich , DiaChi , DienThoai
FROM NHACUNGCAP)

---câu 17: Những mặt hàng nào chưa từng được khách hàng đặt mua, danh sách tổng các mặt hàng trong bảng

(SELECT MaHang 
FROM MATHANG)
EXCEPT ---phép trừ
(SELECT MaHang
FROM CHITIETDATHANG)

---câu 18: Những nhân viên nào của công ty chưa từng lập hoá đơn đặt hàng nào

SELECT
FROM
WHERE

---câu 19: Những nhân viên nào có lương cơ bản cao nhất

SELECT *
FROM NHANVIEN
WHERE LuongCoBan = (SELECT MAX(LuongCoBan)
     FROM NHANVIEN)
---cách 2:
SELECT TOP 1 *
FROM NHANVIEN
ORDER BY LuongCoBan DESC

---câu 20: Tổng số tiền mà khách hàng phải trả cho mỗi đơn đặt hàng là bao nhiêu

SELECT SoHoaDon, SUM(GIABAN*SOLUONG) TONGTIEN
FROM CHITIETDATHANG
GROUP BY SoHoaDon

---câu 21: Trong năm 2007 những mặt hàng nào được đặt mua 
SELECT MaHang , COUNT(*) SOLANMUA
FROM CHITIETDATHANG C
 JOIN DONDATHANG D ON C.SoHoaDon = D.SoHoaDon
WHERE YEAR(NGAYDATHANG) = 2007
GROUP BY MaHang
HAVING COUNT (*) =1

--cau 22: Moi khach hang phai bo ra bao nhieu tien de dat mua hang cua cong ty
SELECT 



--cau 23: 
SELECT N.MANHANVIEN, HO, TEN, COUNT(SOHOADON)AS 'SO HOA DON DA LAP'
FROM NHANVIEN N
	LEFT JOIN DONDATHANG D ON N.MANHANVIEN=D.MANHANVIEN
GROUP BY N.MANHANVIEN, HO, TEN


--cau 24: Moi nhan vien da dat bao nhieu don dat hang (neu chua he lap hoa don thi cho kq bang 0)
SELECT 
FROM 
WHERE 

--cau 