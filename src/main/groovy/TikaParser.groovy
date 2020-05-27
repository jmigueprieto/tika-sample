import org.apache.tika.Tika
import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.AutoDetectParser
import org.apache.tika.sax.ToXMLContentHandler

class TikaParser {

    // Apache Tika - a content analysis toolkit
    // https://tika.apache.org/
    static void main(String[] args) {
        def file = "docs/062.enr"
        new File(file).withInputStream { inputStream ->
            println parseToText(inputStream)
            //println parseToHTML(inputStream)
        }
    }

    static String parseToText(InputStream stream) {
        def tika = new Tika()
        def metadata = new Metadata()
        return tika.parseToString(stream, metadata)
        // println "### Metadata ###"
        // println metadata
    }

    static String parseToHTML(InputStream stream) {
        def handler = new ToXMLContentHandler()
        def parser = new AutoDetectParser()
        def metadata = new Metadata()

        parser.parse(stream, handler, metadata)
        return handler.toString()
    }

//    static String detectDocTypeUsingDetector(InputStream stream)
//            throws IOException {
//        def detector = new DefaultDetector()
//        def mediaType = detector.detect(stream, new Metadata())
//        return mediaType.toString()
//    }
}
