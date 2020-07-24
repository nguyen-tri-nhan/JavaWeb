CREATE DATABASE LibraryManagement


USE LibraryManagement;
CREATE TABLE tblUsers (
	ID nvarchar(50) NOT NULL PRIMARY KEY,
	FullName nvarchar(50),
	Password nvarchar(50),
	RoleID int)
CREATE TABLE tblRoles (
	RoleID int NOT NULL PRIMARY KEY,
	RoleName nvarchar(50))
CREATE TABLE tblOrder (
	OrderID nvarchar(50) NOT NULL PRIMARY KEY,
	OrderDate date,
	UserID nvarchar(50),
	ReturnDate date,
	IsReturned bit,
	IsRequired int)
CREATE TABLE tblBooks (
	BookID nvarchar(50) NOT NULL PRIMARY KEY,
	Title nvarchar(50),
	Price float,
	Author nvarchar(50),
	Publisher nvarchar(50),
	Language nvarchar(50),
	Genre nvarchar(50),
	Quantity int,
	IsActive bit)
CREATE TABLE OrderDetail(
	ID nvarchar(50) NOT NULL PRIMARY KEY,
	BookID nvarchar(50),
	Amount int,
	OrderID nvarchar(50))

INSERT INTO tblUsers (ID, FullName, Password, RoleID) VALUES ('admin', 'adminstaror', '1', 1);
INSERT INTO tblUsers (ID, FullName, Password, RoleID) VALUES ('SE140284', 'Nguyen Tri Nhan', '123456', 3);
INSERT INTO tblUsers (ID, FullName, Password, RoleID) VALUES ('SE111111', 'Tran Duc Bo', '111222', 3);
INSERT INTO tblUsers (ID, FullName, Password, RoleID) VALUES ('SE222222', 'Tran Dan', '1', 3); 

INSERT INTO tblRoles (RoleID, RoleName) VALUES (1, 'Admin');
INSERT INTO tblRoles (RoleID, RoleName) VALUES (3, 'Student');

INSERT INTO tblBooks (BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive) VALUES ('SWE0001','Introduction to Software Engineering',250000,'FPTU','FPTU','English','Programing',100,'1');
INSERT INTO tblBooks (BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive) VALUES ('DBI0001','Introduction to Database',200000,'FPTU','FPTU','English','Programing',100,'1');
INSERT INTO tblBooks (BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive) VALUES ('JAV0001','Introduction to Object-Oriented Programing',300000,'FPTU','FPTU','English','Programing',10,'1');
INSERT INTO tblBooks (BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive) VALUES ('JAP0001','Dekiru no Nihongo',300000,'Dekiru','JPP','Japanese','Language',10,'1');
INSERT INTO tblBooks (BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive) VALUES ('FNC0001','Introduction to Financial',300000,'FPTU','FPTU','English','Financial',10,'1');
INSERT INTO tblBooks (BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive) VALUES ('ECO0001','Introduction to Economical',300000,'FPTU','FPTU','English','Financial',10,'1');
INSERT INTO tblBooks (BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive) VALUES ('HCM001',N'Tư tưởng Hồ Chí Minh',300000,N'Bộ Giáo dục và Đào tạo',N'NXB ĐH Chính Trị','Vietnamese','Political',10,'1');
INSERT INTO tblBooks (BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive) VALUES ('MLN001',N'Chủ nghĩa Mác - Lênin',300000,N'Bộ Giáo dục và Đào tạo',N'NXB ĐH Chính Trị','Vietnamese','Political',10,'1');
INSERT INTO tblBooks (BookID, Title, Price, Author, Publisher, Language, Genre, Quantity, IsActive) VALUES ('DLD001',N'Đường lối cách mạng ĐCSVN',300000,N'Bộ Giáo dục và Đào tạo',N'NXB ĐH Chính Trị','Vietnamese','Political',10,'1');

INSERT INTO tblOrder (OrderID, UserID, OrderDate, ReturnDate,IsReturned, IsRequired) VALUES ('SU/2020/OD/0001', 'SE140284', '2020-03-08', '2020-04-07','0',0)
INSERT INTO tblOrder (OrderID, UserID, OrderDate, ReturnDate,IsReturned, IsRequired) VALUES ('SU/2020/OD/0002', 'SE111111', '2020-03-08', '2020-04-07','0',0)


INSERT INTO OrderDetail (ID, OrderID, BookID, Amount) VALUES ('SU/2020/DT/0001', 'SU/2020/OD/0001', 'SWE0001', 1)
INSERT INTO OrderDetail (ID, OrderID, BookID, Amount) VALUES ('SU/2020/DT/0002', 'SU/2020/OD/0001', 'JAV0001', 1)
INSERT INTO OrderDetail (ID, OrderID, BookID, Amount) VALUES ('SU/2020/DT/0003', 'SU/2020/OD/0001', 'HCM001', 1)
INSERT INTO OrderDetail (ID, OrderID, BookID, Amount) VALUES ('SU/2020/DT/0004', 'SU/2020/OD/0001', 'JAP0001', 1)
INSERT INTO OrderDetail (ID, OrderID, BookID, Amount) VALUES ('SU/2020/DT/0005', 'SU/2020/OD/0002', 'SWE0001', 1)
INSERT INTO OrderDetail (ID, OrderID, BookID, Amount) VALUES ('SU/2020/DT/0006', 'SU/2020/OD/0002', 'JAV0001', 1)
INSERT INTO OrderDetail (ID, OrderID, BookID, Amount) VALUES ('SU/2020/DT/0007', 'SU/2020/OD/0002', 'HCM001', 1)
INSERT INTO OrderDetail (ID, OrderID, BookID, Amount) VALUES ('SU/2020/DT/0008', 'SU/2020/OD/0002', 'JAP0001', 1)
