package com.work.work.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.work.work.DTO.WorkCreateDTO;
import com.work.work.DTO.WorkResponseDTO;
import com.work.work.Entities.Work;
import com.work.work.Mappers.WorkMapper;
import com.work.work.Services.WorkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/works")
public class WorkController {
    private final WorkService workService;
    private final ObjectMapper objectMapper;

    @Autowired
    public WorkController(WorkService workService, ObjectMapper objectMapper) {
        this.workService = workService;
        this.objectMapper = objectMapper;
    }

    // GET: /
    // Returns all works
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll() {
        List<WorkResponseDTO> works = workService.findAll()
                .stream()
                .map(WorkMapper::toResponse)
                .toList();

        Map<String,Object> response = Map.of(
                "status", "success",
                "results", works.size(),
                "data", works
        );

        return ResponseEntity.ok(response);
    }

    // GET: /{id}
    // Returns work by id
    @GetMapping("/{id}")
    public ResponseEntity<WorkResponseDTO> getWork(@PathVariable Long id) {
        Optional<Work> result = Optional.ofNullable(workService.findById(id.intValue()));

        return result.map(work -> ResponseEntity.ok(WorkMapper.toResponse(work)))
                .orElse(ResponseEntity.notFound().build());
    }

    // GET: /sum/{workerName}
    // Returns sum of hours worked by worker name
    @GetMapping("/sum/{workerName}")
    public ResponseEntity<Integer> getHoursWorkedByName(@PathVariable("workerName") String workerName) {
        Optional<Integer> result = Optional.ofNullable(workService.findHoursWorkedByName(workerName));

        return result.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // POST: /
    // Creates new work
    @PostMapping
    public ResponseEntity<WorkResponseDTO> addWork(@Valid @RequestBody WorkCreateDTO workDTO) {
        Work work = workService.save(WorkMapper.toEntity(workDTO));

        return ResponseEntity.ok(WorkMapper.toResponse(work));
    }

    // PUT: /{id}
    // Updates work by id
    @PutMapping("/{id}")
    public ResponseEntity<WorkResponseDTO> updateWork(
            @PathVariable Long id,
            @Valid @RequestBody WorkCreateDTO workDTO)
    {
        Work work = workService.findById(id.intValue());
        if (work == null) {
            return ResponseEntity.notFound().build();
        }

        Work updatedWork = WorkMapper.toEntity(workDTO);
        updatedWork.setId(id);
        updatedWork.setCreatedAt(work.getCreatedAt());
        updatedWork.setLastUpdated(LocalDateTime.now());

        Work saved = workService.save(updatedWork);
        return ResponseEntity.ok(WorkMapper.toResponse(saved));
    }

    // DELETE: /{id}
    // Deletes work by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWork(@PathVariable Long id) {
        Work work = workService.findById(id.intValue());

        if (work == null) {
            return ResponseEntity.notFound().build();
        }

        workService.deleteById(id.intValue());

        return ResponseEntity.ok("Deleted work by id [id=" + id + "]");
    }
}
