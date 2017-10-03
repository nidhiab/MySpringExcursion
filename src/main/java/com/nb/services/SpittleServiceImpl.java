package com.nb.services;


import com.nb.beans.Spittle;

import com.nb.dao.interfaces.SpittleRepository;
import com.nb.services.interfaces.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class SpittleServiceImpl implements SpittleService {
    @Autowired
    private SpittleRepository spittleRepository;

    public void addSpittle(Spittle spittle) {
        this.spittleRepository.addSpittle(spittle);
    }

    public void updateSpittle(Spittle spittle) {
        this.spittleRepository.updateSpittle(spittle);
    }

    public Spittle findSpittle(Long id) {
        return this.spittleRepository.findSpittle(id);
    }

    public List<Spittle> findBySpitterId(Long spitterid) {
        return this.spittleRepository.findBySpitterId(spitterid);
    }
}

