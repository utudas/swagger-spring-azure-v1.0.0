package io.swagger.security;

public class SecurityConstants {
	public static final String SECRET = "SecretKeyToGenJWTs";
    //public static final long EXPIRATION_TIME = 30_000; // 30 seconds
	public static final long EXPIRATION_TIME = 300000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
}
