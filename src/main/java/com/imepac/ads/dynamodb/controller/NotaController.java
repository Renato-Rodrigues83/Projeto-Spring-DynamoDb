package com.imepac.ads.dynamodb.controller;

import com.imepac.ads.dynamodb.DTO.NotaDTO;
import com.imepac.ads.dynamodb.entities.NotasAlunosEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("v1/notas")
public class NotaController {
    private DynamoDbTemplate dynamoDbTemplate;

    public NotaController(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    @PostMapping("/{matricula}/{idDisciplina}")
    public ResponseEntity<Void> salvar(
            @PathVariable("matricula") String matricula,
            @PathVariable("idDisciplina") String idDisciplina,
            @RequestBody NotaDTO notaDTO
    ) {

        NotasAlunosEntity nota = NotasAlunosEntity.fromNotaDTO(matricula, idDisciplina, notaDTO);

        dynamoDbTemplate.save(nota);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<List<NotasAlunosEntity>> buscarNotasPorAluno(@PathVariable("matricula") String matricula) {
        Key key = Key.builder()
                .partitionValue(matricula)
                .sortValue("NOTA#")
                .build();

        QueryConditional notas = QueryConditional.sortBeginsWith(key);

        QueryEnhancedRequest query = QueryEnhancedRequest
                .builder()
                .queryConditional(notas)
                .build();

        try {
            PageIterable<NotasAlunosEntity> nota = dynamoDbTemplate.query(query, NotasAlunosEntity.class);

            List<NotasAlunosEntity> notaList = nota.items().stream().toList();

            return ResponseEntity.ok(notaList);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
