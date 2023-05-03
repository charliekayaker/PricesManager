 CREATE TABLE IF NOT EXISTS BRAND (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(255) NOT NULL
);

CREATE TABLE PRICE (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  BRAND_ID INT NOT NULL,
  START_DATE DATETIME NOT NULL,
  END_DATE DATETIME NOT NULL,
  PRICE_LIST INT NOT NULL,
  PRODUCT_ID INT NOT NULL,
  PRIORITY INT NOT NULL,
  PRICE DECIMAL(10,2) NOT NULL,
  CURR VARCHAR(3) NOT NULL,
 CONSTRAINT FK_BRAND_ID FOREIGN KEY (BRAND_ID) REFERENCES BRAND(ID)
);