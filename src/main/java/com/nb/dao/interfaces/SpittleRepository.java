package com.nb.dao.interfaces;

import com.nb.beans.Spittle;

import java.util.List;


public interface SpittleRepository {
    Spittle findSpittle(Long id);
    List<Spittle> findBySpitterId(Long spitterId);
    public void addSpittle(Spittle spittle);
    public void updateSpittle(Spittle spittle);
    public void removeSpittle(Long id);
}
