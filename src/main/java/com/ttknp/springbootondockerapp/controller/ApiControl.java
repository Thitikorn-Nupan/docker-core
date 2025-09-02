package com.ttknp.springbootondockerapp.controller;


import com.ttknp.springbootondockerapp.entity.Romance;
import com.ttknp.springbootondockerapp.service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "${base-rest-prefix}")
public class ApiControl {

    private final BooksService<Romance> romanceBooksService;

    @Autowired
    public ApiControl(BooksService<Romance> romanceBooksService) {
        this.romanceBooksService = romanceBooksService;
    }

    @GetMapping
    private ResponseEntity<?> testResponse() {
        return ResponseEntity.ok("hello, Docker");
    }

    @GetMapping(value = "/romance/reads")
    private ResponseEntity<Iterable<Romance>> readsRomance() {
        log.info("requested localhost:8080/ttknp/romance/reads");
        int row = 0;
        for (Romance romance : romanceBooksService.reads()) row++;
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Data","total of romances book is "+row)
                .body(null);
    }

    @GetMapping(value = "/romance/read/{rid}")
    private ResponseEntity<Romance> readRomance(@PathVariable String rid) {
        log.info("requested localhost:8080/ttknp/romance/read/{rid}");
        boolean result = romanceBooksService.read(rid).getRid() != null;
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Data","romance id "+rid+" exists "+result)
                .body(null);
    }

    @PostMapping(value = "/romance/create")
    private ResponseEntity<Romance> createRomance(@RequestBody Romance romance) {
        log.info("requested localhost:8080/ttknp/romance/create");
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Data","romance creates "+!romanceBooksService.create(romance).getRid().isEmpty())
                .body(null);
    }

    @PutMapping(value = "/romance/update/{rid}")
    private ResponseEntity<Romance> createRomance(@RequestBody Romance romance , @PathVariable String rid) {
        log.info("requested localhost:8080/ttknp/romance/update/{rid}");
        return ResponseEntity.status(HttpStatus.OK)
                .header("Data","romance updates "+!romanceBooksService.update(romance,rid).getRid().isEmpty())
                .body(null);
    }


    @DeleteMapping(value = "/romance/delete/{rid}")
    private ResponseEntity<Map<String,Romance>> deleteRomance(@PathVariable String rid) {
        log.info("requested localhost:8080/ttknp/romance/delete/{rid}");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Data","romance deletes "+!romanceBooksService.delete(rid).isEmpty())
                .body(null);
    }




}
