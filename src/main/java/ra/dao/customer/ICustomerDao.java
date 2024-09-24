package ra.dao.customer;

import ra.dao.IGenericDao;
import ra.model.entity.Customer;

public interface ICustomerDao extends IGenericDao<Customer, Integer> {

    //all các thao tác thay đổi đều phải đc quản lý bởi transaction

}
