package com.jotace.createusercleancode.core.model.mapper;

import java.sql.Blob;
import java.sql.SQLException;

public class ImageMapper {
    public byte[] blobToByte(Blob image) throws SQLException {
        if(image != null) {
            return image.getBytes(1, (int) image.length());
        }
        return null;
    }
}
