package com.caiolima.apientrega.api.serializer;

import com.caiolima.apientrega.api.model.EntregaDTO;
import com.caiolima.apientrega.api.model.InputEntregaDTO;
import com.caiolima.apientrega.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EntregaSerializer {

    private ModelMapper mapper;

    public EntregaDTO toDto (Entrega entrega){
        return mapper.map(entrega, EntregaDTO.class);
    }

    public Entrega toModel(InputEntregaDTO inputEntregaDTO){
        return mapper.map(inputEntregaDTO, Entrega.class);
    }
}
