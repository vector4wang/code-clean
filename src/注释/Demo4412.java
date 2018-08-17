package 注释;

/**
 * @author vector
 * @Data 2018/8/17 0017
 * @Description 注释掉的代码
 */
public class Demo4412 {

	this.bytePos = writeBytes(pngIdBytes, 0);
	//hdrPos = bytePos;
	writeHeader();
	writeResolution();
	//dataPos = bytePos;
	if(writeImageData()){
		writeEnd();
		this.pngBytes = resizeByteArray(this.pngBytes, this.maxPos);
	} else {
		this.pngBytes = null;
	}
	return this.pngBytes;
}
