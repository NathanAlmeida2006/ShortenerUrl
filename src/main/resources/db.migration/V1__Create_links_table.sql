CREATE TABLE links
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for the link
    original_url  VARCHAR(2048) NOT NULL,            -- Original long URL
    shortened_url VARCHAR(255)  NOT NULL,            -- Shortened URL
    qr_code_url   VARCHAR(2048),                     -- URL for the QR Code
    created_at    TIMESTAMP     NOT NULL             -- Timestamp when the URL was created
);