package com.nb.services;

import com.nb.beans.Spitter;
import com.nb.dao.interfaces.SpitterRepository;
import com.nb.services.interfaces.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SpitterServiceImpl implements SpitterService {
    @Inject
    private SpitterRepository spitterRepository;

    public void addSpitter(Spitter spitter) {
        this.spitterRepository.addSpitter(spitter);
    }

    public void updateSpitter(Spitter spitter) {
        this.spitterRepository.updateSpitter(spitter);
    }

    public Spitter findSpitter(Long id) {
        return this.spitterRepository.findById(id);
    }

    public Spitter findSpitterByUsername(String username) {
        return this.spitterRepository.findByUsername(username);
    }

    public List<Spitter> findSpitters(Long max, int count) {
        return this.spitterRepository.findAll();
    }
}
