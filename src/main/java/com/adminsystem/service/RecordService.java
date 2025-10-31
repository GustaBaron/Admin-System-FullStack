package com.adminsystem.service; // Use seu pacote atual

import com.adminsystem.entity.Record;
import com.adminsystem.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    public Record save(Record record) {
        // Aqui você pode adicionar lógicas, como setar a data de criação
        // record.setCreatedDate(LocalDate.now());
        return recordRepository.save(record);
    }

    public void deleteById(Long id) {
        recordRepository.deleteById(id);
    }

    public Record findById(Long id) {
        return recordRepository.findById(id).orElse(null);
    }

    // O método de update também usa o save()
    public Record update(Long id, Record recordDetails) {
        Record record = recordRepository.findById(id).orElse(null);
        if (record != null) {
            // Atualiza todos os campos
            record.setName(recordDetails.getName());
            record.setEmail(recordDetails.getEmail());
            record.setPhone(recordDetails.getPhone());
            record.setCategory(recordDetails.getCategory());
            record.setStatus(recordDetails.getStatus());
            record.setStartDate(recordDetails.getStartDate());
            record.setDepartment(recordDetails.getDepartment());
            record.setDescription(recordDetails.getDescription());
            return recordRepository.save(record);
        }
        return null;
    }
}