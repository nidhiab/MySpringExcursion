package com.nb.dao;

import com.nb.beans.Spittle;
import com.nb.dao.interfaces.SpittleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/*@Repository
@Transactional*/
public class HibernateSpittleRepositoryImpl implements SpittleRepository {
    //@Inject
    SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Spittle findSpittle(Long id) {
        return (Spittle) currentSession().get(Spittle.class, id);
    }
    public List<Spittle> findBySpitterId(Long spitterId) {
        return  currentSession()
                .createCriteria(Spittle.class)
                .add(Restrictions.eq("spitterId", spitterId))
                .list();

    }

    public void addSpittle(Spittle spittle){
        spittle.setTime(new Date());
        currentSession().persist(spittle);
    }
    public void updateSpittle(Spittle spittle){
        Spittle dataBaseSpittle = (Spittle) currentSession().find(Spittle.class, spittle.getId());
        dataBaseSpittle.setMessage(spittle.getMessage());
        currentSession().update(dataBaseSpittle);
    }
    public void removeSpittle(Long id){
        Spittle p = (Spittle) currentSession().find(Spittle.class, id);
        if(null != p){
            currentSession().remove(p);
        }
    }
}