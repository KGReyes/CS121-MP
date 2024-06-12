package com.example.CS121_MP.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/member")
public class MembersController {

    private final MembersService membersService;

    @Autowired
    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @GetMapping
    public List<Members> getMembers() {
        return membersService.getMembers();
    }

    @GetMapping(path = "/{memberId}")
    public Members getMemberById (@PathVariable Long memberId) {
        Members member = membersService.getMemberById(memberId);
        return ResponseEntity.ok(member).getBody();
    }

    @PostMapping
    public void registerNewMember(@RequestBody Members member) {
        membersService.addNewMember(member);
    }

    @DeleteMapping(path = "{memberId}")
    public void deleteMember(@PathVariable ("memberId") Long memberId) {
        membersService.deleteMember(memberId);
    }

    @PutMapping(path = "{memberId}")
    public void updateMember(@PathVariable("memberId") Long memberId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String username,
                             @RequestParam(required = false) LocalDate dob) {
        membersService.updateMembers(memberId, name, username, dob);
    }

}
