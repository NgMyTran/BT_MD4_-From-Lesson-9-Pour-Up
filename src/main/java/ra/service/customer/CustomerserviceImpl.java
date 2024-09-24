package ra.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.customer.ICustomerDao;
import ra.model.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerserviceImpl implements ICustomerService{
    @Autowired
    private ICustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        if(customer.getId()==null) {
            customerDao.create(customer);
        }else {
            customerDao.update(customer);
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        customerDao.delete(id);
    }
}
