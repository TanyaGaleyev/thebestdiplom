/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filelist

/**
 *
 * @author РђРґРјРёРЅРёСЃС‚СЂР°С‚РѕСЂ
 */
class ScriptsRunner {
    def scriptsDir = "./sql";
    
    def void runScripts() {
        ConfigReader cr = new ConfigReader();
        Config cfg = cr.parseConfig("./config.txt");
        ProfileReader pr = new ProfileReader();
        Profile prf = pr.parseProfile("./profiles/${cfg.database}.txt");
        def getVersionCommand = buildExecSql(cfg, prf, prf.queryGetVersion);
        println getVersionCommand;
        def process0 = getVersionCommand.execute();
        def version = -1;
        List lines = process0.in.readLines();
        if(lines.size() > 0) {
            version = lines.get(1).toInteger();
        }

        GroovyFileListReader gflr = new GroovyFileListReader();
        def fnList = gflr.readFileList(scriptsDir);
        def scrVersion = 0;

        def nscrs = 0;
        fnList.each() {
            def matcher = it =~ /\d+/;
            scrVersion = matcher[0].toInteger();
            if(scrVersion > version) {
                def runCommand = buildExecFile(cfg, prf, "${scriptsDir}/${it}");
                println runCommand;
                def process = runCommand.execute();
                nscrs++;
                println process.in.text;
                println process.err.text;
            }
        }
        if(scrVersion > version) {
            def engine = new groovy.text.SimpleTemplateEngine();
            def template = engine.createTemplate(prf.querySetVersion);
            def querySetVersion = template.make('version':scrVersion).toString();
            def setVersionCommand = buildExecSql(cfg, prf, querySetVersion);
            setVersionCommand.execute();
        }
        println "${nscrs} scripts executed!!"
        println "Db updated from ${version} to ${scrVersion}"
    }
    
    def buildExecSql(Config cfg, Profile prf, String sql) {
        // Connection
        def dbuser = cfg.dbuser;
        def dbname = cfg.dbname;
        def host = cfg.host;
        // Profile
        def mainargs = prf.mainargs;
        def execsql = prf.execsql;
        def execfile = prf.execfile;
        def command = prf.command;
        // Создаем объект, который будет подставлять нужные значения в строку
        def execstr = "${command} ${mainargs} ${execsql}";
        def engine = new groovy.text.SimpleTemplateEngine();
        def template = engine.createTemplate(execstr);
        def execcommand = template.make('dbuser':dbuser, 'dbname':dbname, 'host':host, 'sql':sql).toString();
    
        return execcommand;
    }

    def buildExecFile(Config cfg, Profile prf, String filename) {
        // Connection
        def dbuser = cfg.dbuser;
        def dbname = cfg.dbname;
        def host = cfg.host;
        // Profile
        def mainargs = prf.mainargs;
        def execsql = prf.execsql;
        def execfile = prf.execfile;
        def command = prf.command;
        // Создаем объект, который будет подставлять нужные значения в строку
        def execstr = "${command} ${mainargs} ${execfile}";
        def engine = new groovy.text.SimpleTemplateEngine();
        def template = engine.createTemplate(execstr);
        def execcommand = template.make('dbuser':dbuser, 'dbname':dbname, 'host':host, 'filename':filename).toString();
    
        return execcommand;
    }
	
}

