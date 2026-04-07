package com.tutorialsninja.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProvideClass {

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		Object[][] data = { { "aj@gmail.com", "1234" }, { "aaj@gmail.com", "12a34" }};

		return data;
	}

}
