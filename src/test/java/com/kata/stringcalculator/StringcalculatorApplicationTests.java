package com.kata.stringcalculator;

import com.kata.stringcalculator.service.StringCalculator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StringcalculatorApplicationTests {

	private static  final Logger LOGGER = LoggerFactory.getLogger(StringcalculatorApplicationTests.class);

	@Autowired
	private StringCalculator stringCalculator;

	@Test
	@Order(1)
	void forEmptyString() throws Exception {  int result=stringCalculator.Add("");
		Assert.assertEquals(result,0);

	}
	@Test
	@Order(2)
	void forOneValueInString() throws Exception {  int result=stringCalculator.Add("3");
		Assert.assertEquals(result,3);

	}
	@Test
	@Order(3)
	void forMoreThanOneValueInString() throws Exception {  int result=stringCalculator.Add("2,3,4");
		Assert.assertEquals(result,9);

	}

	@Test
	@Order(4)
	void forMoreThanNewLineInString() throws Exception {  int result=stringCalculator.Add("2\n3,4");
		Assert.assertEquals(result,9);

	}

	@Test
	@Order(5)
	void forDelimitersString() throws Exception {  int result=stringCalculator.Add("//;\n1;2");
		Assert.assertEquals(result,3);

	}

	@Test
	@Order(6)
	void forNegativeNumberString() throws Exception {  int result=stringCalculator.Add("//;\n1;2");
	try {
		stringCalculator.Add("-3,-4");
	}
	catch (Exception e)
	{
		LOGGER.error("{}",e.getMessage());
	}
	}

	@Test
	@Order(7)
	public void forNumberGreaterThanThousand() throws Exception {
		int result=stringCalculator.Add("2,3,4,10001");
		Assert.assertEquals(result,9);	}

	@Test
	@Order(8)
	public void forSingleDelimiter() throws Exception {
		int result=stringCalculator.Add("//[***]\n1***2***3");
		Assert.assertEquals(result,6);	}
	@Test
	@Order(9)
	public void forMultipleDelimiter() throws Exception {
		int result=stringCalculator.Add("//[*][%]\n1*2%3");
		Assert.assertEquals(result,6);	}

	@Test
	@Order(10)
	public void forMultipleDelimiterOfAnyLength() throws Exception {
		int result=stringCalculator.Add("//[**][%%]\n1**2%%3");
		Assert.assertEquals(result,6);	}

	@Test
	@Order(11)
	public void forMethodCount()
	{
		LOGGER.info("No of time Add method invoked is {}",stringCalculator.GetCalledCount());
	}

}
