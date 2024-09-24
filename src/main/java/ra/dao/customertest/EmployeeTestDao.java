package ra.dao.customertest;

import org.springframework.stereotype.Repository;
import ra.model.entity.EmployeeTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeTestDao implements IEmployeeTestDao {
    @PersistenceContext // tiêm đối tươg vào su dung
   private EntityManager entityManager;

    @Override
    public List<EmployeeTest> findAll() {
        TypedQuery<EmployeeTest> type= entityManager.createQuery("from EmployeeTest", EmployeeTest.class);
        List<EmployeeTest> employeetestList = type.getResultList();
        return employeetestList;
    }

    @Override
    public EmployeeTest findById(Integer id) {
        return null;
    }

    @Override
    public void create(EmployeeTest employeeTest) {
        entityManager.persist(employeeTest);
    }

    @Override
    public void update(EmployeeTest employeeTest) {

    }

    @Override
    public void delete(Integer id) {

    }
}
