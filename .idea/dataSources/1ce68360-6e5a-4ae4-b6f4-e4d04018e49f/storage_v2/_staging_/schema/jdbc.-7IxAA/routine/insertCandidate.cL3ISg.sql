create
    definer = root@localhost procedure insertCandidate( p_first_name varchar(50),  p_last_name varchar(50),
                                                        p_dob date,  p_phone varchar(20),  p_email varchar(100),
                                                       OUT p_candidate_id int)
BEGIN
    INSERT INTO candidates (first_name, last_name, dob, phone, email)
    VALUES (p_first_name, p_last_name, p_dob, p_phone, p_email);

    -- Get the last inserted ID
    SET p_candidate_id = LAST_INSERT_ID();
    -- select distinct(lấy gtrij id k trùng lặp) LAST_INSERT_ID() into p_candidate_id from candidate
END;

-- call insertCandidate ('huyen', '')
