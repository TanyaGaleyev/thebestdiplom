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
        GroovyFileListReader gflr = new GroovyFileListReader();
        def fnList = gflr.readFileList(scriptsDir);
        ConfigReader cr = new ConfigReader();
        Config cfg = cr.parseConfig("./config.txt");
        ProfileReader pr = new ProfileReader();
        Profile prf = pr.parseProfile("./profiles/postgresql.txt");
//        def process0 = "psql -U postgres -d postgres -c \"SELECT * FROM pg_am\"".execute();
//        println process0.text;
        fnList.each() {
            def runCommand = buildExecFile(cfg, prf, "${scriptsDir}/${it}");
            println runCommand;
            def process = runCommand.execute();
            println process.in.text;
            println process.err.text;
        }
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

