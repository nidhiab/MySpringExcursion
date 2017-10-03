package com.nb.dao;

import com.nb.beans.Spittle;
import com.nb.dao.interfaces.SpittleRepository;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;



@Repository
@Transactional
public class JpaSpittleRepositoryImpl implements SpittleRepository {
    @PersistenceContext
    private EntityManager em;

    public void addSpittle(Spittle spittle){
        spittle.setTime(new Date());
        em.persist(spittle);
    }
    public void updateSpittle(Spittle spittle){

        Spittle dataBaseSpittle = (Spittle) em.find(Spittle.class, spittle.getId());
        dataBaseSpittle.setMessage(spittle.getMessage());
        em.merge(dataBaseSpittle);
    }
    public void removeSpittle(Long id){
        Spittle p = (Spittle) em.find(Spittle.class, id);
        if(null != p){
            em.remove(p);
        }
    }
    public Spittle findSpittle(Long id) {
        return (Spittle) em.find(Spittle.class, id);
    }
    public List<Spittle> findBySpitterId(Long spitterId) {
        return em.createNamedQuery("Spittle.findAllSpittlesForASpitter")
                .setParameter("spitterId", spitterId)
                .getResultList();
    }

}
