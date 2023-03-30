package fr.eql.ai113.petpal.spring.back.service.impl;

import fr.eql.ai113.petpal.spring.back.entity.Owner;
import fr.eql.ai113.petpal.spring.back.repository.OwnerDao;
import fr.eql.ai113.petpal.spring.back.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Configuration
public class UserServiceImpl implements UserService {

    /** Injecté par le setter */
    private OwnerDao ownerDao;
    /** Injecté par le setter */
    private AuthenticationManager authenticationManager;

    private final String signingKey;

    public UserServiceImpl(@Value("${jwt.signing.key}") String signingKey) {
        this.signingKey = signingKey;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(String username, String password) throws AuthenticationException {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authentication);
    }

    @Override
    public UserDetails save(String username, String password) throws AccountExistsException {
        if (ownerDao.findByLogin(username) != null) {
            throw new AccountExistsException();
        }
        Owner owner = new Owner();
        owner.setLogin(username);
        owner.setPassword(passwordEncoder().encode(password));
        ownerDao.save(owner);
        return owner;
    }

    @Override
    public String generateJwtForUser(UserDetails user) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 3600 * 1000);
        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, signingKey).compact();
    }

    @Override
    public UserDetails getUserFromJwt(String jwt) {
        String username = getUsernameFromToken(jwt);
        return loadUserByUsername(username);
    }

    private String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Owner owner = ownerDao.findByLogin(username);
        if (owner == null) {
            throw new UsernameNotFoundException("Le propriétaire n'a pas été trouvé.");
        }
        return owner;
    }

    /// Setters ///
    @Autowired
    public void setOwnerDao(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}
