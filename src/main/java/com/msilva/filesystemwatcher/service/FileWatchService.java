package com.msilva.filesystemwatcher.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;

@Service
public class FileWatchService {
    @Value("${path.file}")
    private String pathFile;

    WatchService watchService;
    {
        try {
            watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get("/home/msilvadev/Documents/filesystemwatcher");
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            watchEvent();
        } catch (IOException e) {
            //TODO create log
            e.printStackTrace();
        }
    }

    private void watchEvent() {
        WatchKey key;
        while (true) {
            try {
                if (!((key = watchService.take()) != null)) break;
                for (WatchEvent<?> event : key.pollEvents()) {
                    //TODO create log
                    System.out.println(
                            "Event kind:" + event.kind()
                                    + ". File affected: " + event.context() + ".");
                }
                key.reset();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
