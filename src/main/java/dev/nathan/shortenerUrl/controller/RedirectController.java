package dev.nathan.shortenerUrl.controller;

import dev.nathan.shortenerUrl.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class RedirectController {

    private final LinkService linkService;

    @GetMapping("/r/{shortenedUrl}")
    public void redirectToOriginalUrl(
            @PathVariable String shortenedUrl,
            HttpServletResponse response) throws IOException {

        linkService.redirectToOriginalUrl(shortenedUrl, response);
    }
}