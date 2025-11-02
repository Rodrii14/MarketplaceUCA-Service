package com.marketplace.backend.services.impl;

import com.marketplace.backend.domain.entities.Token;
import com.marketplace.backend.domain.entities.User;
import com.marketplace.backend.repositories.iTokenRepository;
import com.marketplace.backend.services.iTokenServices;
import com.marketplace.backend.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServicesImpl implements iTokenServices {

    private final TokenUtils tokenUtils;
    private final iTokenRepository TokenRepository;

    @Override
    public Token generateToken(User user) {
        Token token = new Token();
        token.setToken(tokenUtils.generateToken(user));
        token.setExpiresIn(tokenUtils.getExpiresIn());

        user.addToken(token);
        TokenRepository.save(token);
        return token;
    }
}
