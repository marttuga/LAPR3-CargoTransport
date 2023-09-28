CREATE OR REPLACE FUNCTION getCountry RETURN SYS_REFCURSOR
AS 
	C_CURSOR SYS_REFCURSOR;
BEGIN
	OPEN C_CURSOR FOR
		SELECT * FROM COUNTRY;
	RETURN C_CURSOR;
END;

SELECT * FROM SEADISTS
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION getPort RETURN SYS_REFCURSOR
AS 
	C_CURSOR SYS_REFCURSOR;
BEGIN
	OPEN C_CURSOR FOR
		SELECT * FROM LOCATION WHERE TYPE='port';
	RETURN C_CURSOR;
END;

-------------------------------------------------------------------------------
-------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION getBorders RETURN SYS_REFCURSOR
AS 
	C_CURSOR SYS_REFCURSOR;
BEGIN
	OPEN C_CURSOR FOR
		SELECT * FROM BORDERS;
	RETURN C_CURSOR;
END;

-------------------------------------------------------------------------------
-------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION getPositions RETURN SYS_REFCURSOR
AS 
	C_CURSOR SYS_REFCURSOR;
BEGIN
	OPEN C_CURSOR FOR
		SELECT * FROM POSITION;
	RETURN C_CURSOR;
END;


-------------------------------------------------------------------------------
-------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION getSeaDists RETURN SYS_REFCURSOR
AS 
	C_CURSOR SYS_REFCURSOR;
BEGIN
	OPEN C_CURSOR FOR
		SELECT * FROM SEADISTS;
	RETURN C_CURSOR;
END;