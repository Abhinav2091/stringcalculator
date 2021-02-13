package com.kata.stringcalculator;

import com.kata.stringcalculator.service.StringCalculator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
@SpringBootTest
class StringcalculatorApplicationTests {

	private static  final Logger LOGGER = LoggerFactory.getLogger(StringcalculatorApplicationTests.class);

	@Autowired
	private StringCalculator stringCalculator;
	@Test
	void forEmptyString() throws Exception {  int result=stringCalculator.Add("");
		Assert.assertEquals(result,0);

	}
	@Test
	void forOneValueInString() throws Exception {  int result=stringCalculator.Add("3");
		Assert.assertEquals(result,3);

	}
	@Test
	void forMoreThanOneValueInString() throws Exception {  int result=stringCalculator.Add("2,3,4");
		Assert.assertEquals(result,9);

	}

	@Test
	void forMoreThanNewLineInString() throws Exception {  int result=stringCalculator.Add("2\n3,4");
		Assert.assertEquals(result,9);

	}

	@Test
	void forDelimitersString() throws Exception {  int result=stringCalculator.Add("//;\n1;2");
		Assert.assertEquals(result,3);

	}

	@Test
	void forNegativeNumberString() throws Exception {  int result=stringCalculator.Add("//;\n1;2");
	try {
		stringCalculator.Add("-3,-4");
	}
	catch (Exception e)
	{
		LOGGER.error("{}",e.getMessage());
	}
	}

}
