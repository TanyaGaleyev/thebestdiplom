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
        
    def boolean equals1(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if (!obj instanceof Config) return false;
        
        def Config other = obj;
        if(!dataBase.equals(other.dataBase)) return false;
        if(!dbname.equals(other.dbname)) return false;
        if(!dbuser.equals(other.dbuser)) return false;
        return true;
    }
}

