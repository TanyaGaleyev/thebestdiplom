/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filelist

/**
 *
 * @author Администратор
 */
class SqlFileFilter implements FilenameFilter {
    def String ext = /\d+-(.*?)\.sql/;
    
    def SqlFileFilter(String ext1) {
        if(ext1 != null) {
            ext = ext1;
        }
    }
    
    def SqlFileFilter() {
        this(null);
    }
    
    public boolean accept(File f, String filename) {  
        return filename ==~ ext;
//        return filename.endsWith(ext);
    }  
} 


