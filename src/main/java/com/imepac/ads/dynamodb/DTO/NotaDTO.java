package com.imepac.ads.dynamodb.DTO;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public record NotaDTO(double nota, String disciplina, String professor) {
}
