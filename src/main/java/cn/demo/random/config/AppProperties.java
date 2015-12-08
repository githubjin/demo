package cn.demo.random.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Component
@ConfigurationProperties(prefix="app", ignoreUnknownFields = false)
public class AppProperties {
	
	private final Jwt jwt = new Jwt();
	private final Async async = new Async();
	private final Liquibase liquibase = new Liquibase();
	
	public Liquibase getLiquibase() {
		return liquibase;
	}
	public Jwt getJwt() {
		return jwt;
	}
	public Async getAsync() {
		return async;
	}
	
	public static class Liquibase {
		private String changeLog;

		public String getChangeLog() {
			return changeLog;
		}

		public void setChangeLog(String changeLog) {
			this.changeLog = changeLog;
		}
		
	}

	public static class Async {
		private int corePoolSize = 2;
		private int maxPoolSize = 50;
		private int queueCapacity = 10000;
		public int getCorePoolSize() {
			return corePoolSize;
		}
		public void setCorePoolSize(int corePoolSize) {
			this.corePoolSize = corePoolSize;
		}
		public int getMaxPoolSize() {
			return maxPoolSize;
		}
		public void setMaxPoolSize(int maxPoolSize) {
			this.maxPoolSize = maxPoolSize;
		}
		public int getQueueCapacity() {
			return queueCapacity;
		}
		public void setQueueCapacity(int queueCapacity) {
			this.queueCapacity = queueCapacity;
		}
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
