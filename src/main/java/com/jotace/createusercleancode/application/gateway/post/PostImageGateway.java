package com.jotace.createusercleancode.application.gateway.post;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;

public interface PostImageGateway {

    Blob setImage(Long id, SerialBlob image);

}
