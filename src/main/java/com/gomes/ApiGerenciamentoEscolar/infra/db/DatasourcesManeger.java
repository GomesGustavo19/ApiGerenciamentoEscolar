package com.gomes.ApiGerenciamentoEscolar.infra.db;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class DatasourcesManeger {

    private final DataSource dataSource;

    public DatasourcesManeger(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PreDestroy
    public void shutDownPool(){
        System.out.println("Encerrando o pool de conexões....");
        try{
            if (dataSource != null){
                dataSource.unwrap(javax.sql.DataSource.class).getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a coneções: ", e.getCause());
        }
    }
}
