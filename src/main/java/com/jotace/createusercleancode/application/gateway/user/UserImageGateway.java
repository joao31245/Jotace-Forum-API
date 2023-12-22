package com.jotace.createusercleancode.application.gateway.user;

import com.jotace.createusercleancode.core.entity.user.User;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;

public interface UserImageGateway {
    Blob setImage(Long id, SerialBlob image);
}
