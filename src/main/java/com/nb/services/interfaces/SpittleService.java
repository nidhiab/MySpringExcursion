package com.nb.services.interfaces;

import com.nb.beans.Spittle;

import java.util.List;

/**
 * Created by Nidhia Bhasin on 10-08-2017.
 */
public interface SpittleService {
    public void addSpittle(Spittle spittle);
    public void updateSpittle(Spittle spittle);
    public Spittle findSpittle(Long id);
    public List<Spittle> findBySpitterId(Long spitterid);
}
