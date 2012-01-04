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
class ConfigReader {
    def Config parseConfig(String fileName) {
            def File configFile = new File (fileName);
            def fileText = configFile.getText();
            def slurper = new JsonSlurper();    
            def result = slurper.parseText(fileText);
            def Config cfg = new Config(
                result.database,
                result.production.dbname,
                result.production.dbuser,
                result.production.host);
            return cfg;
        }
        
}

