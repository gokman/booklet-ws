package com.fagose.booklet.service;

import com.fagose.booklet.model.PasswordReset;

public interface PasswordResetService {

        public void addPasswordReset(PasswordReset passwordReset);
        public void deletePasswordReset(PasswordReset passwordReset);
}

