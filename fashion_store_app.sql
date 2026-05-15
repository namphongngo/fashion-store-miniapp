DROP DATABASE IF EXISTS fashion_store_miniapp;
CREATE DATABASE fashion_store_miniapp;

USE fashion_store_miniapp;

-- CATEGORIES
CREATE TABLE categories (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

-- PRODUCTS
CREATE TABLE products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    image VARCHAR(500),
    description TEXT,
    quantity INT DEFAULT 0,
    category_id BIGINT,

    FOREIGN KEY (category_id)
    REFERENCES categories(id)
);

-- USERS
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    zalo_id VARCHAR(100),
    fullname VARCHAR(255),
    avatar VARCHAR(500)
);

-- FAVORITES
CREATE TABLE favorites (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    product_id BIGINT,

    FOREIGN KEY (product_id)
    REFERENCES products(id)
);

-- BILLS
CREATE TABLE bills (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    customer_name VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(500) NOT NULL,
    total_amount DOUBLE NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),

    FOREIGN KEY (user_id)
    REFERENCES users(id)
);

-- BILL DETAILS
CREATE TABLE bill_details (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    bill_id BIGINT,
    product_id BIGINT,
    quantity INT NOT NULL,
    size VARCHAR(20),
    unit_price DOUBLE NOT NULL,

    FOREIGN KEY (bill_id)
    REFERENCES bills(id),

    FOREIGN KEY (product_id)
    REFERENCES products(id)
);

-- SAMPLE DATA

-- CATEGORIES
INSERT INTO categories(name)
VALUES
('Áo'),
('Quần'),
('Giày'),
('Phụ kiện');

-- PRODUCTS (NIKE STORE)
INSERT INTO products(
    name,
    price,
    image,
    description,
    quantity,
    category_id
)
VALUES

-- ÁO
(
    'Nike Sportswear Club T-Shirt',
    790000,
    'nike-club-shirt.jpg',
    'Áo thun Nike form regular chất cotton mềm mại',
    25,
    1
),

(
    'Nike Tech Fleece Hoodie',
    2490000,
    'nike-tech-fleece.jpg',
    'Áo hoodie Nike Tech Fleece phong cách streetwear',
    18,
    1
),

(
    'Nike Dri-FIT Training Tee',
    990000,
    'nike-drifit.jpg',
    'Áo tập gym Nike Dri-FIT thoáng khí',
    20,
    1
),

-- QUẦN
(
    'Nike Club Jogger Pants',
    1590000,
    'nike-jogger.jpg',
    'Quần jogger Nike chất liệu nỉ cao cấp',
    15,
    2
),

(
    'Nike Sportswear Shorts',
    890000,
    'nike-shorts.jpg',
    'Quần short Nike mặc hằng ngày',
    22,
    2
),

(
    'Nike Cargo Pants',
    1790000,
    'nike-cargo.jpg',
    'Quần cargo Nike form rộng phong cách hiện đại',
    10,
    2
),

-- GIÀY
(
    'Nike Air Force 1',
    3290000,
    'nike-airforce1.jpg',
    'Nike Air Force 1 classic phối đồ cực đẹp',
    12,
    3
),

(
    'Nike Dunk Low Panda',
    3590000,
    'nike-dunk-low.jpg',
    'Nike Dunk Low Panda phối màu trắng đen',
    10,
    3
),

(
    'Nike Air Jordan 1 Mid',
    4290000,
    'nike-jordan1.jpg',
    'Nike Air Jordan 1 Mid phong cách bóng rổ',
    8,
    3
),

(
    'Nike ZoomX Invincible Run',
    4990000,
    'nike-zoomx.jpg',
    'Giày chạy bộ Nike ZoomX siêu êm',
    6,
    3
),

-- PHỤ KIỆN
(
    'Nike Heritage Backpack',
    1190000,
    'nike-backpack.jpg',
    'Balo Nike Heritage tiện dụng hằng ngày',
    14,
    4
),

(
    'Nike Everyday Cushioned Socks',
    390000,
    'nike-socks.jpg',
    'Set vớ Nike Everyday chính hãng',
    40,
    4
),

(
    'Nike Cap Swoosh',
    650000,
    'nike-cap.jpg',
    'Nón Nike logo Swoosh basic',
    30,
    4
);

-- USERS
INSERT INTO users(
    zalo_id,
    fullname,
    avatar
)
VALUES
(
    'zalo_001',
    'Phong',
    'avatar.jpg'
);

-- BILLS
INSERT INTO bills(
    user_id,
    customer_name,
    phone,
    address,
    total_amount,
    status
)
VALUES
(
    1,
    'Phong',
    '0909123456',
    'Ho Chi Minh City',
    5780000,
    'COMPLETED'
);

-- BILL DETAILS
INSERT INTO bill_details(
    bill_id,
    product_id,
    quantity,
    size,
    unit_price
)
VALUES

(
    1,
    1,
    1,
    'L',
    790000
),

(
    1,
    7,
    1,
    '42',
    3290000
),

(
    1,
    11,
    1,
    'FREE SIZE',
    1190000
);