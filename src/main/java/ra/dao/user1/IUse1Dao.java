package ra.dao.user1;

import ra.model.User1;

public interface IUse1Dao {
    void register(User1 user);
    User1 login(String username, String password);
}
