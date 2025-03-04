package dev.nathan.shortenerUrl.service.components.impls;

import dev.nathan.shortenerUrl.service.components.QrCodeGenerator;
import org.springframework.stereotype.Component;

@Component
public class DefaultQrCodeGenerator implements QrCodeGenerator {
    @Override
    public String generateQrCode(String url) {

        return "QR unavailable!";
    }
}