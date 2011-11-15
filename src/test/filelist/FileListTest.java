/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filelist;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Администратор
 */
public class FileListTest {
    
    public FileListTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test
     */
//    @Test
//    public void test1() {
//        String expected = "Tanya";
//        String result = "Vanya";
//        
//        assertEquals(expected.substring(1), result.substring(1));
//    }
    
    /**
     * Test
     */
    @Test
    public void test2() {
        SqlFileFilter sff = new SqlFileFilter(null);
        boolean res = sff.accept(null, "00111-dfdkl.sql");
        boolean exp = true;
        assertEquals(res, exp);
    }
    
    /**
     * Test
     */
    @Test
    public void test3() {
        SqlFileFilter sff = new SqlFileFilter(null);
        boolean res = sff.accept(null, "00111dfdkl.sql");
        boolean exp = false;
        assertEquals(res, exp);
    }
    
    /**
     * Test
     */
    @Test
    public void test4() {
        SqlFileFilter sff = new SqlFileFilter(null);
        boolean res = sff.accept(null, "00111-dfdkl.sqn");
        boolean exp = false;
        assertEquals(res, exp);
    }
    
    @Test
    public void test5() {
        SqlFileFilter sff = new SqlFileFilter(null);
        boolean res = sff.accept(null, "00l111-dfdkl.sql");
        boolean exp = false;
        assertEquals(res, exp);
    }
    
    ConfigReader cf = new ConfigReader();
    
    /**
     * Test
     */
    @Test
    public void configTest1() {
        Config res = cf.parseConfig("./src/test/resources/configs/config1.txt");
        Config exp = new Config ("MySQL", "Vanyadb", "Vanya");
        assertEquals(res.getDataBase(), exp.getDataBase());
        assertEquals(res.getDbname(), exp.getDbname());
        assertEquals(res.getDbuser(), exp.getDbuser());
    }
     /**
     * Test
     */
    @Test
    public void configTest2() {
        Config res = cf.parseConfig("./src/test/resources/configs/config2.txt");
        Config exp = new Config ("MySQL", "Tanyadb", "Tanya");
        assertEquals(res.getDataBase(), exp.getDataBase());
        assertEquals(res.getDbname(), exp.getDbname());
        assertEquals(res.getDbuser(), exp.getDbuser());
    }
    
   /**
     * Test
     */
    @Test
    public void configTest3() {
        Config res = cf.parseConfig("./src/test/resources/configs/config3.txt");
        Config exp = new Config ("postgresql", "smbddb", "smbd");
        assertEquals(res.getDataBase(), exp.getDataBase());
        assertEquals(res.getDbname(), exp.getDbname());
        assertEquals(res.getDbuser(), exp.getDbuser());
    }  
}

    