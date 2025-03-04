package dev.nathan.shortenerUrl.converter;

import dev.nathan.shortenerUrl.dto.LinkResponse;
import dev.nathan.shortenerUrl.model.Link;

public interface LinkConverter {
    LinkResponse toDto(Link link);

    LinkResponse toDtoWithBaseUrl(Link link, String baseUrl);
}
