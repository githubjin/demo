package cn.demo.random.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Component
@ConfigurationProperties(prefix="app", ignoreUnknownFields = false)
public class AppProperties {
	
	private final Jwt jwt = new Jwt();
	private final Async async = new Async();
	private final Liquibase liquibase = new Liquibase();
	private final Datasource datasource = new Datasource();
	private final Metrics metrics = new Metrics();
	private final Mail mail = new Mail();
	
	public Metrics getMetrics() {
		return metrics;
	}
	public Liquibase getLiquibase() {
		return liquibase;
	}
	public Jwt getJwt() {
		return jwt;
	}
	public Async getAsync() {
		return async;
	}
	
	public Datasource getDatasource() {
		return datasource;
	}
	
	public Mail getMail() {
		return mail;
	}

	public static class Mail {
		
		private String from;
		private String personal;
		
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getPersonal() {
			return personal;
		}
		public void setPersonal(String personal) {
			this.personal = personal;
		}
	}
	
	public static class Metrics {
		private final Jmx jmx = new Jmx();
		private final Graphite graphite = new Graphite();
		public Jmx getJmx() {
			return jmx;
		}
		public Graphite getGraphite() {
			return graphite;
		}
		public static class Graphite {
			
			private boolean enabled;
			private String host;
			private int port;
			private String prefix;
			
			public boolean isEnabled() {
				return enabled;
			}
			public void setEnabled(boolean enabled) {
				this.enabled = enabled;
			}
			public String getHost() {
				return host;
			}
			public void setHost(String host) {
				this.host = host;
			}
			public int getPort() {
				return port;
			}
			public void setPort(int port) {
				this.port = port;
			}
			public String getPrefix() {
				return prefix;
			}
			public void setPrefix(String prefix) {
				this.prefix = prefix;
			}
			
			
		}
		public static class Jmx {
			private boolean enabled = true;
			public boolean isEnabled() {
				return enabled;
			}
			public void setEnabled(boolean enabled) {
				this.enabled = enabled;
			}
		}
	}

	public static class Datasource {
		
		private String serverName;
		private boolean cachePrepStmts;
		private int preStmtCacheSize;
		private int preStmtCacheSqlLimit;
		private boolean useServerPrepStmts;
		
		public String getServerName() {
			return serverName;
		}
		public void setServerName(String serverName) {
			this.serverName = serverName;
		}
		public boolean isCachePrepStmts() {
			return cachePrepStmts;
		}
		public void setCachePrepStmts(boolean cachePrepStmts) {
			this.cachePrepStmts = cachePrepStmts;
		}
		public int getPreStmtCacheSize() {
			return preStmtCacheSize;
		}
		public void setPreStmtCacheSize(int preStmtCacheSize) {
			this.preStmtCacheSize = preStmtCacheSize;
		}
		public int getPreStmtCacheSqlLimit() {
			return preStmtCacheSqlLimit;
		}
		public void setPreStmtCacheSqlLimit(int preStmtCacheSqlLimit) {
			this.preStmtCacheSqlLimit = preStmtCacheSqlLimit;
		}
		public boolean isUseServerPrepStmts() {
			return useServerPrepStmts;
		}
		public void setUseServerPrepStmts(boolean useServerPrepStmts) {
			this.useServerPrepStmts = useServerPrepStmts;
		}
		
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
