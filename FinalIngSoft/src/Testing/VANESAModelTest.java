package Testing;

import static org.junit.Assert.*;

import javax.sound.sampled.AudioFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Modelos.VANESAModel;
import Modelos.BeatModelInterface;

public class VANESAModelTest {
	VANESAModel vanesaModelTest;
	byte[] sample;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		vanesaModelTest = VANESAModel.getInstance();
		sample = new byte[10];
		for(int i = 0; i < sample.length; i+=2){		
			sample[i] = (byte) 50d;
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSingleton() {
		BeatModelInterface resultado = VANESAModel.getInstance();
		assertEquals(vanesaModelTest,resultado);
	}
	
	@Test
	public void testCalculateRMSLevel() {
		int resultado = vanesaModelTest.calculateRMSLevel(sample);
		int esperado = 25;
		assertEquals(esperado,resultado);
		
	}
	
	@Test
	public void testFormat(){
		AudioFormat resultado = vanesaModelTest.getAudioFormat();
		assertNotEquals(null,resultado);
	}

}
