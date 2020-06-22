package com.msilva.filesystemwatcher.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;


@Service
public class FileWatchService implements FileWatch{

    public void createWatchService(){
        WatchService watchService = null;

        {
            try {
                watchService = FileSystems.getDefault().newWatchService();
                Path path = Paths.get("/home/msilvadev/Documents/filesystemwatcher");
                path.register(watchService,
                        ENTRY_CREATE,
                        ENTRY_MODIFY);
                watchEvent(watchService);
            } catch (IOException e) {
                //TODO create log
                e.printStackTrace();
            }
        }
    }

    public void watchEvent(WatchService watchService) {
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
