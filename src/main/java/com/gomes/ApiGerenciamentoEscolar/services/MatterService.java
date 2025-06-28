package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.RequestCreateMatter;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.RequestFindByMatter;
import com.gomes.ApiGerenciamentoEscolar.repository.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MatterService {

    @Autowired
    private MatterRepository matterRepository;

    public Matter create(RequestCreateMatter requestCreateMatter){

        Matter matter = new Matter();
        matter.setName(requestCreateMatter.name());

        matterRepository.save(matter);

        return matter;

    }

    @Transactional
    public Matter update(RequestFindByMatter requestMatter ){

        Optional<Matter> existing = matterRepository.findById(requestMatter.id());

        if (existing.isPresent()){
            Matter getOptional = existing.get();

            getOptional.setName(requestMatter.name());

            matterRepository.save(getOptional);

            return getOptional;
        }else {
            throw new RuntimeException("Matter not found");
        }

    }


}
