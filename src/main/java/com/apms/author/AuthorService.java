package com.apms.author;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public List<Author> getAll() {
        List<Author> records = new ArrayList<>();
        authorRepository.findAll().forEach(records::add);
        return records;
    }
    public Author getOne(Integer id) {
        return authorRepository.findById(id).get();
    }
    public void add(Author Author) {
        authorRepository.save(Author);
    }
    public void update(Author Author) {
        // if exists updates otherwise inserts
        authorRepository.save(Author);
    }
    public void delete(Integer id) {
        authorRepository.deleteById(id);
    }
}
