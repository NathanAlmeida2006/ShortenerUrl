package dev.nathan.shortenerUrl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Response containing information about the shortened link.
 */
@AllArgsConstructor
@Data
public class LinkResponse {
    private long id;
    private String originalUrl;
    private String shortenedUrl;
    private String qrCodeUrl;
    private LocalDateTime createdAt;
}
