package com.waracle.cakemgr.dao;

import com.waracle.cakemgr.model.Cake;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Component
public class CakeDao {

    @PersistenceContext
    private EntityManager em;

    public Long save(Cake cake) {
        em.persist(cake);
        return cake.getId();
    }

    public List<Cake> getAll() {
        return em.createQuery("SELECT c FROM Cake c", Cake.class).getResultList();
    }

    public int truncate() {
        return em.createQuery("DELETE FROM Cake").executeUpdate();
    }

}
