package com.example.CS121_MP.hobbies;

import com.example.CS121_MP.members.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HobbiesService {

    private final HobbiesRepository hobbiesRepository;

    @Autowired
    public HobbiesService(HobbiesRepository hobbiesRepository) {
        this.hobbiesRepository = hobbiesRepository;
    }

    public List<Hobbies> getHobbies() {
        return hobbiesRepository.findAll();
    }

    public Optional<Hobbies> getHobbiesByName(String name) {
        return hobbiesRepository.findHobbiesByName(name);
    }

    public List<Hobbies> getHobbiesByMembers(Members members) {
        return hobbiesRepository.findHobbiesByMembers(members);
    }

    public void addHobby(Hobbies hobbies) {
        Optional<Hobbies> hobbiesOptional = hobbiesRepository.findHobbiesByName(hobbies.getName());
        if (hobbiesOptional.isPresent()) {
            throw new IllegalStateException("Hobby already exists");
        }
        hobbiesRepository.save(hobbies);
    }

    public void updateHobbies(Long hobbiesId, String name, String description, String media) {
        Hobbies hobbies = hobbiesRepository.findById(hobbiesId).orElseThrow(()
        -> new IllegalStateException("Hobby Id " + hobbiesId + " doesn't exist"));

        if(name != null && !name.isEmpty() && !Objects.equals(hobbies.getName(), name)) {
            Optional <Hobbies> hobbiesOptional = hobbiesRepository.findHobbiesByName(name);
            if (hobbiesOptional.isPresent()) {
                throw new IllegalStateException(("Hobby " + name + " already exists"));
            }
            hobbies.setName(name);
        }

        if (description != null && !description.isEmpty()) {
            hobbies.setDescription(description);
        }

        if (media != null && !media.isEmpty()) {
            hobbies.setMedia(media);
        }

        hobbiesRepository.save(hobbies);
    }

    public void deleteHobbies(Long hobbiesId) {
        boolean exists = hobbiesRepository.existsById(hobbiesId);
        if (!exists) {
            throw new IllegalStateException("Hobby Id " + hobbiesId + " doesn't exist");
        }
        hobbiesRepository.deleteById(hobbiesId);
    }
}
