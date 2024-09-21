package com.imepac.ads.dynamodb.entities;

import com.imepac.ads.dynamodb.DTO.NotaDTO;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;


@DynamoDbBean
public class NotasAlunosEntity {

    private String pk;
    private String sk;
    private String nomeAluno;
    private String dataNascimento;
    private String nota;
    private String dataLancamento;
    private String nomeDisciplina;
    private String nomeProfessor;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("PK")
    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("SK")
    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    static public NotasAlunosEntity fromNotaDTO(String matricula, String idDisciplina, NotaDTO notaDTO) {
        NotasAlunosEntity nota = new NotasAlunosEntity();
        nota.setPk("ALUNO#" + matricula);
        nota.setSk("NOTA#" + idDisciplina);
        nota.setNomeAluno("Aluno");
        nota.setDataNascimento("01/01/2000");
        nota.setNota(String.valueOf(notaDTO.getNota()));
        nota.setDataLancamento("01/01/2021");
        nota.setNomeDisciplina(notaDTO.getDisciplina());
        nota.setNomeProfessor(notaDTO.getProfessor());
        return nota;
    }
}
