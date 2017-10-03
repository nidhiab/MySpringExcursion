package com.nb.services;

import com.nb.beans.Spitter;
import com.nb.dao.interfaces.SpitterDataRepository;
import com.nb.dao.interfaces.SpitterRepository;
import com.nb.services.interfaces.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class SpitterJpaServiceImpl  implements SpitterService {
    @Autowired
    private SpitterDataRepository spitterRepository;

    public void addSpitter(Spitter spitter) {
        this.spitterRepository.save(spitter);
    }

    public void updateSpitter(Spitter spitter) {
        this.spitterRepository.save(spitter);
    }

    public Spitter findSpitter(Long id) {
        return this.spitterRepository.findOne(id);
    }

    public Spitter findSpitterByUsername(String username) {
        return this.spitterRepository.findByUsername(username);
    }

    public List<Spitter> findSpitters(Long max, int count) {
        return this.spitterRepository.findAll();
    }
}