package com.ttknp.springbootondockerapp.dao;

import com.ttknp.springbootondockerapp.entity.Romance;
import com.ttknp.springbootondockerapp.repository.RomanceRepository;
import com.ttknp.springbootondockerapp.service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class RomanceDao implements BooksService<Romance> {
    private final RomanceRepository repository;
    @Autowired
    public RomanceDao(RomanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Romance> reads() {
        return repository.findAll();
    }

    @Override
    public Romance read(String rid) {
        return repository.findById(rid).map(romance -> {
            log.info("RID :{} exits!!",rid);
            return romance;
        }).orElseThrow(() -> {
            logIdDidNotExist(rid);
            return new RuntimeException(("RID : "+rid+" exits!!"));
        });
    }

    @Override
    public Romance create(Romance obj) {
        return repository.save(obj);
    }

    @Override
    public Romance update(Romance obj, String rid) {
        return repository.findById(rid).map(romance -> {
            romance.setTitle(obj.getTitle());
            romance.setPrice(obj.getPrice());
            return repository.save(romance);
        }).orElseThrow(() -> {
            logIdDidNotExist(rid);
            return new RuntimeException(("RID : "+rid+" exits!!"));
        });
    }

    @Override
    public Map<String, Romance> delete(String rid) {
        Map<String,Romance> response = new HashMap<>();;
        return repository.findById(rid).map(romance -> {
            response.put("deleted",romance);
            repository.delete(romance);
            return response;
        }).orElseThrow(() -> {
            logIdDidNotExist(rid);
            return new RuntimeException(("RID : "+rid+" didn't exits!!"));
        });
    }

    private void logIdDidNotExist(String rid) {
        log.info("RID :{} didn't exit!!",rid);
    }
}
