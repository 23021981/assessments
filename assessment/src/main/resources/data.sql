
INSERT INTO Account (accountId, accountType) VALUES
  ('A1', 'Retail'),
  ('A2', 'Wholesale'),
  ('A3','Internal');

 INSERT INTO Product (productId, productName, riskRating, productType) VALUES
 ('PA1','Cash',2,'Asset'),
 ('PA2','Bond',1,'Asset'),
 ('PL1','Collateralised Loan',3, 'Liability'),
 ('PA3','Tier 1 Capital',0,'Asset');

 INSERT INTO ACCOUNTPRODUCT (accountNumber, accountType, productName, productType, amount) VALUES
 ('IA001', 'Internal', 'Tier 1 Capital', 'Asset',1000000000.00),

 ('IA002', 'Internal', 'Collateralised Loan', 'Liability', 110000.00),
 ('IA003', 'Internal', 'Collateralised Loan', 'Liability', 120000.00),
 ('IA004', 'Internal', 'Collateralised Loan', 'Liability', 130000.00),
 ('IA005', 'Internal', 'Collateralised Loan', 'Liability', 140000.00),
 ('IA006', 'Internal', 'Collateralised Loan', 'Liability', 150000.00),
 ('IA007', 'Internal', 'Collateralised Loan', 'Liability', 160000.00),
 ('IA008', 'Internal', 'Collateralised Loan', 'Liability', 170000.00),
 ('IA009', 'Internal', 'Collateralised Loan', 'Liability', 180000.00),
 ('IA010', 'Internal', 'Collateralised Loan', 'Liability', 190000.00),
 ('IA011', 'Internal', 'Collateralised Loan', 'Liability', 195000.00),

 ('WA001', 'Wholesale', 'Cash', 'Asset', 40000.00),
 ('WA002', 'Wholesale', 'Cash', 'Asset', 50000.00),
 ('WA003', 'Wholesale', 'Cash', 'Asset', 60000.00),
 ('WA004', 'Wholesale', 'Cash', 'Asset', 70000.00),
 ('WA005', 'Wholesale', 'Cash', 'Asset', 80000.00),
 ('WA006', 'Wholesale', 'Cash', 'Asset', 90000.00),
 ('WA007', 'Wholesale', 'Cash', 'Asset', 45000.00),
 ('WA008', 'Wholesale', 'Cash', 'Asset', 55000.00),
 ('WA009', 'Wholesale', 'Cash', 'Asset', 65000.00),
 ('WA010', 'Wholesale', 'Cash', 'Asset', 75000.00),

 ('WA011', 'Wholesale', 'Bond', 'Asset', 80000.00),
 ('WA012', 'Wholesale', 'Bond', 'Asset', 90000.00);
