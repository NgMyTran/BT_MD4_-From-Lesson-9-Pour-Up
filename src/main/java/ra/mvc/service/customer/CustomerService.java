package ra.mvc.service.customer;

import ra.mvc.dao.customer.CustomerDao;
import ra.mvc.dao.customer.ICustomerDao;
import ra.mvc.model.Customer;

import java.util.List;

public class CustomerService implements ICustomerService {
//   ICustomerService customerService = new CustomerService();
    private ICustomerDao customerDao = new CustomerDao();

    @Override
    public List<Customer> getAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerDao.findById(id);
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId()) != null) {
           customerDao.update(customer);
        } else {
           customerDao.create(customer);
        }
    }

    @Override
    public void delete(Integer id) {
        customerDao.delete(id);
    }
//
//    private int getNewId() {
//        return customerList.stream()
//                .map(Customer::getId)
//                .max(Comparator.naturalOrder())
//                .orElse(0) + 1;
//    }
}
