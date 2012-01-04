/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filelist


/**
 *
 * @author Администратор
 */
class GroovyFileListReader {
	def readFileList(String path) {
            def File f = new File(path);
            def unsortedFL = f.list(new SqlFileFilter(/\d+-(.*?)\.sql/));
            def sortedFL = unsortedFL.sort();
            return sortedFL;
        }
}


