/*Copyright [2017] [Event Horizon Analytics]
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0

* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package PDF;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import PDF.ConstraintStripper;

public class PDFTest {
	
	public static void constrainText(String start, String end, File file) throws IOException {
		PDDocument doc = PDDocument.load(file);
		PDFTextStripper stripper = new PDFTextStripper();
		String text = stripper.getText(doc); // we get the text of the entire document into a String
	    String[] split_on_start = text.split(start); // split on the start parameter, take upper bound
	    String[] split_on_end = split_on_start[1].split(end); // split on end parameter, take lower bound
	    String constrained_string = start;
	    constrained_string+=split_on_end[0]; // the final string will be the area in between start and end
	    doc.close();
	    System.out.print(constrained_string);
	}


	public static void main(String[] args) throws IOException{   
		  File file = new File("/Users/ryandonovan/Documents/ExamplePDF.pdf");
		  constrainText("1. CONSENT AGENDA", "2. REPORT", file);
		
		 }


}

