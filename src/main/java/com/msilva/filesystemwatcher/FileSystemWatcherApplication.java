package com.msilva.filesystemwatcher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.yml")
@SpringBootApplication
public class FileSystemWatcherApplication {

    @Value("${matheus.file}")
    private static String pathFile;

    public static void main(String[] args) {
        SpringApplication.run(FileSystemWatcherApplication.class, args);
    }

}
