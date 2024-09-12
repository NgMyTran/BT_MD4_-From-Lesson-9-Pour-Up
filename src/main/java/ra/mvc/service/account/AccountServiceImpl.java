package ra.mvc.service.account;

import ra.mvc.dao.account.AccountDaoImpl;
import ra.mvc.dao.account.IAccountDao;
import ra.mvc.model.Account;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();
    private static Account userLogin = null;

    @Override
    public Account login(String username, String password) {
        Account acc = accountDao.login(username, password);
        if (acc != null) {
            userLogin = acc;
            return acc;
        } else {
            throw new RuntimeException("Tên người dùng hoặc pass sai");
        }
    }

    @Override
    public void sendMoney(int idReceiver, int amount) {
        try {
            accountDao.sendMoney(userLogin.getId(), idReceiver, amount);
            userLogin.setBalance(userLogin.getBalance() - amount);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account getUserLogin() {
        return userLogin;
    }
}
