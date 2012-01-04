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
class ProfileReader {
	def Profile parseProfile(String fileName){
            def File profileFile = new File (fileName);
            def fileText = profileFile.getText();
            def slurper = new JsonSlurper();    
            def result = slurper.parseText(fileText);
            def Profile pfl = new Profile(
                result.command,
                result.mainargs,
                result.execsql,
                result.execfile);
            return pfl;
        }
}

