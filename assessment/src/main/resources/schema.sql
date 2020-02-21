drop table if exists Account;
drop table if exists Product;
drop table if exists AccountProduct;

create table Account (
  accountId varchar(50) not null,
  accountType varchar(50) not null
);

create table Product (
  productId varchar(50) not null,
  productName varchar(50) not null,
  riskRating int,
  productType varchar(50) not null
);

create table ACCOUNTPRODUCT (
  accountNumber varchar(50) not null,
  accountType varchar(50) not null,
  productName varchar(50) not null,
  productType varchar(50) not null,
  amount DECIMAL(20, 2)
);

