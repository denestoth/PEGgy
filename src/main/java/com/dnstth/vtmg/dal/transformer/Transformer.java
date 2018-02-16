package com.dnstth.vtmg.dal.transformer;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface Transformer<DTO, VIEW> {
    DTO viewToDto(VIEW view);

    List<DTO> viewsToDtos(List<VIEW> views);

    VIEW dtoToView(DTO dto);

    List<VIEW> dtosToViews(List<DTO> dtos);

}
