package glut.test;

import glut.bean.WordAndCount;
import glut.func.TrieTreeMaker;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

public class MyTest {
	@Test
	public void test() {

		String filePath = "C:\\logs\\file.log";

		File srcFile = new File(filePath);

		System.out.println("File Size:" + srcFile.length() / 1024 / 1024.0
				+ "M");

		long end2, end, start = System.nanoTime();

		TrieTreeMaker maker = new TrieTreeMaker();

		maker.setCapacity(1024 * 1024 * 20);
		//通过给定的文件来构造字典树,也可通过调用createTrieTree("xxxx")实现.
		maker.obtainDataAndCreateTrieTree(srcFile);

		end = System.nanoTime();

		System.out.println("After Creation is accomplished:"
				+ BigDecimal.valueOf(end - start, 9));
		//true代表升序,false代表降序
		List<Entry<String, WordAndCount>> list = maker.sort(
				maker.getWordCountMap(), true);

		end2 = System.nanoTime();

		System.out.println("After Sort is accomplished:"
				+ BigDecimal.valueOf(end2 - end, 9));
		//结果输出
		for (Entry<String, WordAndCount> entry : list) {
			System.out.println(entry.getValue().word + ","
					+ entry.getValue().count);
		}
	}
}
