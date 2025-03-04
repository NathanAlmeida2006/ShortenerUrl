package dev.nathan.shortenerUrl.service;

import dev.nathan.shortenerUrl.dto.LinkRequest;
import dev.nathan.shortenerUrl.dto.LinkResponse;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface LinkService {
    LinkResponse createShortLink(LinkRequest request, String host);

    LinkResponse getLinkDetails(String shortenedUrl, String host);

    void redirectToOriginalUrl(String shortenedUrl, HttpServletResponse response) throws IOException;
}