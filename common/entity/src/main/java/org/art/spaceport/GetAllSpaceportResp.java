package org.art.spaceport;

import org.art.dynamic_fields.DynamicFieldGetter;
import org.art.dynamic_fields.ValueField;

import java.util.List;
import java.util.NoSuchElementException;

public record GetAllSpaceportResp(List<SpaceportItemResponse> spaceportList) implements DynamicFieldGetter {

    @Override
    public List<ValueField> getValueField() {
        return getFirstTab().content();
    }

    public SpaceportItemResponse getFirstTab() {
        return spaceportList.stream().findFirst().orElseThrow(() -> new NoSuchElementException("There is no tab"));
    }
}
