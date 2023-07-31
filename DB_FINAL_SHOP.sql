
CREATE DATABASE FINAL_SHOP
GO
USE FINAL_SHOP
GO

CREATE TABLE THONG_SO(
ID BIGINT PRIMARY KEY IDENTITY,
MAN_HINH NVARCHAR(250),
HE_DIEU_HANH NVARCHAR(250),
CPU NVARCHAR(200),
CAMERA NVARCHAR(200),
PIN_SAC NVARCHAR(200)
);
GO
CREATE TABLE DANH_MUC(
ID BIGINT IDENTITY PRIMARY KEY,
TEN NVARCHAR(200) NOT NULL
);
GO
CREATE TABLE THUONG_HIEU(
ID BIGINT PRIMARY KEY IDENTITY,
TEN NVARCHAR(200) NOT NULL,
URL_LOGO NVARCHAR(MAX)
);
GO
CREATE TABLE SAN_PHAM(
ID BIGINT IDENTITY PRIMARY KEY,
TEN NVARCHAR(225) NOT NULL,
THONG_SO_ID BIGINT FOREIGN KEY REFERENCES dbo.THONG_SO(ID),
DANH_MUC_ID BIGINT FOREIGN KEY REFERENCES dbo.DANH_MUC(ID),
THUONG_HIEU_ID BIGINT FOREIGN KEY REFERENCES dbo.THUONG_HIEU(ID),
GIA MONEY,
MOTA NVARCHAR(MAX)
);
GO
CREATE TABLE IMAGES(
ID BIGINT PRIMARY KEY IDENTITY,
URL_IMG NVARCHAR(MAX),
SAN_PHAM_ID BIGINT FOREIGN KEY REFERENCES dbo.SAN_PHAM(ID)
)
GO
CREATE TABLE MAU_SAC(
ID BIGINT IDENTITY PRIMARY KEY,
TEN NVARCHAR(50) NOT NULL
);
GO
CREATE TABLE RAM(
ID BIGINT PRIMARY KEY IDENTITY,
TEN VARCHAR(50),
LOAIRAM NVARCHAR(50),
DUNGLUONG VARCHAR(50)
);
GO
CREATE TABLE ROM(
ID BIGINT PRIMARY KEY IDENTITY,
TEN VARCHAR(50),
LOAIROM NVARCHAR(50),
DUNGLUONG VARCHAR(50)
)
GO
CREATE TABLE SAN_PHAM_CT(
ID BIGINT IDENTITY PRIMARY KEY,
SAN_PHAM_ID BIGINT FOREIGN KEY REFERENCES dbo.SAN_PHAM(ID),
MAU_SAC_ID BIGINT FOREIGN KEY REFERENCES dbo.MAU_SAC(ID),
RAM_ID BIGINT FOREIGN KEY REFERENCES dbo.RAM(ID),
ROM_ID BIGINT FOREIGN KEY REFERENCES dbo.ROM(ID),
GIA MONEY,
SO_LUONG INT,
BAO_HANH NVARCHAR(255),
TRANG_THAI BIT
);
GO
CREATE TABLE NGUOI_DUNG(
ID BIGINT IDENTITY PRIMARY KEY,
TEN NVARCHAR(255),
url_avt NVARCHAR(MAX),
GIOI_TINH BIT,
SDT VARCHAR(12) UNIQUE NULL,
GMAIL VARCHAR(250) UNIQUE NULL,
USERNAME VARCHAR(200) UNIQUE,
PASSWORD VARCHAR(250),
);
GO
CREATE TABLE DIA_CHI(
ID BIGINT PRIMARY KEY IDENTITY,
NGUOI_DUNG_ID BIGINT FOREIGN KEY REFERENCES dbo.NGUOI_DUNG (ID),
TINH NVARCHAR(50),
QUAN_HUYEN NVARCHAR(50),
PHUONG_XA NVARCHAR(50),
SO_NHA_DUONG NVARCHAR(255)
);
GO
CREATE TABLE GIO_HANG(
ID BIGINT PRIMARY KEY IDENTITY,
NGUOI_DUNG_ID BIGINT FOREIGN KEY REFERENCES dbo.NGUOI_DUNG(ID),
NGAY_TAO DATE
);
GO
CREATE TABLE GIO_HANG_CT(
GIO_HANG_ID BIGINT FOREIGN KEY REFERENCES dbo.GIO_HANG(ID),
SAN_PHAM_ID BIGINT FOREIGN KEY REFERENCES dbo.SAN_PHAM_CT(ID),
SO_LUONG INT,
DON_GIA MONEY,
PRIMARY KEY(GIO_HANG_ID,SAN_PHAM_ID)
)
GO
CREATE TABLE HOA_DON(
ID BIGINT IDENTITY PRIMARY KEY,
NGUOI_DUNG_ID BIGINT FOREIGN KEY REFERENCES dbo.NGUOI_DUNG(ID),
NGAY_TAO DATE,
TRANG_THAI NVARCHAR(50)
)
GO
CREATE TABLE HOA_DON_CT(
HOA_DON_ID BIGINT FOREIGN KEY REFERENCES dbo.HOA_DON(ID),
SAN_PHAM_ID BIGINT FOREIGN KEY REFERENCES dbo.SAN_PHAM_CT(ID),
SO_LUONG INT,
DON_GIA MONEY,
PRIMARY KEY(HOA_DON_ID,SAN_PHAM_ID)
)
GO
create table ROLES (
id BIGINT PRIMARY KEY,
ten VARCHAR(50),
)
GO
CREATE TABLE USER_ROLE(
ID BIGINT PRIMARY KEY,
ID_USER BIGINT,
ID_ROLE BIGINT,
FOREIGN KEY (ID_USER) REFERENCES dbo.NGUOI_DUNG (ID),
FOREIGN KEY (ID_ROLE) REFERENCES dbo.ROLES (id)
)
GO
CREATE TRIGGER updateSP ON dbo.SAN_PHAM_CT
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    -- Thực hiện các hành động trong Trigger
    UPDATE dbo.SAN_PHAM_CT
    SET TRANG_THAI = CASE
        WHEN Inserted.SO_LUONG = 0 THEN 0
        WHEN Inserted.SO_LUONG > 0 THEN 1
        ELSE Inserted.TRANG_THAI -- Giữ nguyên trạng thái nếu số lượng không thỏa mãn điều kiện
    END
    FROM dbo.SAN_PHAM_CT
    INNER JOIN inserted ON dbo.SAN_PHAM_CT.ID = inserted.ID;
END;
go


