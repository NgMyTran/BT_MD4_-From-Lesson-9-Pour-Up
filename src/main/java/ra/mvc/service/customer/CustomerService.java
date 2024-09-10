package ra.mvc.service.customer;

import ra.mvc.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomerService implements ICustomerService {
    private List<Customer> customerList = new ArrayList<>();

    public CustomerService() {
        // khơi tao giá trị ban dau
        customerList.add(new Customer(1, "Nguyễn Văn A", "Hưng Nguyên", "hung@gmail.com"));
        customerList.add(new Customer(2, "Nguyễn Văn B", "Hưng Nguyên", "hung@gmail.com"));
        customerList.add(new Customer(3, "Nguyễn Văn C", "Hưng Nguyên", "hung@gmail.com"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findById(Integer id) {
        return customerList.stream().filter(c -> c.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId()) == null) {
            //k ton tai, them moi
            customer.setId(getNewId());
            customerList.add(customer);
        } else {
            customerList.set(
                    customerList.indexOf(
                            findById(
                                    customer.getId()
                            )
                    ), customer
            );
        }
    }

    @Override
    public void delete(Integer id) {
        Customer cusDel = findById(id);
        if (cusDel != null) {
            customerList.remove(cusDel);
        }
    }

    private int getNewId() {
        return customerList.stream()
                .map(Customer::getId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }
}
