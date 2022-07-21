
# -----------------------------------------------------------------------
# ID_TABLE
# -----------------------------------------------------------------------
drop table if exists ID_TABLE;

CREATE TABLE ID_TABLE
(
    ID_TABLE_ID INTEGER NOT NULL,
    TABLE_NAME VARCHAR(255) NOT NULL,
    NEXT_ID INTEGER NOT NULL,
    QUANTITY INTEGER NOT NULL,
    PRIMARY KEY(ID_TABLE_ID),
    UNIQUE (TABLE_NAME));

