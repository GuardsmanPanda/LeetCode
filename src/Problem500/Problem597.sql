SELECT
COALESCE(ROUND((SELECT COUNT(*) FROM (SELECT DISTINCT requester_id, accepter_id FROM RequestAccepted) as a1) /
(SELECT COUNT(*) FROM (SELECT DISTINCT sender_id, send_to_id FROM FriendRequest) as a2), 2), 0.00) as accept_rate