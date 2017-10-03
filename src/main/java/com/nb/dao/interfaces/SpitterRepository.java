package com.nb.dao.interfaces;

import com.nb.beans.Spitter;

import java.util.List;


public interface SpitterRepository {
    public void addSpitter(Spitter spitter);
    public void updateSpitter(Spitter spitter);
    public Spitter findById(Long id);
    public List<Spitter> findAll();
    public Spitter findByUsername(String userName);
}
