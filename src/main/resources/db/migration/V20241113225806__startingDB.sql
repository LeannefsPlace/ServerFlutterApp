CREATE TABLE IF NOT EXISTS Fact(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title text not null,
    category text not null,
    body text not null,
    grade INT not null default 0
)