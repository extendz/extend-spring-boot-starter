package club.extendz.spring.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "dev")
public class ExtendzSpringBootExampleApplicationTests {

	@Test
	public void contextLoads() {
	}

}
