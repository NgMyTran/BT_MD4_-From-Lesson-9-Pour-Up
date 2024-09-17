create
    definer = root@localhost procedure getCategoryById(IN categoryId int)
BEGIN
    SELECT * FROM category WHERE id = categoryId;
END;

