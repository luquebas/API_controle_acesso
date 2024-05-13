package com.api_controle_acesso.services;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${api.security.token.secret}")
    private String secret;
    
    private static final String HMAC_ALGORITHM = "HmacSHA256";

    public String generateVerificationCode(String email) {
        try {
            return signToken(email).substring(0, 6);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean verifyVerificationCode(String email, String token) {
        try {
            var verify = signToken(email).substring(0, 6);
            
            return verify.equals(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String generateResetToken(String email) {
        try {
            String token = UUID.randomUUID().toString();
            return signToken(token);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isValidResetToken(String email, String token) {
        try {
            String signedToken = signToken(token);
            return signedToken.equals(token);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void resetPassword(String email, String token, String newPassword) {
        if (isValidResetToken(email, token)) {
            var usuario = usuarioService.findUsuarioByEmail(jwtService.getSubject(token));
            usuario.setSenha(passwordEncoder.encode(newPassword));
        } 
    }

    private String signToken(String token) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac hmac = Mac.getInstance(HMAC_ALGORITHM);
        
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM);
        hmac.init(secretKeySpec);
    
        byte[] signature = hmac.doFinal(token.getBytes(StandardCharsets.UTF_8));
        
        return Base64.getEncoder().encodeToString(signature);
    }
}
