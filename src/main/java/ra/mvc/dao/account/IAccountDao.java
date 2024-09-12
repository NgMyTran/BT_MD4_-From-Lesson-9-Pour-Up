package ra.mvc.dao.account;

import ra.mvc.model.Account;
//import ra.mvc.model.History;

public interface IAccountDao {
    Account login(String username, String password);
    void sendMoney(int idSender, int idReceiver, int amount);
//    void insertHistory(History history);
}
