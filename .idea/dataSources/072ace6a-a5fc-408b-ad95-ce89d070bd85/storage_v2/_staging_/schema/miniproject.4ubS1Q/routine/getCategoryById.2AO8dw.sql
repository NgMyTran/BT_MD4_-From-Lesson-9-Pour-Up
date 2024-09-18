create
    definer = root@localhost procedure getCategoryById(IN id int as categoryId)
BEGIN
    SELECT * FROM category WHERE id = categoryId;
END;

