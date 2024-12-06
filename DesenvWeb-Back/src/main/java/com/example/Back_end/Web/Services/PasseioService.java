package com.example.Back_end.Web.Services;

import com.example.Back_end.Web.DTOs.CreatePasseioDTO;
import com.example.Back_end.Web.Entities.Passeio.Passeio;
import com.example.Back_end.Web.Repositories.PasseioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PasseioService {
    @Autowired
    PasseioRepository passeioRepository;

    public Passeio createPasseio(CreatePasseioDTO passeioData){
        return passeioRepository.save(new Passeio(passeioData));
    }

    public Page<Passeio> getPasseios(Pageable pageable){
        return passeioRepository.findAll(pageable).map(passeio -> passeio);
    }

    public Passeio getPasseio(int id){
        return passeioRepository.findById(id).get();
    }
}
