package 对象和数据结构;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * @author vector
 * @Data 2018/8/22 0022
 * @Description 隐藏结构
 */
public class Demo633 {
	String outFile = outputDir + "/" + className.replace('.', '/') + ".class";

	FileOutputStream fout = new FileOutputStream(outFile);

	BufferedOutputStream bos = new BufferedOutputStream(fout);







	BufferedOutputStream bos = ctxt.createScratchFileStream(classFileName);
}
