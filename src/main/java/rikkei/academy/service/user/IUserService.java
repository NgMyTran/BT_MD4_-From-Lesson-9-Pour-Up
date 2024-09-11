package rikkei.academy.service.user;

import rikkei.academy.service.IGenericService;
import rikkei.academy.model.User;

import java.util.List;

public interface IUserService extends IGenericService<User, Integer> {
    List<User> searchByCountry(String searchCountry);
    List<User> selectAllSortedByName(boolean b);
}

