sudo apt update
sudo apt install openjdk-17-jdk -y
java -version

### Mysql installation 

- sudo apt install mysql-server -y
- sudo systemctl start mysql
- sudo mysql_secure_installation



- mysql -u root -p

-- Then create a database (if you haven't):
CREATE DATABASE mywebapp;

-- Create a new user:
CREATE USER 'webappuser'@'localhost' IDENTIFIED BY 'StrongPass123';

-- Grant permissions:
GRANT ALL PRIVILEGES ON mywebapp.* TO 'webappuser'@'localhost';

-- Apply changes:
FLUSH PRIVILEGES;

--------------

LoginServlet.java:

Connection conn = DriverManager.getConnection(
  "jdbc:mysql://localhost:3306/mywebapp", "webappuser", "StrongPass123");

 ---------------------------

  USE mywebapp;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Insert a test user
INSERT INTO users (username, password) VALUES ('admin', 'admin123');
