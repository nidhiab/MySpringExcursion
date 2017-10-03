package com.nb.dao.interfaces;

import com.nb.beans.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SpitterDataRepository
            extends JpaRepository<Spitter, Long> {
    public Spitter findByUsername(String userName);
}
