package com.example.Back_end.Web.Controller;

import com.example.Back_end.Web.DTOs.CreatePasseioDTO;
import com.example.Back_end.Web.Entities.Passeio.Passeio;
import com.example.Back_end.Web.Services.PasseioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passeio")
public class PasseioController {
    @Autowired
    PasseioService passeioService;

    @PostMapping()
    public ResponseEntity<Passeio> createPasseio(@RequestBody CreatePasseioDTO data){
       Passeio passeio = passeioService.createPasseio(data);
        return ResponseEntity.ok(passeio);
    }

    @GetMapping
    public Page<Passeio> getAllPasseios(@PageableDefault(size = 10, sort = {"id"})Pageable pageable){
        return passeioService.getPasseios(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passeio> getPasseioById(@PathVariable int id){
        Passeio passeio = passeioService.getPasseio(id);
        return ResponseEntity.ok(passeio);
    }

}
