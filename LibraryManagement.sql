USE [master]
GO
/****** Object:  Database [LibraryManagement]    Script Date: 6/22/2021 2:57:46 PM ******/
CREATE DATABASE [LibraryManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'LibraryManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.DUONGDT\MSSQL\DATA\LibraryManagement.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'LibraryManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.DUONGDT\MSSQL\DATA\LibraryManagement_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [LibraryManagement] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [LibraryManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [LibraryManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [LibraryManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [LibraryManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [LibraryManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [LibraryManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [LibraryManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [LibraryManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [LibraryManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [LibraryManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [LibraryManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [LibraryManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [LibraryManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [LibraryManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [LibraryManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [LibraryManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [LibraryManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [LibraryManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [LibraryManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [LibraryManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [LibraryManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [LibraryManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [LibraryManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [LibraryManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [LibraryManagement] SET  MULTI_USER 
GO
ALTER DATABASE [LibraryManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [LibraryManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [LibraryManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [LibraryManagement] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [LibraryManagement] SET DELAYED_DURABILITY = DISABLED 
GO
USE [LibraryManagement]
GO
/****** Object:  Table [dbo].[Book]    Script Date: 6/22/2021 2:57:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[bookID] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[author] [nvarchar](50) NOT NULL,
	[genre] [nvarchar](50) NOT NULL,
	[totalQuantity] [int] NOT NULL,
	[borrowedQuantity] [int] NOT NULL,
	[remainingAmount] [int] NOT NULL,
	[information] [nvarchar](50) NULL,
 CONSTRAINT [PK_Book] PRIMARY KEY CLUSTERED 
(
	[bookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [sach_duynhat] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Borrow]    Script Date: 6/22/2021 2:57:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Borrow](
	[borrowID] [int] IDENTITY(1,1) NOT NULL,
	[borrowDate] [varchar](10) NOT NULL,
	[borrowerID] [int] NOT NULL,
	[isReturned] [bit] NOT NULL,
	[librarianID] [int] NULL,
	[returnDate] [varchar](10) NULL,
	[bookID] [int] NOT NULL,
 CONSTRAINT [PK_Borrow] PRIMARY KEY CLUSTERED 
(
	[borrowID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[UserList]    Script Date: 6/22/2021 2:57:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[UserList](
	[userID] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[dOB] [nvarchar](10) NULL,
	[address] [nvarchar](50) NULL,
	[userName] [varchar](50) NOT NULL,
	[passWord] [nvarchar](50) NULL,
	[role] [bit] NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [checkusername] UNIQUE NONCLUSTERED 
(
	[userName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Borrow]  WITH CHECK ADD  CONSTRAINT [FK_Borrow_Book] FOREIGN KEY([bookID])
REFERENCES [dbo].[Book] ([bookID])
GO
ALTER TABLE [dbo].[Borrow] CHECK CONSTRAINT [FK_Borrow_Book]
GO
ALTER TABLE [dbo].[Borrow]  WITH CHECK ADD  CONSTRAINT [FK_Borrow_User] FOREIGN KEY([borrowerID])
REFERENCES [dbo].[UserList] ([userID])
GO
ALTER TABLE [dbo].[Borrow] CHECK CONSTRAINT [FK_Borrow_User]
GO
ALTER TABLE [dbo].[Borrow]  WITH CHECK ADD  CONSTRAINT [FK_Borrow_User1] FOREIGN KEY([librarianID])
REFERENCES [dbo].[UserList] ([userID])
GO
ALTER TABLE [dbo].[Borrow] CHECK CONSTRAINT [FK_Borrow_User1]
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [checkrma] CHECK  (([remainingAmount]>=(0)))
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [checkrma]
GO
/****** Object:  StoredProcedure [dbo].[getAuthorByName]    Script Date: 6/22/2021 2:57:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[getAuthorByName]
	@name nvarchar(50)
as
BEGIN
	Select * from Author where name like N'%@name%';
END
GO
/****** Object:  StoredProcedure [dbo].[insertAuthor]    Script Date: 6/22/2021 2:57:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[insertAuthor]
	@name nvarchar(50),
	@nationality nvarchar(50),
	@information nvarchar(50),
	@return bit OUTPUT
as
BEGIN
	BEGIN TRY
		Insert into Author
		values(@name, @nationality, @information);
		set @return = 1;
	END TRY
	BEGIN CATCH
		set @return = 0;
	END CATCH
END
GO
/****** Object:  StoredProcedure [dbo].[insertUser]    Script Date: 6/22/2021 2:57:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[insertUser]
	@name nvarchar(50),
	@dOB nvarchar(10),
	@address nvarchar(50),
	@userName nvarchar(50),
	@passWord nvarchar(50),
	@role bit,
	@return bit OUTPUT
as
BEGIN
	BEGIN TRY
		Insert into UserList
		values(@name,@dOB,@address,@userName,@passWord,@role);
		set @return = 1;
	END TRY
	BEGIN CATCH
		set @return = 0;
	END CATCH
END
GO
USE [master]
GO
ALTER DATABASE [LibraryManagement] SET  READ_WRITE 
GO
