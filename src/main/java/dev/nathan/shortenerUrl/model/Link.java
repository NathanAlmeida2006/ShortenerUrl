package dev.nathan.shortenerUrl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Represents a shortened link.
 */
@Data
@Entity
@Table(name = "links")
public class Link {

    // Unique identifier for the link
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Original long URL
    private String originalUrl;

    // Shortened URL
    private String shortenedUrl;

    // URL for the QR Code
    private String qrCodeUrl;

    // Timestamp when the URL was created
    private LocalDateTime createdAt;
}
