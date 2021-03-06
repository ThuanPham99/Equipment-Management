USE [master]
GO
/****** Object:  Database [ProjectWeb]    Script Date: 3/22/2020 7:32:51 PM ******/
CREATE DATABASE [ProjectWeb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ProjectWeb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\ProjectWeb.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ProjectWeb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\ProjectWeb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ProjectWeb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProjectWeb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProjectWeb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProjectWeb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProjectWeb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProjectWeb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProjectWeb] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProjectWeb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProjectWeb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProjectWeb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProjectWeb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProjectWeb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProjectWeb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProjectWeb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProjectWeb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProjectWeb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProjectWeb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProjectWeb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProjectWeb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProjectWeb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProjectWeb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProjectWeb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProjectWeb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProjectWeb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProjectWeb] SET RECOVERY FULL 
GO
ALTER DATABASE [ProjectWeb] SET  MULTI_USER 
GO
ALTER DATABASE [ProjectWeb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProjectWeb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProjectWeb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProjectWeb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [ProjectWeb] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'ProjectWeb', N'ON'
GO
USE [ProjectWeb]
GO
/****** Object:  Table [dbo].[Devices]    Script Date: 3/22/2020 7:32:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Devices](
	[ID] [nchar](10) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](max) NULL,
	[Type] [nvarchar](50) NULL,
	[Room] [nchar](10) NULL,
	[Image] [nvarchar](50) NULL,
	[DateOfBuy] [date] NULL,
	[Guarantee] [date] NULL,
	[NumberRepairs] [int] NULL,
	[IsDelete] [bit] NULL,
	[Status] [nvarchar](10) NULL,
 CONSTRAINT [PK_Devices] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LocationHistory]    Script Date: 3/22/2020 7:32:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LocationHistory](
	[DevicesID] [nchar](10) NOT NULL,
	[Room] [nchar](10) NOT NULL,
	[Time] [date] NOT NULL,
	[UserIDChange] [nchar](10) NULL,
	[Reason] [nvarchar](max) NULL,
 CONSTRAINT [PK_LocateHistory] PRIMARY KEY CLUSTERED 
(
	[DevicesID] ASC,
	[Room] ASC,
	[Time] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Notification]    Script Date: 3/22/2020 7:32:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notification](
	[Sender] [nchar](10) NOT NULL,
	[NotiTime] [datetime] NOT NULL,
	[DeviceID] [nchar](10) NULL,
	[Receiver] [nchar](10) NULL,
	[Type] [nvarchar](50) NOT NULL,
	[MailContext] [nvarchar](max) NULL,
 CONSTRAINT [PK_Notification] PRIMARY KEY CLUSTERED 
(
	[Sender] ASC,
	[NotiTime] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RDeviceHistory]    Script Date: 3/22/2020 7:32:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RDeviceHistory](
	[DeviceID] [nchar](10) NOT NULL,
	[TimeRequest] [datetime] NOT NULL,
	[Description] [nvarchar](max) NULL,
	[Sender] [nchar](10) NULL,
	[Repairer] [nchar](10) NULL,
	[TimeDone] [datetime] NULL,
	[Result] [bit] NULL,
 CONSTRAINT [PK_DeviceHistory] PRIMARY KEY CLUSTERED 
(
	[DeviceID] ASC,
	[TimeRequest] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role]    Script Date: 3/22/2020 7:32:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[RoleID] [nvarchar](50) NOT NULL,
	[Name] [nvarchar](50) NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Rooms]    Script Date: 3/22/2020 7:32:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rooms](
	[NumberRoom] [nchar](10) NOT NULL,
	[NameRoom] [nvarchar](50) NULL,
	[IsDelete] [bit] NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[NumberRoom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TypeMail]    Script Date: 3/22/2020 7:32:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TypeMail](
	[TypeName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_TypeMail] PRIMARY KEY CLUSTERED 
(
	[TypeName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TypeStatus]    Script Date: 3/22/2020 7:32:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TypeStatus](
	[StatusNumber] [nvarchar](10) NOT NULL,
	[StatusName] [nvarchar](50) NULL,
 CONSTRAINT [PK_TypeStatus] PRIMARY KEY CLUSTERED 
(
	[StatusNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Users]    Script Date: 3/22/2020 7:32:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserID] [nchar](10) NOT NULL,
	[UserName] [nvarchar](50) NULL,
	[Password] [nvarchar](30) NULL,
	[Room] [nchar](10) NULL,
	[Role] [nvarchar](50) NULL,
	[IsWork] [bit] NULL,
	[Image] [nvarchar](50) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'1         ', N'Tu lanh', N'Tu lanh to', N'Tu lanh', N'101       ', N'img/1.png', CAST(N'2020-12-01' AS Date), CAST(N'2021-12-01' AS Date), 3, 0, N'02')
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'2         ', N'TV SONY2', N'TV nho', N'TV', N'101       ', N'img/1.png', CAST(N'2000-12-15' AS Date), CAST(N'2020-03-10' AS Date), 2, 0, N'01')
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'3B        ', N'May In', N'mau den', N'ABC', N'101       ', N'img/1.png', CAST(N'2001-01-05' AS Date), CAST(N'2005-05-01' AS Date), 0, 0, N'02        ')
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'5         ', N'5', N'5', N'5', N'102       ', N'5', CAST(N'2020-03-03' AS Date), CAST(N'2020-03-13' AS Date), 0, 0, N'01        ')
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'6         ', N'1', N'6', N'1', N'101       ', N'1', CAST(N'2020-02-24' AS Date), CAST(N'2020-03-20' AS Date), 0, 0, N'02')
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'7         ', N'The shy', N'best top', N'1', N'101       ', N'1', CAST(N'2020-02-23' AS Date), CAST(N'2020-02-28' AS Date), 0, 0, N'01        ')
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'8         ', N'8', N'8', N'8', N'103       ', N'8', CAST(N'2020-02-24' AS Date), CAST(N'2020-02-28' AS Date), 0, 0, N'03        ')
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'a         ', N'a', N'a', N'a', N'101       ', N'a', CAST(N'2020-02-25' AS Date), CAST(N'2020-05-08' AS Date), 1, 0, N'01')
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'b         ', N'b', N'b', N'b', N'101       ', N'b', CAST(N'2020-02-26' AS Date), CAST(N'2020-02-26' AS Date), 0, 0, N'01        ')
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'c         ', N'b', N'b', N'b', N'101       ', N'b', CAST(N'2020-02-26' AS Date), CAST(N'2020-02-26' AS Date), 0, 0, N'01        ')
INSERT [dbo].[Devices] ([ID], [Name], [Description], [Type], [Room], [Image], [DateOfBuy], [Guarantee], [NumberRepairs], [IsDelete], [Status]) VALUES (N'TEST      ', N'may test ', N'test moi thu ', N'1', N'101       ', N'1', CAST(N'2020-03-13' AS Date), CAST(N'2020-07-24' AS Date), 0, 0, N'01        ')
INSERT [dbo].[LocationHistory] ([DevicesID], [Room], [Time], [UserIDChange], [Reason]) VALUES (N'1         ', N'102       ', CAST(N'2020-03-11' AS Date), N'AD001     ', N'thich     ')
INSERT [dbo].[LocationHistory] ([DevicesID], [Room], [Time], [UserIDChange], [Reason]) VALUES (N'1         ', N'103       ', CAST(N'2020-03-11' AS Date), N'AD001     ', N'1         ')
INSERT [dbo].[LocationHistory] ([DevicesID], [Room], [Time], [UserIDChange], [Reason]) VALUES (N'2         ', N'101       ', CAST(N'2007-12-01' AS Date), N'AD001     ', N'thich     ')
INSERT [dbo].[LocationHistory] ([DevicesID], [Room], [Time], [UserIDChange], [Reason]) VALUES (N'2         ', N'102       ', CAST(N'2020-01-22' AS Date), N'AD001     ', N'no reason ')
INSERT [dbo].[LocationHistory] ([DevicesID], [Room], [Time], [UserIDChange], [Reason]) VALUES (N'2         ', N'103       ', CAST(N'2020-03-11' AS Date), N'AD001     ', N'no reason ')
INSERT [dbo].[LocationHistory] ([DevicesID], [Room], [Time], [UserIDChange], [Reason]) VALUES (N'3B        ', N'101       ', CAST(N'2020-03-14' AS Date), N'RP001     ', N'test RP001')
INSERT [dbo].[LocationHistory] ([DevicesID], [Room], [Time], [UserIDChange], [Reason]) VALUES (N'5         ', N'102       ', CAST(N'2020-03-14' AS Date), N'RP001     ', N'test 102')
INSERT [dbo].[LocationHistory] ([DevicesID], [Room], [Time], [UserIDChange], [Reason]) VALUES (N'5         ', N'103       ', CAST(N'2020-03-11' AS Date), N'AD001     ', N'thich     ')
INSERT [dbo].[LocationHistory] ([DevicesID], [Room], [Time], [UserIDChange], [Reason]) VALUES (N'c         ', N'101       ', CAST(N'2020-03-11' AS Date), N'AD001     ', N'buy a new device')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'AD001     ', CAST(N'1970-01-01 00:00:01.000' AS DateTime), N'1         ', N'US002     ', N'Confirm', N'THU ROI')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'AD001     ', CAST(N'2020-03-14 09:29:11.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'Admin AD001 changed your information ')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'AD002     ', CAST(N'2020-01-01 00:00:01.000' AS DateTime), N'1         ', N'US002     ', N'Confirm', N't2')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'RP001     ', CAST(N'2020-03-12 08:06:48.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'Repaer RP001 have confirmed your request ( repair  Device :2 )')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'RP001     ', CAST(N'2020-03-13 10:51:01.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'Device 2          successful repair')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'RP001     ', CAST(N'2020-03-13 11:00:46.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'Repaer RP001 have confirmed your request ( repair  Device :2 )')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'RP001     ', CAST(N'2020-03-14 07:22:42.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'Device 2          successful repair')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'RP001     ', CAST(N'2020-03-14 07:37:08.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'Repaer RP001 have confirmed your request ( repair  Device :1 )')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'RP001     ', CAST(N'2020-03-14 07:37:18.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'Device 1          successful repair')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'RP001     ', CAST(N'2020-03-14 08:27:27.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'Device 1          repair failed')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'RP001     ', CAST(N'2020-03-22 07:26:38.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'Repaer RP001 have confirmed your request ( repair  Device :a )')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'RP001     ', CAST(N'2020-03-22 07:26:59.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'Device a          successful repair')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'RP001     ', CAST(N'2020-05-12 08:58:40.000' AS DateTime), NULL, N'US002     ', N'Confirm', N'2')
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'US002     ', CAST(N'2020-03-11 11:40:16.000' AS DateTime), N'1         ', N'RP001     ', N'Finish', NULL)
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'US002     ', CAST(N'2020-03-12 08:10:26.000' AS DateTime), N'6         ', NULL, N'Request', NULL)
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'US002     ', CAST(N'2020-03-12 08:58:40.000' AS DateTime), N'2         ', N'RP001     ', N'Finish', NULL)
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'US002     ', CAST(N'2020-03-13 10:52:21.000' AS DateTime), N'2         ', N'RP001     ', N'Finish', NULL)
INSERT [dbo].[Notification] ([Sender], [NotiTime], [DeviceID], [Receiver], [Type], [MailContext]) VALUES (N'US002     ', CAST(N'2020-03-22 07:22:30.000' AS DateTime), N'a         ', N'RP001     ', N'Finish', NULL)
INSERT [dbo].[RDeviceHistory] ([DeviceID], [TimeRequest], [Description], [Sender], [Repairer], [TimeDone], [Result]) VALUES (N'1         ', CAST(N'1970-01-01 00:00:00.000' AS DateTime), N'test001', N'US002     ', N'RP001     ', CAST(N'2020-01-01 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[RDeviceHistory] ([DeviceID], [TimeRequest], [Description], [Sender], [Repairer], [TimeDone], [Result]) VALUES (N'1         ', CAST(N'2020-03-11 00:00:00.000' AS DateTime), N'oke la', N'US002     ', N'RP001     ', CAST(N'2020-03-14 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[RDeviceHistory] ([DeviceID], [TimeRequest], [Description], [Sender], [Repairer], [TimeDone], [Result]) VALUES (N'1         ', CAST(N'2020-03-11 11:40:16.000' AS DateTime), N'lan 3 that bai', N'US002     ', N'RP001     ', CAST(N'2020-03-14 08:27:27.000' AS DateTime), 0)
INSERT [dbo].[RDeviceHistory] ([DeviceID], [TimeRequest], [Description], [Sender], [Repairer], [TimeDone], [Result]) VALUES (N'2         ', CAST(N'2020-03-12 00:00:00.000' AS DateTime), N'no bi ngao da ', N'US002     ', N'RP001     ', CAST(N'2020-03-13 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[RDeviceHistory] ([DeviceID], [TimeRequest], [Description], [Sender], [Repairer], [TimeDone], [Result]) VALUES (N'2         ', CAST(N'2020-03-13 00:00:00.000' AS DateTime), N'oke', N'US002     ', N'RP001     ', CAST(N'2020-03-14 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[RDeviceHistory] ([DeviceID], [TimeRequest], [Description], [Sender], [Repairer], [TimeDone], [Result]) VALUES (N'a         ', CAST(N'2020-03-22 07:22:30.000' AS DateTime), N'hu chu A', N'US002     ', N'RP001     ', CAST(N'2020-03-22 07:26:59.000' AS DateTime), 1)
INSERT [dbo].[Role] ([RoleID], [Name]) VALUES (N'admin     ', N'Nguoi Quan Ly')
INSERT [dbo].[Role] ([RoleID], [Name]) VALUES (N'repairer  ', N'Tho sua chua')
INSERT [dbo].[Role] ([RoleID], [Name]) VALUES (N'user      ', N'Nhan vien')
INSERT [dbo].[Rooms] ([NumberRoom], [NameRoom], [IsDelete]) VALUES (N'101       ', N'Y Te', 0)
INSERT [dbo].[Rooms] ([NumberRoom], [NameRoom], [IsDelete]) VALUES (N'102       ', N'Quan lY', 0)
INSERT [dbo].[Rooms] ([NumberRoom], [NameRoom], [IsDelete]) VALUES (N'103       ', N'Ke Toan', 0)
INSERT [dbo].[Rooms] ([NumberRoom], [NameRoom], [IsDelete]) VALUES (N'104       ', N'Sua Chua', 1)
INSERT [dbo].[Rooms] ([NumberRoom], [NameRoom], [IsDelete]) VALUES (N'201       ', N'hoc', 1)
INSERT [dbo].[Rooms] ([NumberRoom], [NameRoom], [IsDelete]) VALUES (N'203       ', N'thuan2', 0)
INSERT [dbo].[TypeMail] ([TypeName]) VALUES (N'Confirm')
INSERT [dbo].[TypeMail] ([TypeName]) VALUES (N'Finish')
INSERT [dbo].[TypeMail] ([TypeName]) VALUES (N'Processing')
INSERT [dbo].[TypeMail] ([TypeName]) VALUES (N'Request')
INSERT [dbo].[TypeStatus] ([StatusNumber], [StatusName]) VALUES (N'01', N'Normal')
INSERT [dbo].[TypeStatus] ([StatusNumber], [StatusName]) VALUES (N'02', N'Damaged')
INSERT [dbo].[TypeStatus] ([StatusNumber], [StatusName]) VALUES (N'03', N'Repairing')
INSERT [dbo].[Users] ([UserID], [UserName], [Password], [Room], [Role], [IsWork], [Image]) VALUES (N'AD001     ', N'Thuan', N'a', N'102       ', N'admin', 1, NULL)
INSERT [dbo].[Users] ([UserID], [UserName], [Password], [Room], [Role], [IsWork], [Image]) VALUES (N'AD002     ', N'Hieu', N'a', N'103       ', N'admin', 0, N'1')
INSERT [dbo].[Users] ([UserID], [UserName], [Password], [Room], [Role], [IsWork], [Image]) VALUES (N'RP001     ', N'The shy', N'a', N'101       ', N'repairer', 1, N'1')
INSERT [dbo].[Users] ([UserID], [UserName], [Password], [Room], [Role], [IsWork], [Image]) VALUES (N'RP002     ', N'test', N'a', N'101       ', N'repairer', 1, N'ssada')
INSERT [dbo].[Users] ([UserID], [UserName], [Password], [Room], [Role], [IsWork], [Image]) VALUES (N'US002     ', N'DO Mixi', N'a', N'101       ', N'user', 1, N'img/201')
INSERT [dbo].[Users] ([UserID], [UserName], [Password], [Room], [Role], [IsWork], [Image]) VALUES (N'US003     ', N'To khach nhi', N'a', N'103       ', N'user', 1, N'img/ui-danro.png')
ALTER TABLE [dbo].[Devices]  WITH CHECK ADD  CONSTRAINT [FK_Devices_Room] FOREIGN KEY([Room])
REFERENCES [dbo].[Rooms] ([NumberRoom])
GO
ALTER TABLE [dbo].[Devices] CHECK CONSTRAINT [FK_Devices_Room]
GO
ALTER TABLE [dbo].[Devices]  WITH CHECK ADD  CONSTRAINT [FK_Devices_TypeStatus] FOREIGN KEY([Status])
REFERENCES [dbo].[TypeStatus] ([StatusNumber])
GO
ALTER TABLE [dbo].[Devices] CHECK CONSTRAINT [FK_Devices_TypeStatus]
GO
ALTER TABLE [dbo].[LocationHistory]  WITH CHECK ADD  CONSTRAINT [FK_LocateHistory_Devices] FOREIGN KEY([DevicesID])
REFERENCES [dbo].[Devices] ([ID])
GO
ALTER TABLE [dbo].[LocationHistory] CHECK CONSTRAINT [FK_LocateHistory_Devices]
GO
ALTER TABLE [dbo].[LocationHistory]  WITH CHECK ADD  CONSTRAINT [FK_LocateHistory_Room] FOREIGN KEY([Room])
REFERENCES [dbo].[Rooms] ([NumberRoom])
GO
ALTER TABLE [dbo].[LocationHistory] CHECK CONSTRAINT [FK_LocateHistory_Room]
GO
ALTER TABLE [dbo].[LocationHistory]  WITH CHECK ADD  CONSTRAINT [FK_LocationHistory_Users] FOREIGN KEY([UserIDChange])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[LocationHistory] CHECK CONSTRAINT [FK_LocationHistory_Users]
GO
ALTER TABLE [dbo].[Notification]  WITH CHECK ADD  CONSTRAINT [FK_Notification_Devices] FOREIGN KEY([DeviceID])
REFERENCES [dbo].[Devices] ([ID])
GO
ALTER TABLE [dbo].[Notification] CHECK CONSTRAINT [FK_Notification_Devices]
GO
ALTER TABLE [dbo].[Notification]  WITH CHECK ADD  CONSTRAINT [FK_Notification_TypeMail] FOREIGN KEY([Type])
REFERENCES [dbo].[TypeMail] ([TypeName])
GO
ALTER TABLE [dbo].[Notification] CHECK CONSTRAINT [FK_Notification_TypeMail]
GO
ALTER TABLE [dbo].[Notification]  WITH CHECK ADD  CONSTRAINT [FK_Notification_Users] FOREIGN KEY([Sender])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Notification] CHECK CONSTRAINT [FK_Notification_Users]
GO
ALTER TABLE [dbo].[Notification]  WITH CHECK ADD  CONSTRAINT [FK_Notification_Users1] FOREIGN KEY([Receiver])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Notification] CHECK CONSTRAINT [FK_Notification_Users1]
GO
ALTER TABLE [dbo].[RDeviceHistory]  WITH CHECK ADD  CONSTRAINT [FK_DeviceHistory_Devices] FOREIGN KEY([DeviceID])
REFERENCES [dbo].[Devices] ([ID])
GO
ALTER TABLE [dbo].[RDeviceHistory] CHECK CONSTRAINT [FK_DeviceHistory_Devices]
GO
ALTER TABLE [dbo].[RDeviceHistory]  WITH CHECK ADD  CONSTRAINT [FK_RDeviceHistory_Users] FOREIGN KEY([Sender])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[RDeviceHistory] CHECK CONSTRAINT [FK_RDeviceHistory_Users]
GO
ALTER TABLE [dbo].[RDeviceHistory]  WITH CHECK ADD  CONSTRAINT [FK_RDeviceHistory_Users1] FOREIGN KEY([Repairer])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[RDeviceHistory] CHECK CONSTRAINT [FK_RDeviceHistory_Users1]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Role] FOREIGN KEY([Role])
REFERENCES [dbo].[Role] ([RoleID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Role]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Room] FOREIGN KEY([Room])
REFERENCES [dbo].[Rooms] ([NumberRoom])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Room]
GO
USE [master]
GO
ALTER DATABASE [ProjectWeb] SET  READ_WRITE 
GO
