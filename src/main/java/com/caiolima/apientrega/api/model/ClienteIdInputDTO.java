package com.caiolima.apientrega.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteIdInputDTO {

    @NotNull
    private Long id;
}
