package baitap5.repository.impl;

import baitap5.model.Product;
import baitap5.repository.IProductRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class ProductRepoImpl implements IProductRepo {
//    @PersistenceContext
//    private EntityManager em;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery("select c from product c ", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery("select c from product c where c.id=:id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

//    @Override
//    public void save(Product model) {
//        if (model.getId() != null) {
//            em.merge(model);
//        } else {
//            em.persist(model);
//        }
//    }


    @Override
    public void save(Product model) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(model);
        entityTransaction.commit();
    }

    @Override
    public void remove(Long id) {
        Product product = findById(id);
        if (product.getId() != null) {
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            BaseRepository.entityManager.remove(product);
            entityTransaction.commit();
        }
    }
}
