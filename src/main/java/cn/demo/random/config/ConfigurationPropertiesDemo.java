package cn.demo.random.config;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="app.mail")
public class ConfigurationPropertiesDemo {
	
	@NotEmpty
	private String server;

	public ConfigurationPropertiesDemo() {
		super();
	}

	public ConfigurationPropertiesDemo(String server) {
		super();
		this.server = server;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
	
}
