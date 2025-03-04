package dev.nathan.shortenerUrl.service.factory.impls;

import dev.nathan.shortenerUrl.model.Link;
import dev.nathan.shortenerUrl.service.components.QrCodeGenerator;
import dev.nathan.shortenerUrl.service.components.UrlShortener;
import dev.nathan.shortenerUrl.service.factory.LinkFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class LinkFactoryImpl implements LinkFactory {
    private final UrlShortener urlShortener;
    private final QrCodeGenerator qrCodeGenerator;

    public Link createLink(String originalUrl) {
        Link link = new Link();
        link.setOriginalUrl(originalUrl);
        link.setShortenedUrl(urlShortener.generateShortUrl());
        link.setQrCodeUrl(qrCodeGenerator.generateQrCode(originalUrl));
        link.setCreatedAt(LocalDateTime.now());
        return link;
    }
}