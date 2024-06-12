package com.example.CS121_MP.hobbies;

import com.example.CS121_MP.members.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HobbiesRepository extends JpaRepository<Hobbies, Long> {
    @Query("SELECT h FROM Hobbies  h WHERE h.name LIKE CONCAT('%', :name, '%')")
    Optional<Hobbies> findHobbiesByName(String name);
    List<Hobbies> findHobbiesByMembers(Members member);
}
