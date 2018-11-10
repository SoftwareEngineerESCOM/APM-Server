package com.apms.title;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class TitleService {
	
    @Autowired
    private TitleRepository titleRepository;

    public List<Title> getAll() {
        List<Title> records = new ArrayList<>();
        titleRepository.findAll().forEach(records::add);
        return records;
    }

    public Title getOne(Integer id) {
        return titleRepository.findById(id).get();
    }

    public void add(Title title) {
        titleRepository.save(title);
    }

    public void update(Title title) {
        // if exists updates otherwise inserts
        titleRepository.save(title);
    }

    public void delete(Integer id) {
        titleRepository.deleteById(id);
    }
}
