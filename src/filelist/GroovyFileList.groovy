/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filelist

/**
 *
 * @author Администратор
 */
class GroovyFileList {
	def run(){
            def File f = new File("./SQLs");
            println "Entire file ist";
            println f.list();
            
            def unsortedFL = f.list(new TanyaFileFilter(/\d+-(.*?)\.sql/));
            println "Filtred file list"
            println unsortedFL;
            
            def sortedFL = unsortedFL.sort();
            println "Sorted file list"
            println sortedFL; 
            
//            def ar1 = [9,8,7,6];
//            println ar1;
//            println ar1.sort{a,b -> (a%2 + b%2)};
        }
}

class SqlFileFilter implements FilenameFilter {
    def String ext = /\d+-(.*?)\.sql/;
    
    def TanyaFileFilter(String ext1) {
        if(ext1 != null) {
            ext = ext1;
        }
    }
    
    public boolean accept(File f, String filename) {  
        return filename ==~ ext;
//        return filename.endsWith(ext);
    }  
} 


