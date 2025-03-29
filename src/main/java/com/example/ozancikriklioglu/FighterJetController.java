package com.example.ozancikriklioglu;

import com.example.ozancikriklioglu.FighterJet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fighterjets")
@CrossOrigin(origins = "*")
public class FighterJetController {

    private List<FighterJet> jets = new ArrayList<>();
    private int currentId = 1;

    @GetMapping
    public List<FighterJet> getAll() {
        return jets;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FighterJet> getById(@PathVariable int id) {
        Optional<FighterJet> jet = jets.stream().filter(j -> j.getId() == id).findFirst();
        return jet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FighterJet> create(@RequestBody FighterJet fighterJet) {
        fighterJet.setId(currentId++);
        jets.add(fighterJet);
        return new ResponseEntity<>(fighterJet, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FighterJet> update(@PathVariable int id, @RequestBody FighterJet updatedJet) {
        Optional<FighterJet> existing = jets.stream().filter(j -> j.getId() == id).findFirst();
        if(existing.isPresent()){
            FighterJet jet = existing.get();
            jet.setJetName(updatedJet.getJetName());
            jet.setCodeName(updatedJet.getCodeName());
            jet.setCountryOfOrigin(updatedJet.getCountryOfOrigin());
            jet.setType(updatedJet.getType());
            jet.setArmamentConfigurations(updatedJet.getArmamentConfigurations());
            jet.setPicture(updatedJet.getPicture());
            return ResponseEntity.ok(jet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Optional<FighterJet> jet = jets.stream().filter(j -> j.getId() == id).findFirst();
        if(jet.isPresent()){
            jets.remove(jet.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
