package dev.nathan.shortenerUrl.service.impls;

import dev.nathan.shortenerUrl.converter.LinkConverter;
import dev.nathan.shortenerUrl.dto.LinkRequest;
import dev.nathan.shortenerUrl.dto.LinkResponse;
import dev.nathan.shortenerUrl.model.Link;
import dev.nathan.shortenerUrl.service.LinkService;
import dev.nathan.shortenerUrl.service.factory.LinkFactory;
import dev.nathan.shortenerUrl.repository.LinkRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;

@Service
@Validated
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;
    private final LinkConverter linkConverter;
    private final LinkFactory linkFactory;

    @Override
    public LinkResponse createShortLink(LinkRequest request, String host) {
        Link link = linkFactory.createLink(request.originalUrl());
        linkRepository.save(link);
        return buildLinkResponse(link, host);
    }

    @Override
    public LinkResponse getLinkDetails(String shortenedUrl, String host) {
        Link link = findLinkByShortenedUrl(shortenedUrl);
        return buildLinkResponse(link, host);
    }

    @Override
    public void redirectToOriginalUrl(String shortenedUrl, HttpServletResponse response) throws IOException {
        Link link = findLinkByShortenedUrl(shortenedUrl);
        response.sendRedirect(link.getOriginalUrl());
    }

    private Link findLinkByShortenedUrl(String shortenedUrl) {
        return linkRepository.findByShortenedUrl(shortenedUrl);
    }

    private LinkResponse buildLinkResponse(Link link, String host) {
        String baseUrl = buildBaseUrl(host);
        return linkConverter.toDtoWithBaseUrl(link, baseUrl);
    }

    private String buildBaseUrl(String host) {
        return "http://" + host + "/r/";
    }
}