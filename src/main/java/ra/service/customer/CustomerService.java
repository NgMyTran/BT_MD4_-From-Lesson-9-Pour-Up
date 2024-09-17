package ra.service.customer;

import org.springframework.stereotype.Service;
import ra.config.ConnectionDB;
import ra.dao.customer.CustomerDao;
import ra.dao.customer.ICustomerDao;
import ra.model.Customer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
//    private ICustomerDao customerDao = new CustomerDao();

    private List<Customer> list = new ArrayList<>();

    public CustomerService() {
        // khơi tao giá trị ban dau
        list.add(new Customer(1, "Nguyễn Văn A", "Hưng Nguyên", "hung@gmail.com"));
        list.add(new Customer(2, "Nguyễn Văn B", "Hưng Nguyên", "hung@gmail.com"));
        list.add(new Customer(3, "Nguyễn Văn C", "Hưng Nguyên", "hung@gmail.com"));
    }

    @Override
    public List<Customer> getAll() {
        return list;
    }

    @Override
    public Customer findById(Integer id) {
        return list.stream().filter(c -> c.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId()) == null) {
            customer.setId(getNewId());
            list.add(customer);
        } else {
            list.set(list.indexOf(findById(customer.getId())), customer);
        }
    }

    @Override
    public void delete(Integer id) {
        Customer del = findById(id);
        if (del != null) {
            list.remove(del); // xóa
        }
    }

    private int getNewId () {
        // tìm ra thằng id lớn nhất + 1
        return list.stream().map(Customer::getId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }
}
