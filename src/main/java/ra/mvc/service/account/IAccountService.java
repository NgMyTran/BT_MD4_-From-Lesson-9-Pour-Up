package ra.mvc.service.account;

import ra.mvc.model.Account;

public interface IAccountService {
    Account login(String username, String password);
    void sendMoney(int idReceiver, int amount);
    Account getUserLogin();
}
