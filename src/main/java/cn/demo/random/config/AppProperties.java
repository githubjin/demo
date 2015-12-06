package cn.demo.random.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="app")
public class AppProperties {
	
	private final Jwt jwt = new Jwt();
	
	public Jwt getJwt() {
		return jwt;
	}

	public static class Jwt{
		
		private String hmacKey;
		private String tokenValidityInSeconds = "1800";
		private String issuer;

		public String getHmacKey() {
			return hmacKey;
		}

		public void setHmacKey(String hmacKey) {
			this.hmacKey = hmacKey;
		}

		public String getTokenValidityInSeconds() {
			return tokenValidityInSeconds;
		}

		public void setTokenValidityInSeconds(String tokenValidityInSeconds) {
			this.tokenValidityInSeconds = tokenValidityInSeconds;
		}

		public String getIssuer() {
			return issuer;
		}

		public void setIssuer(String issuer) {
			this.issuer = issuer;
		}
	}
	
	
	
}
