package com.example.CS121_MP.members;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long> {
    @Query("SELECT m FROM Members m WHERE m.username = ?1")
    Optional<Members> findMembersByUsername (String username);


}
