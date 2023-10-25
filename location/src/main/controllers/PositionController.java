package com.example.location.controllers;


import com.example.location.entities.Position;
import com.example.location.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/position")
public class PositionController {


    private PositionService positionService;


    @Autowired
    public PositionController(PositionService positionService){
        this.positionService=positionService;
    }



    @PostMapping("/add")
    public ResponseEntity<String> addPosition(@RequestBody Position position) {
        this.positionService.addPosition(position);

        String message = "{\"message\": \"Student deleted Successfully\"}"; // Customize your message

        return ResponseEntity.ok(message);
    }

    @GetMapping(value = "/positions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<Position>>> showPositions() {
        List<Position> positions =positionService.getAll();

        Map<String, List<Position>> response = new HashMap<>();
        response.put("positions", positions);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
