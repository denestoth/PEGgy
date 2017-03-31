package com.dnstth.vtmg.transformer;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface Transformer<DTO,VIEW> {

    public DTO viewToDto(VIEW view);

    public List<DTO> viewsToDtos(List<VIEW> views);

    public VIEW dtoToView(DTO dto);

    public List<VIEW> dtosToViews(List<DTO> dtos);

}
