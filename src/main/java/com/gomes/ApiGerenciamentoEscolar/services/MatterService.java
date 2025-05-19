package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.RequestCreateMatter;
import com.gomes.ApiGerenciamentoEscolar.repository.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatterService {

    @Autowired
    private MatterRepository matterRepository;

    @Transactional
    public ResponseEntity<Matter> create(RequestCreateMatter requestCreateMatter){

        Matter matter = new Matter();
        matter.setIdMatter(requestCreateMatter.name());

        matterRepository.save(matter);

        return ResponseEntity.ok().build();

    }


}
