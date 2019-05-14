package de.intsys.krestel.SearchEngine;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class JsoupGetMetaData {


    public static void main(String args[]){
        Document document;
        try {
            //Get Document object after parsing the html from given url.
            document = Jsoup.connect(
                    "https://www.theglobeandmail.com/world/article-houston-man-who-reported-4-year-old-maleah-davis-missing-arrested-in/")
                    .get();

            //Get description from document object.
            String description =
                    document.select("meta[name=description]").get(0)
                            .attr("content");
            //Print description.
            System.out.println("Meta Description: " + description);

            //Get keywords from document object.
            String keywords =
                    document.select("meta[name=keywords]").first()
                            .attr("content");
            //Print keywords.
            System.out.println("Meta Keyword : " + keywords);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


