package in.er.annamalai.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@ActiveProfiles("dev")
class PortfolioApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	void contextLoads() {
		Assert.notNull(restTemplate, "RestTemplate bean should not be null");
	}

}
