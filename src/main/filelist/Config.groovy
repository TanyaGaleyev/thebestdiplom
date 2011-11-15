/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filelist

/**
 *
 * @author Администратор
 */
class Config {
	def String dataBase;
        def String dbname;
        def String dbuser;
        
        def Config(String db, String dbn, String dbu) {
            dataBase = db;
            dbname = dbn;
            dbuser = dbu;
        }
        
}

