use master
go

create database QuanLyBanHang_KTCK_Java
go

use QuanLyBanHang_KTCK_Java
go

--drop database QuanLyBanHang_KTCK_Java
--drop table Products


--1. Tạo bảng Users

create table Users (
	id								varchar(5) primary key,
	username					varchar(20),
	password					varchar(15),
	email						varchar(100),
	fullName					nvarchar(255),
	address						nvarchar(255),
	phoneNumber			varchar(15),
	status						bit
)

insert into Users
	values	('AD001', 'phu', '123123', 'phu@gmail.com', N'Phú Nguyễn', N'Đà Nẵng', '0912378714', 1),
				('AD002', 'nhan', '123123', 'nhan@gmail.com', N'Nhân Phạm', N'Cần Thơ', '0912375244', 1),
				('AD003', 'thuy', '123123', 'thuy@gmail.com', N'Thủy Lê', N'Hải Phòng', '0963778714', 1),
				('AD004', 'long', '123123', 'long@gmail.com', N'Long Hoàng', N'Đà Nẵng', '0912378714', 1)

Select * from Users

Select * from Users where email='phu@gmail.com' and password ='123123'

--2. Tạo bảng Categories
create table Categories (
	id				varchar(5) primary key,
	name		nvarchar(255),
	status		bit
)

insert into Categories (id, name)
	values	('CG001', 'Nam'),
				('CG002', 'Nu'),
				('CG003', 'Unisex')

--3. Tạo bảng Products
create table Products (
	id						varchar(5) primary key,
	name				nvarchar(255),
	price					int,
	description		nvarchar(255),
	image				varchar(255),
	categoriesId		varchar(5) foreign key references Categories(id),
	status				bit
)

insert into Products (id, name, price, description, image, categoriesId)
	values	('PD001', 'Áo hoodie', '640000',  'Đồ unisex dành cho nam vẫn giữ nguyên bản chất nam tính, và đồ unisex dành cho nữ vẫn thể hiện được nét đẹp', 'https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-lf6ve48li5ca1e', 'CG003'),
				('PD002', 'Quần jogger', '430000', 'Với set đồ này thì các bạn có thể sử dụng giày thể thao màu trắng, đen', 'https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-lgjfj6dyfotmdf', 'CG003')

Select * from Products

--4. Tạo bảng Orders
create table Orders(
	id						varchar(5) primary key,
	usersId				varchar(5) foreign key references Users(id),
	address				nvarchar(255),
	orderDate			datetime default(getdate()),
	totalAmount	int
)

insert into Orders
	values	('OR001', 'AD001', N'Đà Nẵng'),
				('OR002', 'AD003', N'Hải Phòng'),
				('OR003', 'AD004', N'Đà Nẵng')

--5. Tạo bảng OrderDetails
create table OrderDetails (
	id							varchar(5) primary key,
	odersId					varchar(5) foreign key references Orders(id),
	productsId			varchar(5) foreign key references Products(id),
	quantity				int,
	unitPrice				int
)

insert into OrderDetails
	values	('OD001', 'OR001', 'PD001'),
				('OD002', 'OR003', 'PD003'),
				('OD003', 'OR003', 'PD002')