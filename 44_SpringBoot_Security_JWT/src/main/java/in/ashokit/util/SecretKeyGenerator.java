package in.ashokit.util;

import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Base64;
//for JWT we need salt(secret key ) this program is to create secret key and add that in application.properties file
//ex:  app.secret=Ev7QI5mVNKCb4hizqRpLLosf2OJRNJ9ts9GPKBSKtBU=
public class SecretKeyGenerator {
    public static void main(String[] args) {
        // Generate a secure 256-bit key for HS256
        Key key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
        
        // Convert the key to a Base64-encoded string
        String secretKey = Base64.getEncoder().encodeToString(key.getEncoded());
        
        System.out.println("Generated Secret Key: " + secretKey);
    }
}

