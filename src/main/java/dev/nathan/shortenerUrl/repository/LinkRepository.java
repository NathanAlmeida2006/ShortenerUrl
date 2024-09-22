package dev.nathan.shortenerUrl.repository;

import dev.nathan.shortenerUrl.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for the Link entity.
 */
public interface LinkRepository extends JpaRepository<Link, Long> {
    /**
     * Finds a link by the shortened URL.
     *
     * @param shortenedUrl The shortened URL.
     * @return The corresponding Link.
     */
    Link findByShortenedUrl(String shortenedUrl);
}
