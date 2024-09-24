package ra.service.customertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.customertest.IEmployeeTestDao;
import ra.model.entity.EmployeeTest;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeTestService implements IEmployeeTestSerice{
    @Autowired
    private IEmployeeTestDao employeeTestDao;


    @Override
    public List<EmployeeTest> findAll() {
        return employeeTestDao.findAll();
    }

    @Override
    public EmployeeTest findById(Integer id) {
        return null;
    }

//    @Override
//    public void create(EmployeeTest employeeTest) {
//        employeeTestDao.create(employeeTest);
//    }
//
//    @Override
//    public void update(EmployeeTest employeeTest) {
//
//    }

    @Override
    public void save(EmployeeTest employeeTest) {
        employeeTestDao.create(employeeTest);
    }

    @Override
    public void delete(Integer id) {

    }
}
