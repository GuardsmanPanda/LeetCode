CREATE FUNCTION getUserIDs(startDate DATE, endDate DATE, minAmount INT) RETURNS INT
BEGIN
  RETURN (
	SELECT COUNT(DISTINCT user_id) as user_cnt
    FROM Purchases
    WHERE time_stamp BETWEEN startDate AND endDate
    AND amount >= minAmount
  );
END
