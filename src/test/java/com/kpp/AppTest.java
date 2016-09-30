package com.kpp;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 执行结果分析
 * 1 @BeforeClass和@AfterClass只执行一次，在所有方法开始前/后
 * 2 @Before和@After在每个@Test标注的方法前后各执行一次
 * 3 @Test 标注的方法都会执行一次（表示要测试的方法）
 * 4 @Ignore方法不会被执行，没有annotation的方法也不会被执行
 * 5 总结  @BeforeClass –> （@Before –> @Test –> @After） –> @AfterClass
 */
//@RunWith(Parameterized.class)
public class AppTest {
	
	App app;

	//参数化测试
	/*int parm1;// 定义入参
	int parm2;// 定义入参
	int res;// 定义预期结果

	public AppTest(int parm1, int parm2, int res) {// 定义构造函数
		this.parm1 = parm1;
		this.parm2 = parm2;
		this.res = res;
	}

	@Parameters
	public static Collection<Object[]> initParm() {
		Collection<Object[]> m1 = Arrays.asList(
				new Object[][] { { 1, 1, 2 }, { 1, 2, 3 }, { 1, 3, 4 }, { 1, 4, 5 }// {}里的参数一定要和构造函数一一对应
		});
		return m1;
	}*/

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		app = new App();
	}

    /**
	 * assertEquals(String msg, Object expectRes, Object Res) --------  用于值判断
	 *	判断expectRes.equals(Res) ，表示值等于的判断，失败则抛MSG
	 *	
	 *	assertSame(String msg, Object expectRes, Object Res)  --------  用于地址判断
	 *	判断expectRes==Res，表示地址等于的判断，失败则抛MSG
	 *	
	 *	assertTrue(String msg,Boolean result) ----------------------------用于Boolean判断
	 *	判断result是true还是false，失败则抛MSG
	 *	
	 *	assertNull(String msg,Object result)-------------------------------用于NULL判断
	 *	判断result是否为NULL，失败则抛MSG
	 *	
	 *	fail(String msg);---------------------------------------------------直接中止方法运行
	 *	直接中止方法运行，抛出MSG
	 */
	@Test
	public void testAddInt() {
		//单条件测试
		assertEquals(3,app.addInt(1, 2));
		//多条件测试,每个方法都会使用此参数数组数据的循环?影响其他测试方法?
		//assertEquals(res, app.addInt(parm1, parm2));
	}

	@Test
	public void testSubInt() {
		assertEquals(1,app.subInt(3, 2));
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
