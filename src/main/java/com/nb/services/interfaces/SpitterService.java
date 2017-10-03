package com.nb.services.interfaces;

import com.nb.beans.Spitter;

import java.util.List;


public interface SpitterService {
    public void addSpitter(Spitter spitter);
    public void updateSpitter(Spitter spitter);
    public Spitter findSpitter(Long id);
    public List<Spitter> findSpitters(Long max, int count);
    public Spitter findSpitterByUsername(String username);
}
