package 错误处理;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author vector
 * @Data 2018/8/22 0022
 * @Description 先写Try-Catch-Finally语句
 */
public class Demo72 {
	@Test(expected = StorageException.class)
	public void retrieveSectionShouldThrowOnInvalidFileName() {
		sectionStore.retrieveSection("invalid - file");

	}

	public List<RecordedGrip> retrieveSection(String sectionName) {
		// dummy return until we have a real implementation
		return new ArrayList<RecordedGrip>();

	}


	public List<RecordedGrip> retrieveSection(String sectionName) {
		try {
			FileInputStream stream = new FileInputStream(sectionName);
		} catch (Exception e) {
			throw new StorageException("retrieval error", e);
		}
		return new ArrayList<RecordedGrip>();
	}

	public List<RecordedGrip> retrieveSection(String sectionName) {
		try {
			FileInputStream stream = new FileInputStream(sectionName);
			stream.close();

		} catch (FileNotFoundException e) {
			throw new StorageException("retrieval error", e);

		}
		return new ArrayList<RecordedGrip>();

	}
}
