package com.dnstth.vtmg.transformer;

import com.dnstth.vtmg.dal.dto.Kind;
import com.dnstth.vtmg.view.KindView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denes_Toth
 */
@Component
public class KindTransformer implements Transformer<Kind,KindView> {

    @Override
    public Kind viewToDto(KindView kindView) {
        Kind kind = new Kind();
        kind.setId(kindView.getId());
        kind.setDetails(kindView.getDetails());
        return kind;
    }

    @Override
    public List<Kind> viewsToDtos(List<KindView> kindViews) {
        List<Kind> kinds = new ArrayList<Kind>();

        for(KindView kindView : kindViews) {
            kinds.add(viewToDto(kindView));
        }

        return kinds;
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
        List<KindView> kindViews = new ArrayList<KindView>();

        for (Kind kind : kinds) {
            kindViews.add(dtoToView(kind));
        }

        return kindViews;
    }
}
