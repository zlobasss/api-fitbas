package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.service.IGroupService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {

    @Autowired
    private final IGroupService groupService;

    @GetMapping
    public ResponseEntity<?> readAll() {
        return groupService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable String id) {
        return groupService.read(id);
    }
}
