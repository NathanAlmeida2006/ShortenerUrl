package dev.nathan.shortenerUrl.converter.impls;

import dev.nathan.shortenerUrl.converter.LinkConverter;
import dev.nathan.shortenerUrl.dto.LinkResponse;
import dev.nathan.shortenerUrl.model.Link;
import org.springframework.stereotype.Component;

@Component
public class LinkConverterImpl implements LinkConverter {
    @Override
    public LinkResponse toDto(Link link) {
        return new LinkResponse(
                link.getId(),
                link.getOriginalUrl(),
                link.getShortenedUrl(),
                link.getQrCodeUrl(),
                link.getCreatedAt()
        );
    }

    @Override
    public LinkResponse toDtoWithBaseUrl(Link link, String baseUrl) {
        return new LinkResponse(
                link.getId(),
                link.getOriginalUrl(),
                baseUrl + link.getShortenedUrl(),
                link.getQrCodeUrl(),
                link.getCreatedAt()
        );
    }
}