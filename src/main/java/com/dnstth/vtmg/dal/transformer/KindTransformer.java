package com.dnstth.vtmg.dal.transformer;

import com.dnstth.vtmg.dal.dto.Kind;
import com.dnstth.vtmg.view.KindView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denes_Toth
 */
@Component
public class KindTransformer implements Transformer<Kind, KindView> {

    @Override
    public Kind viewToDto(KindView kindView) {
        Kind kind = new Kind();
        kind.setId(kindView.getId());
        kind.setDetails(kindView.getDetails());
        return kind;
    }

    @Override
    public List<Kind> viewsToDtos(List<KindView> kindViews) {
        return kindViews != null ?  kindViews.stream().map(kv -> viewToDto(kv)).collect(Collectors.toList()) : new ArrayList<>();
    }

    @Override
    public KindView dtoToView(Kind kind) {
        KindView kindView = new KindView();
        kindView.setId(kind.getId());
        kindView.setDetails(kind.getDetails());
        return kindView;
    }

    @Override
    public List<KindView> dtosToViews(List<Kind> kinds) {
        return kinds != null ? kinds.stream().map(k -> dtoToView(k)).collect(Collectors.toList()) : new ArrayList<>();
    }
}
