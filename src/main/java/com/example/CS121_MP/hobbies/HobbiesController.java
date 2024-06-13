package com.example.CS121_MP.hobbies;

import com.example.CS121_MP.members.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.JsonObject;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/hobbies")
public class HobbiesController {

    private final HobbiesService hobbiesService;

    @Autowired
    public HobbiesController(HobbiesService hobbiesService) {
        this.hobbiesService = hobbiesService;
    }

    @GetMapping
    public List<Hobbies> getHobbies() {
        return hobbiesService.getHobbies();
    }

    @GetMapping(path = "/name/{name}")
    public Optional<Hobbies> getHobbiesByName(String name) {
        return hobbiesService.getHobbiesByName(name);
    }

    @GetMapping(path = "/member/{members}")
    public List<Hobbies> getHobbiesByMembers(Members members) {
        return hobbiesService.getHobbiesByMembers(members);
    }

    @PostMapping
    public ResponseEntity<?> registerHobby(@RequestBody Hobbies hobbies){
        hobbiesService.addHobby(hobbies);
        return ResponseEntity.ok().body(new JsonObject());
    }

    @PutMapping(path = "/{hobbiesId}")
    public ResponseEntity<?> updateHobby(
            @PathVariable("hobbiesId") Long hobbiesId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String media) {
        hobbiesService.updateHobbies(hobbiesId, name, description, media);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "{hobbiesId}")
    public ResponseEntity<?> deleteHobby(@PathVariable("hobbiesId") Long hobbiesId) {
        hobbiesService.deleteHobbies(hobbiesId);
        return ResponseEntity.ok().build();
    }





}
