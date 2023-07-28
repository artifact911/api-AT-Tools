package org.art.spaceport;

import org.art.dynamic_fields.ValueField;

import java.util.List;

public record SpaceportItemResponse(String id,
                                    String name,
                                    Integer hoursToStart,
                                    String messageToStart,
                                    List<ValueField> content) {
}
