package dev.christopherbell.azurras.services;

import dev.christopherbell.azurras.configs.ImageProperties;
import dev.christopherbell.azurras.models.AzurrasResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AzurrasService {
    private final Logger LOG = LoggerFactory.getLogger(AzurrasService.class);
    private final ImageProperties imageProperties;
    private final WFLService wflService;

    @Autowired
    public AzurrasService(ImageProperties imageProperties, WFLService wflService) {
        this.imageProperties = imageProperties;
        this.wflService = wflService;
    }


    public AzurrasResponse getPhotographyImageDetails() {
        LOG.info("INFO: AzurrasService: Getting all image links");
        return new AzurrasResponse(imageProperties.getImages(), null, String.valueOf(HttpStatus.OK));
    }
}