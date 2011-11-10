/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filelist;

import groovy.json.JsonSlurper;

def configFile = new File ("./config.txt");
def fileText = configFile.getText();
def slurper = new JsonSlurper();    
def result = slurper.parseText(fileText);

println ("Read database: $result.database");
println ("Read dbname: $result.production.dbname");
println ("Read dbuser: $result.production.dbuser");
