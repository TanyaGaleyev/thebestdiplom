/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filelist

/**
 *
 * @author Администратор
 */
class Profile {
	
        def String command;
        def String mainargs;
        def String execsql;
        def String execfile;
        
        def Profile(String cmd, String marg, String xsql, String xfl) {
            
            
            command = cmd;
            mainargs = marg;
            execsql = xsql;
            execfile = xfl;
        }
}
