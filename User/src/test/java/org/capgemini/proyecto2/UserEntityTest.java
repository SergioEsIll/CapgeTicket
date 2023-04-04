package org.capgemini.proyecto2;

import org.assertj.core.api.SoftAssertions;
import org.capgemini.proyecto2.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserEntityTest {

	@Test
	public void should_softly_check_name_surname_email_password_and_registrer_date() {
		// Given //When
		final User user = new User(1, "Test", "SoftlyAssertJ", "Test@Test.com", "Pass", null);

		// Then
		SoftAssertions.assertSoftly(softly -> {
			softly.assertThat((user.getName()).equals("Test"));
			softly.assertThat((user.getSurname()).equals("SoftlyAssertJ"));
			softly.assertThat((user.getEmail()).equals("Test@Test.com"));
			softly.assertThat((user.getPassword()).equals("Pass"));
		});
	}

	@Test
	public void should_fail_bad_checks_in_user_instance() {
		// Given //When
		final User user = new User(1, "Test", "SoftlyAssertJ", "Test@Test.com", "Pass", null);

		// Then
		SoftAssertions.assertSoftly(softly -> {
			softly.assertThat(!((user.getName()).equals("Fail")));
			softly.assertThat(!((user.getSurname()).equals("Fail")));
			softly.assertThat(!((user.getEmail()).equals("Fail")));
			softly.assertThat(!((user.getPassword()).equals("Fail")));
		});
	}

}
