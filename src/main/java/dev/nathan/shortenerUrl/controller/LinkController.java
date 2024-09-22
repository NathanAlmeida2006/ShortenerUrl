package dev.nathan.shortenerUrl.controller;

import dev.nathan.shortenerUrl.dto.LinkResponse;
import dev.nathan.shortenerUrl.service.LinkService;
import dev.nathan.shortenerUrl.model.Link;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 * REST controller for managing shortened links.
 */
@AllArgsConstructor
@RestController
public class LinkController {

    private final LinkService linkService;

    /**
     * Generates a shortened URL from an original URL.
     *
     * @param request Map containing the original URL.
     * @return ResponseEntity containing the shortened URL response.
     */
    @PostMapping("/shortenURL")
    public ResponseEntity<LinkResponse> generateShortenedUrl(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("originalUrl");
        if (originalUrl == null || originalUrl.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Link link = linkService.shortenUrl(originalUrl);
        String userRedirectUrl = "http://localhost:8080/r/" + link.getShortenedUrl();

        LinkResponse response = new LinkResponse(link.getId(), link.getOriginalUrl(), userRedirectUrl, link.getQrCodeUrl(), link.getCreatedAt());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Redirects to the original URL from a shortened URL.
     *
     * @param shortenedUrl The shortened URL.
     * @param response     HttpServletResponse for the redirection.
     * @throws IOException if an I/O error occurs.
     */
    @GetMapping("/r/{shortenedUrl}")
    public void redirectLink(@PathVariable String shortenedUrl, HttpServletResponse response) throws IOException {
        Link link = linkService.getOriginalUrl(shortenedUrl);
        if (link != null) {
            response.sendRedirect(link.getOriginalUrl());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
