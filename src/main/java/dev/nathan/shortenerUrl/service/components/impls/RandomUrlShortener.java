package dev.nathan.shortenerUrl.service.components.impls;

import dev.nathan.shortenerUrl.service.components.UrlShortener;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component("randomUrlShortener")
public class RandomUrlShortener implements UrlShortener {
    @Override
    public String generateShortUrl() {
        return RandomStringUtils.randomAlphabetic(5, 10);
    }
}
