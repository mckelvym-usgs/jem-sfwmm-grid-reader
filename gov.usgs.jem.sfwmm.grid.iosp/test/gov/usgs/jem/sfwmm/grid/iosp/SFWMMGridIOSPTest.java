package gov.usgs.jem.sfwmm.grid.iosp;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ucar.nc2.NetcdfFile;
import ucar.unidata.io.RandomAccessFile;

/**
 * Tests {@link SFWMMGridIOSP}
 *
 * @author mckelvym
 * @since Oct 28, 2016
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SFWMMGridIOSPTest
{

	private static final Random r;

	static
	{
		r = new Random(System.currentTimeMillis());
	}

	/**
	 * @throws java.lang.Exception
	 *             if unexpected condition causing test failure
	 * @since Oct 28, 2016
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		final Class<?> classToTest = SFWMMGridIOSP.class;
		final Class<?> testingClass = SFWMMGridIOSPTest.class;
		AllTests.assertHasRequiredMethods(classToTest, testingClass);
	}

	/**
	 * @throws java.lang.Exception
	 *             if unexpected condition causing test failure
	 * @since Oct 28, 2016
	 */
	@Before
	public void setUp() throws Exception
	{
		NetcdfFile.registerIOProvider(SFWMMGridIOSP.class, true);
	}

	/**
	 * Test method for
	 * {@link gov.usgs.jem.sfwmm.grid.iosp.SFWMMGridIOSP#getFileTypeDescription()}.
	 *
	 * @throws IOException
	 */
	@Test
	public void testGetFileTypeDescription() throws IOException
	{
		try (NetcdfFile nc = NetcdfFile
				.open(AllTests.getTestFile().getAbsolutePath()))
		{
			Assert.assertEquals(SFWMMGridIOSP.class.getSimpleName(),
					nc.getFileTypeDescription());
		}
		catch (final IOException e)
		{
			final String message = String.format(
					"Unable to get file type description for %s",
					AllTests.getTestFile());
			fail(message);
		}
	}

	/**
	 * Test method for
	 * {@link gov.usgs.jem.sfwmm.grid.iosp.SFWMMGridIOSP#getFileTypeId()}.
	 */
	@Test
	public void testGetFileTypeId()
	{
		try (NetcdfFile nc = NetcdfFile
				.open(AllTests.getTestFile().getAbsolutePath()))
		{
			Assert.assertEquals(SFWMMGridIOSP.class.getCanonicalName(),
					nc.getFileTypeId());
		}
		catch (final IOException e)
		{
			final String message = String.format(
					"Unable to get file type description for %s",
					AllTests.getTestFile());
			fail(message);
		}
	}

	/**
	 * Test method for
	 * {@link gov.usgs.jem.sfwmm.grid.iosp.SFWMMGridIOSP#isValidFile(ucar.unidata.io.RandomAccessFile)}.
	 */
	@Test
	public void testIsValidFile()
	{
		final SFWMMGridIOSP iosp = new SFWMMGridIOSP();
		try (RandomAccessFile raf = new RandomAccessFile(
				AllTests.getTestFile().getAbsolutePath(), "r"))
		{
			Assert.assertEquals(true, iosp.isValidFile(raf));
		}
		catch (final IOException e)
		{
			final String message = String.format(
					"Unable to test if the file is valid: %s",
					AllTests.getTestFile());
			fail(message);
		}
	}

	/**
	 * Test method for
	 * {@link gov.usgs.jem.sfwmm.grid.iosp.SFWMMGridIOSP#readData(ucar.nc2.Variable, ucar.ma2.Section)}.
	 */
	@Test
	public void testReadData()
	{
		fail("Not yet implemented");
	}

}
