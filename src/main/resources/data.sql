INSERT INTO transactions (id, user_id, amount, currency, status, type) VALUES
('txn_001', 'user_001', 100.50, 'USD', 'COMPLETED', 'PURCHASE'),
('txn_002', 'user_001', 25.75, 'USD', 'PENDING', 'REFUND'),
('txn_003', 'user_002', 300.00, 'EUR', 'COMPLETED', 'SUBSCRIPTION'),
('txn_004', 'user_002', 45.90, 'EUR', 'FAILED', 'PURCHASE'),
('txn_005', 'user_003', 75.25, 'GBP', 'COMPLETED', 'TRANSFER'),
('txn_006', 'user_003', 120.00, 'GBP', 'COMPLETED', 'SERVICE'),
('txn_007', 'user_004', 19.99, 'USD', 'PENDING', 'PURCHASE'),
('txn_008', 'user_004', 200.00, 'USD', 'COMPLETED', 'DEPOSIT'),
('txn_009', 'user_005', 55.50, 'EUR', 'COMPLETED', 'PURCHASE'),
('txn_010', 'user_005', 89.95, 'EUR', 'REFUNDED', 'REFUND'),
('txn_011', 'user_006', 150.00, 'USD', 'COMPLETED', 'SUBSCRIPTION'),
('txn_012', 'user_006', 32.45, 'USD', 'FAILED', 'PURCHASE'),
('txn_013', 'user_007', 65.75, 'GBP', 'COMPLETED', 'TRANSFER'),
('txn_014', 'user_007', 210.00, 'GBP', 'PENDING', 'SERVICE'),
('txn_015', 'user_008', 29.99, 'USD', 'COMPLETED', 'PURCHASE'),
('txn_016', 'user_008', 180.50, 'USD', 'COMPLETED', 'DEPOSIT'),
('txn_017', 'user_009', 42.80, 'EUR', 'REFUNDED', 'REFUND'),
('txn_018', 'user_009', 95.00, 'EUR', 'COMPLETED', 'SUBSCRIPTION'),
('txn_019', 'user_010', 125.30, 'GBP', 'FAILED', 'TRANSFER'),
('txn_020', 'user_010', 38.25, 'GBP', 'COMPLETED', 'PURCHASE');

INSERT INTO transaction_details (id, transaction_id, description, category, location, reference_number) VALUES
('detail_001', 'txn_001', 'Grocery shopping', 'FOOD', 'New York', 'REF12345'),
('detail_002', 'txn_002', 'Book refund', 'EDUCATION', 'Online', 'REF54321'),
('detail_003', 'txn_003', 'Monthly subscription', 'SERVICES', 'Online', 'REF98765'),
('detail_004', 'txn_004', 'Electronics purchase', 'ELECTRONICS', 'Berlin', 'REF24680'),
('detail_005', 'txn_005', 'Money transfer to friend', 'TRANSFER', 'London', 'REF13579'),
('detail_006', 'txn_006', 'Consulting service', 'PROFESSIONAL', 'Remote', 'REF11223'),
('detail_007', 'txn_007', 'Clothing purchase', 'FASHION', 'Los Angeles', 'REF44556'),
('detail_008', 'txn_008', 'Bank deposit', 'FINANCE', 'New York', 'REF77889'),
('detail_009', 'txn_009', 'Restaurant bill', 'FOOD', 'Paris', 'REF33445'),
('detail_010', 'txn_010', 'Concert ticket refund', 'ENTERTAINMENT', 'Online', 'REF66778'),
('detail_011', 'txn_011', 'Software subscription', 'TECHNOLOGY', 'Online', 'REF99001'),
('detail_012', 'txn_012', 'Flight booking failed', 'TRAVEL', 'Online', 'REF22334'),
('detail_013', 'txn_013', 'Family money transfer', 'TRANSFER', 'Edinburgh', 'REF55667'),
('detail_014', 'txn_014', 'Legal consultation', 'PROFESSIONAL', 'London', 'REF88990'),
('detail_015', 'txn_015', 'Book purchase', 'EDUCATION', 'Chicago', 'REF11223'),
('detail_016', 'txn_016', 'Salary deposit', 'FINANCE', 'New York', 'REF44556'),
('detail_017', 'txn_017', 'Hotel booking refund', 'TRAVEL', 'Online', 'REF77889'),
('detail_018', 'txn_018', 'Gym membership', 'HEALTH', 'Online', 'REF33445'),
('detail_019', 'txn_019', 'Failed rent transfer', 'HOUSING', 'Manchester', 'REF66778'),
('detail_020', 'txn_020', 'Pharmacy purchase', 'HEALTH', 'Birmingham', 'REF99001');

-- Users created on 2025-06-27
INSERT INTO users (id, full_name, created_at) VALUES
('user-a1', 'Alice Johnson',  '2025-06-27 10:00:00'),
('user-a2', 'Alan Walker',    '2025-06-27 10:00:00'),
('user-a3', 'Anna Bell',      '2025-06-27 09:50:00'),

-- Users created on 2025-06-26
('user-b1', 'Brian O''Conner','2025-06-26 15:30:00'),
('user-b2', 'Brenda Stone',   '2025-06-26 15:00:00'),

-- Users created on 2025-06-25
('user-c1', 'Charlie Hunt',   '2025-06-25 08:00:00'),
('user-c2', 'Catherine Zeta', '2025-06-25 07:45:00'),

-- Users created on 2025-06-24
('user-d1', 'David Nolan',    '2025-06-24 18:10:00'),
('user-d2', 'Dana White',     '2025-06-24 17:55:00');
