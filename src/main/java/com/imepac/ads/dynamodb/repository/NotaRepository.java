package com.imepac.ads.dynamodb.repository;

import com.imepac.ads.dynamodb.entities.NotasAlunosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.CreateTableEnhancedRequest;

import java.util.function.Consumer;

@Repository
public class NotaRepository {
    @Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public void save(NotasAlunosEntity notasAlunosEntity) {
        DynamoDbTable<NotasAlunosEntity> notaTable = dynamoDbEnhancedClient.table("NOTA", TableSchema.fromBean(NotasAlunosEntity.class));
        notaTable.putItem(notasAlunosEntity);
}

}
