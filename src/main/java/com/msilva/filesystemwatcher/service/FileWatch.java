package com.msilva.filesystemwatcher.service;

import java.io.IOException;
import java.nio.file.WatchService;

public interface FileWatch {
    void createWatchService() throws IOException;
    void watchEvent(WatchService watchService) throws InterruptedException;
}
