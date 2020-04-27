package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import guru.springframework.examplebean.FakeDataSource;
import guru.springframework.examplebean.FakeJmsBroker;

@Configuration
public class PropertyConfig {
	
	@Autowired
	Environment env;

	@Value("${guru.username}")
	String user;
	
	@Value("${guru.password}")
	String password;
	
	@Value("${guru.dburl}")
	String url;
	
	@Value("${guru.jms.username}")
	String jmsuser;
	
	@Value("${guru.jms.password}")
	String jmspassword;
	
	@Value("${guru.jms.dburl}")
	String jmsurl;
	
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(user);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}
	
	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUser(jmsuser);
		fakeJmsBroker.setPassword(jmspassword);
		fakeJmsBroker.setUrl(jmsurl);
		return fakeJmsBroker;
	}
}
