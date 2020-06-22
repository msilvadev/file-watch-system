package com.msilva.filesystemwatcher.configuration;

import com.msilva.filesystemwatcher.service.FileWatchService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileWatchConfiguration {

    @Bean
    public void configurationFileWatchService(){
        FileWatchService fileWatchService = new FileWatchService();
        fileWatchService.createWatchService();
    }
}
