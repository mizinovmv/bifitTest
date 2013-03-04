package task2;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordCounterTest {

	@Test
	public void testCount() {
		WordCounter wordCounter = new WordCounter("data/some_text.txt");
		try {
			assertEquals(wordCounter.count("test"), 2);
			assertEquals(wordCounter.count("число"), 4);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
