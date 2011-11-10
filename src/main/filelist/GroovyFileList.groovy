/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filelist

import groovy.json.JsonSlurper;

/**
 *
 * @author Администратор
 */
class GroovyFileList {
	def run(){
            def File f = new File("./sql");
            println "Entire file list";
            println f.list();
            
            def unsortedFL = f.list(new SqlFileFilter(/\d+-(.*?)\.sql/));
            println "Filtred file list"
            println unsortedFL;
            
            def sortedFL = unsortedFL.sort();
            println "Sorted file list"
            println sortedFL; 
            
//            def ar1 = [9,8,7,6];
//            println ar1;
//            println ar1.sort{a,b -> (a%2 + b%2)};
            def File configFile = new File ("./config.txt");
            def fileText = configFile.getText();
            def slurper = new JsonSlurper();    
            def result = slurper.parseText(fileText);
            println ("config.txt:");
            println (result.database);
            println (result.production.dbname);
            println (result.production.dbuser);
        }
}


