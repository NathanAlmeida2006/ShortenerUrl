package dev.nathan.shortenerUrl.service;

import dev.nathan.shortenerUrl.model.Link;
import dev.nathan.shortenerUrl.repository.LinkRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Service for managing shortened links.
 */
@Data
@AllArgsConstructor
@Service
public class LinkService {

    private final LinkRepository linkRepository;

    /**
     * Generates a random URL string.
     *
     * @return A random URL string.
     */
    public String generateRandomUrl() {
        return RandomStringUtils.randomAlphabetic(5, 10);
    }

    /**
     * Shortens an original URL.
     *
     * @param originalUrl The original URL.
     * @return The shortened Link.
     */
    public Link shortenUrl(String originalUrl) {
        Link link = new Link();
        link.setOriginalUrl(originalUrl);
        link.setShortenedUrl(generateRandomUrl());
        link.setCreatedAt(LocalDateTime.now());
        link.setQrCodeUrl("QR unavailable!");

        return linkRepository.save(link);
    }

    /**
     * Retrieves the original URL from a shortened URL.
     *
     * @param shortenedUrl The shortened URL.
     * @return The corresponding Link.
     */
    public Link getOriginalUrl(String shortenedUrl) {
        try {
            return linkRepository.findByShortenedUrl(shortenedUrl);
        } catch (Exception e) {
            throw new RuntimeException("URL does not exist" + e);
        }
    }
}
