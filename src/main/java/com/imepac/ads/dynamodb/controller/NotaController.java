package com.imepac.ads.dynamodb.controller;

//import com.imepac.ads.dynamodb.DTO.NotaDTO;
import com.imepac.ads.dynamodb.entities.NotasAlunosEntity;
import com.imepac.ads.dynamodb.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//import io.awspring.cloud.dynamodb.DynamoDbTemplate;
//import software.amazon.awssdk.enhanced.dynamodb.Key;
//import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
//import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
//import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

//import java.util.List;

//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("v1/notas")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    @PostMapping
    public String createPessoa (@RequestBody NotasAlunosEntity notasAlunosEntity) {
        notaRepository.save(notasAlunosEntity);
        return "Nota salva com sucesso";
    }
}
