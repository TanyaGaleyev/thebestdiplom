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
}
