CREATE TABLE "members"
(
    "id"         VARCHAR(36) PRIMARY KEY,
    "username"   VARCHAR(20) UNIQUE,
    "created_at" DATETIME,
    "updated_at" DATETIME
);
