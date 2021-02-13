package com.kata.stringcalculator;

import com.kata.stringcalculator.service.StringCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
@SpringBootTest
class StringcalculatorApplicationTests {

	@Autowired
	private StringCalculator stringCalculator;
	@Test
	void forEmptyString()
	{  int result=stringCalculator.Add("");
		Assert.assertEquals(result,0);

	}
	@Test
	void forOneValueInString()
	{  int result=stringCalculator.Add("3");
		Assert.assertEquals(result,3);

	}
	@Test
	void forMoreThanOneValueInString()
	{  int result=stringCalculator.Add("2,3,4");
		Assert.assertEquals(result,9);

	}

	@Test
	void forMoreThanNewLineInString()
	{  int result=stringCalculator.Add("2\n3,4");
		Assert.assertEquals(result,9);

	}

	@Test
	void forDelimitersString()
	{  int result=stringCalculator.Add("//;\n1;2");
		Assert.assertEquals(result,3);

	}

}
