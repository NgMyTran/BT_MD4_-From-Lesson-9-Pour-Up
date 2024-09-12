create
    definer = root@localhost procedure changeBalance(IN p_amount int, IN p_id int)
BEGIN
    DECLARE current_balance INT;
    SELECT balance INTO current_balance
    FROM Account
    WHERE id = p_id;

    IF (current_balance + p_amount) < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Số dư tài khoản không đủ để thực hiện giao dịch';
    ELSE
    UPDATE Account
    SET balance = balance + p_amount
    WHERE id = p_id;
    END IF;
END;

