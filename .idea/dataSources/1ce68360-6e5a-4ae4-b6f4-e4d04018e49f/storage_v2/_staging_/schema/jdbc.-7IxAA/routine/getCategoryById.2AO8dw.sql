create
   procedure getCategoryById(IN id int)
begin
    SELECT * FROM category WHERE id = id;
end;

