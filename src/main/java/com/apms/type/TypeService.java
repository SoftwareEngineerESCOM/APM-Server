package com.apms.type;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;
    public List<Type> getAll() {
        List<Type> records = new ArrayList<>();
        typeRepository.findAll().forEach(records::add);
        return records;
    }
    public Type getOne(Integer id) {
        return typeRepository.findById(id).get();
    }
    public void add(Type Type) {
        typeRepository.save(Type);
    }
    public void update(Type Type) {
        // if exists updates otherwise inserts
        typeRepository.save(Type);
    }
    public void delete(Integer id) {
        typeRepository.deleteById(id);
    }
}
