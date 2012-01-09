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

        def String queryGetVersion;
        def String querySetVersion;
        
        def Profile(String cmd, String marg, String xsql, String xfl, String qget, String qset) {
            command = cmd;
            mainargs = marg;
            execsql = xsql;
            execfile = xfl;

            queryGetVersion = qget;
            querySetVersion = qset;
        }
}
