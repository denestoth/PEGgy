package com.dnstth.vtmg.dal.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dnstth.vtmg.dal.dto.Kind;
import com.dnstth.vtmg.view.KindView;
import org.springframework.stereotype.Component;

/**
 * Created by Denes_Toth
 */
@Component
public class KindTransformer implements Transformer<Kind, KindView> {

    @Override
    public Kind viewToDto(KindView kindView) {
        return Kind.builder()
                   .id(kindView.getId())
                   .details(kindView.getDetails())
                   .build();
    }

    @Override
    public List<Kind> viewsToDtos(List<KindView> kindViews) {
        return kindViews != null ? kindViews.stream().map(kv -> viewToDto(kv)).collect(Collectors.toList()) : new ArrayList<>();
    }

    @Override
    public KindView dtoToView(Kind kind) {
        return KindView.builder()
                   .id(kind.getId())
                   .details(kind.getDetails())
                   .build();
    }

    @Override
    public List<KindView> dtosToViews(List<Kind> kinds) {
        return kinds != null ? kinds.stream().map(k -> dtoToView(k)).collect(Collectors.toList()) : new ArrayList<>();
    }
}
