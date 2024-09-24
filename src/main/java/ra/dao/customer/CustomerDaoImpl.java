package ra.dao.customer;

import org.springframework.stereotype.Repository;
import ra.model.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

    @PersistenceContext // tiêm đối tương vào để dùng
    private EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> type = entityManager.createQuery("from Customer", Customer.class);
        List<Customer> list  = type.getResultList();
        return list;
    }

    @Override
    public Customer findById(Integer id) {
        TypedQuery<Customer> type = entityManager.createQuery("from Customer where id = :id", Customer.class);
        Customer cus  = type.setParameter("id",id).getSingleResult();
        return cus;
    }

    @Override
    public void create(Customer customer) {
        entityManager.persist(customer); // thêm mới
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer); // chú ý muốn merge 1 object thì object phải tồn tại trong repository
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(findById(id));
    }
}
