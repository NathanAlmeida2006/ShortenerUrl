package dev.nathan.shortenerUrl.service.factory;

import dev.nathan.shortenerUrl.model.Link;

public interface LinkFactory {
    Link createLink(String originalUrl);
}
