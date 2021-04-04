package com.thuchanh.repository.impl;

import com.thuchanh.model.Product;
import com.thuchanh.repository.IProductRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class ProductRepoImpl implements IProductRepo {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("select c from product c ", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = em.createQuery("select c from product c where c.id=:id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Product model) {
        if (model.getId() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Product product = findById(id);
        if (product.getId() != null) {
            em.remove(product);
        }
    }
}
