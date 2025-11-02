package com.marketplace.backend.services;

import com.marketplace.backend.domain.entities.Token;
import com.marketplace.backend.domain.entities.User;

public interface iTokenServices {

    Token generateToken(User user);
}
