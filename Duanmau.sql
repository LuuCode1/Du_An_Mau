create database Du_An_Mau
go
use Du_An_Mau
go
drop database Du_An_Mau
go
create table Nhan_Vien
(
Ma_Nhan_Vien varchar(10) not null primary key,
Mat_Khau varchar(30) not null,
Ho_Ten nvarchar(50) not null,
Vai_Tro bit not null,
);
create table Chuyen_De
(
Ma_Chuyen_De varchar(10) not null primary key,
Ten_Chuyen_De nvarchar(50) not null,
Hoc_Phi float not null default 0,
Thoi_Luong int not null default 0,
Hinh varchar(10),
Mo_Ta nvarchar(100),
check(Hoc_Phi>=0 and Thoi_Luong>0)
);
create table Khoa_Hoc
(
Ma_Khoa_Hoc varchar(10) not null primary key,
Ma_Chuyen_De varchar(10) not null,
Hoc_Phi float not null,
Thoi_Luong int not null,
Ngay_Khai_Giang date not null,
Ghi_Chu nvarchar(100),
Ma_Nhan_Vien varchar(10) not null,
Ngay_Tao date not null default getdate(),
check(Hoc_Phi>=0 and Thoi_Luong>0),
foreign key (Ma_Nhan_Vien) references Nhan_Vien(Ma_Nhan_Vien) on update cascade,
foreign key (Ma_Chuyen_De) references Chuyen_De(Ma_Chuyen_De) on update cascade
);
create table Nguoi_Hoc
(
Ma_Nguoi_Hoc varchar(10) not null primary key,
Ho_Ten nvarchar(50) not null,
Gioi_Tinh bit not null,
Ngay_Sinh date not null,
Email nvarchar(30) not null,
Dien_Thoai varchar(10) not null,
Ghi_Chu nvarchar(100),
Ma_Nhan_Vien varchar(10) not null,
Ngay_Dang_Ky date not null default getdate(),
foreign key (Ma_Nhan_Vien) references Nhan_Vien(Ma_Nhan_Vien) on update cascade
);
create table Hoc_Vien
(
Ma_Hoc_Vien varchar(10) not null primary key,
Ma_Nguoi_Hoc varchar(10) not null,
Ma_Khoa_Hoc varchar(10) not null,
Diem float not null,
check(Diem >=0),
foreign key (Ma_Nguoi_Hoc) references Nguoi_Hoc(Ma_Nguoi_Hoc) ,
foreign key (Ma_Khoa_Hoc) references Khoa_Hoc(Ma_Khoa_Hoc)
);
INSERT INTO Nhan_Vien (Ma_Nhan_Vien, Mat_Khau, Ho_Ten, Vai_Tro)
VALUES
('nv01', '123', N'Nguyễn Văn A', 1),
('nv02', '456', N'Trần Thị B', 0),
('nv03', '789', N'Lê Văn C', 1);

INSERT INTO Chuyen_De (Ma_Chuyen_De, Ten_Chuyen_De, Hoc_Phi, Thoi_Luong)
VALUES
('cd01', N'Lập trình C#', 300, 90),
('cd02', N'Lập trình Java', 250, 60),
('cd03', N'Thiết kế Database', 200, 50);

INSERT INTO Khoa_Hoc (Ma_Khoa_Hoc, Ma_Chuyen_De, Hoc_Phi, Thoi_Luong, Ngay_Khai_Giang, Ghi_Chu, Ma_Nhan_Vien)
VALUES

('kh01', 'cd01', 300, 90, '2023-03-01', N'Khai giảng lớp C#', 'nv01'),
('kh02', 'cd02', 250, 60, '2023-03-10', N'Khai giảng lớp Java', 'nv02'),
('kh03', 'cd03', 200, 50, '2023-04-01', N'Khai giảng lớp SQL Server', 'nv03');

INSERT INTO Nguoi_Hoc (Ma_Nguoi_Hoc, Ho_Ten, Gioi_Tinh, Ngay_Sinh, Email, Dien_Thoai, Ma_Nhan_Vien)
VALUES
('nh01', N'Nguyễn Văn A',1, '2000-01-01', 'anga@gmail.com', '0123123123', 'nv01'),
('nh02', N'Trần Thị B', 0, '2001-02-02', 'btra@gmail.com', '0246246246', 'nv02'),
('nh03', N'Lê Thu C', 0, '2002-03-03', 'clethu@gmail.com', '0345634563', 'nv03');

INSERT INTO Hoc_Vien (Ma_Hoc_Vien, Ma_Nguoi_Hoc, Ma_Khoa_Hoc, Diem)

VALUES
('hv01', 'nh01', 'kh01', 8),
('hv02', 'nh02', 'kh02', 7),
('hv03', 'nh03', 'kh03', 9);
select * from Nhan_Vien
select * from Chuyen_De
select * from Khoa_Hoc
select * from Nguoi_Hoc
select * from Hoc_Vien
SELECT  Ma_Chuyen_De, Ten_Chuyen_De, Hoc_Phi, Thoi_Luong, Hinh, Mo_Ta FROM Chuyen_De
SELECT    Ma_Nhan_Vien, Mat_Khau, Ho_Ten, Vai_Tro FROM Nhan_Vien
SELECT * from Nhan_Vien where Ma_Nhan_Vien =? and Mat_Khau =?
SELECT    Ma_Nhan_Vien, Mat_Khau, Ho_Ten, Vai_Tro FROM Nhan_Vien WHERE Ma_Nhan_Vien = ?
SELECT    Nguoi_Hoc.Ma_Nguoi_Hoc, Nguoi_Hoc.Ho_Ten, Nguoi_Hoc.Gioi_Tinh, Nguoi_Hoc.Ngay_Sinh, Nguoi_Hoc.Email, Nguoi_Hoc.Dien_Thoai, Nguoi_Hoc.Ghi_Chu, Nhan_Vien.Ma_Nhan_Vien, 
                      Nguoi_Hoc.Ngay_Dang_Ky
FROM         Nhan_Vien INNER JOIN
                      Nguoi_Hoc ON Nhan_Vien.Ma_Nhan_Vien = Nguoi_Hoc.Ma_Nhan_Vien
DELETE FROM Nguoi_Hoc;
ALTER TABLE Chuyen_De
DROP COLUMN Hinh;
ALTER TABLE Chuyen_De
ADD Hinh VARCHAR(MAX);