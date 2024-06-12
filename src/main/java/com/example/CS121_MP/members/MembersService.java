package com.example.CS121_MP.members;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MembersService {

    private final MembersRepository membersRepository;

    @Autowired
    public MembersService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    public List<Members> getMembers() {
        return membersRepository.findAll();
    }

    public Members getMemberById(Long memberId) {
        return membersRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("ID " + memberId + " doesn't exist"));
    }

    public void addNewMember(Members member) {
        Optional<Members> memberOptional = membersRepository.findMembersByUsername(member.getUsername());
        if (memberOptional.isPresent()) {
            throw new IllegalStateException("Username Taken");
        }
        membersRepository.save(member);
    }

    public void deleteMember(Long memberId) {
        boolean exists = membersRepository.existsById(memberId);
        if (!exists) {
            throw new IllegalStateException("Member " + memberId + " doesn't exist");
        }
        membersRepository.deleteById(memberId);
    }

    @Transactional
    public void updateMembers(Long memberId, String name, String username, LocalDate dob) {
        Members members = membersRepository.findById(memberId).orElseThrow(()
        -> new IllegalStateException("Member " + memberId + " doesn't exist"));

        if (username != null && !username.isEmpty() && !Objects.equals(members.getUsername(), username)) {
            Optional<Members> membersOptional = membersRepository.findMembersByUsername(username);
            if (membersOptional.isPresent()) {
                throw new IllegalStateException("Username Taken");
            }
            members.setUsername(username);
        }

        if (name != null && !name.isEmpty() && !Objects.equals(members.getName(), name)) {
            members.setName(name);
        }
        //members.setDob(dob);
    }
}
