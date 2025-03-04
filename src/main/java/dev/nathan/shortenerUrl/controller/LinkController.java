package dev.nathan.shortenerUrl.controller;

import dev.nathan.shortenerUrl.dto.LinkRequest;
import dev.nathan.shortenerUrl.dto.LinkResponse;
import dev.nathan.shortenerUrl.service.LinkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v2/links")
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping
    public ResponseEntity<LinkResponse> createShortLink(
            @Valid @RequestBody LinkRequest request,
            @RequestHeader(name = "Host") String host) {

        LinkResponse response = linkService.createShortLink(request, host);
        return ResponseEntity
                .created(URI.create(response.shortenedUrl()))
                .body(response);
    }

    @GetMapping("/{shortenedUrl}")
    public ResponseEntity<LinkResponse> getLinkDetails(
            @PathVariable String shortenedUrl,
            @RequestHeader(name = "Host") String host) {

        LinkResponse response = linkService.getLinkDetails(shortenedUrl, host);
        return ResponseEntity.ok(response);
    }
}