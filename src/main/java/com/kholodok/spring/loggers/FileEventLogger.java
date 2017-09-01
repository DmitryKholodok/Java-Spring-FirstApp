package com.kholodok.spring.loggers;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.events.Event;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(com.kholodok.spring.beans.Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {

        this.file = new File(fileName);

        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + fileName);
        } else if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception ex) {
                throw new IllegalArgumentException("Can't create file ", ex);
            }
        }
    }
}
