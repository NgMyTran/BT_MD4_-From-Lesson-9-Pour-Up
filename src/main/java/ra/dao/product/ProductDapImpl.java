package ra.dao.product;

import org.springframework.stereotype.Repository;
import ra.model.entity.Category;
import ra.model.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductDapImpl implements IProductDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product ", Product.class).getResultList();
    }

    @Override
    public Product findById(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Product proDel = findById(id);
        if (proDel != null) {
            proDel.setStatus(false);
            entityManager.merge(proDel);
        }
    }

}
