package ra.dao.category;

import org.springframework.stereotype.Repository;
import ra.model.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class CategoryDaoImpl implements ICategoryDao {
    @PersistenceContext // tiêm đối tươg vào su dung
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> type = entityManager.createQuery("from Category", Category.class);
        List<Category> list = type.getResultList();
        return list;
    }

    @Override
    public Category findById(Integer id) {
        TypedQuery<Category> type = entityManager.createQuery("from Category where id = :id", Category.class);
        Category cate = type.setParameter("id", id).getSingleResult();
        return cate;
    }

    @Override
    public void create(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Override
    public void delete(Integer id) {
        Category cateDel = findById(id);
        if (cateDel != null) {
            cateDel.setStatus(false);
            entityManager.merge(cateDel);
        }
    }
}
