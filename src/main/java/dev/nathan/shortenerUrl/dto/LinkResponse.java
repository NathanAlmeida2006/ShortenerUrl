package dev.nathan.shortenerUrl.dto;

import java.time.LocalDateTime;

public record LinkResponse(long id, String originalUrl, String shortenedUrl, String qrCodeUrl,
                           LocalDateTime createdAt) {

    public LinkResponse withBaseUrl(String baseUrl) {
        return new LinkResponse(this.id, this.originalUrl, baseUrl + this.shortenedUrl, this.qrCodeUrl, this.createdAt);
    }
}