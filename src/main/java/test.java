import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //get the texts into test strings
        String testString1 = test.urlToString("http://erdani.com/tdpl/hamlet.txt");
        String testString2 = test.urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        String testString3 = test.urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt");

        //convert test strings into arrays filled with each word
        String[] tS1Array = testString1.split(" ");
        String[] tS2Array = testString2.split(" ");
        String[] tS3Array = testString3.split(" ");

        //print length of array (number of words)
        System.out.println(tS1Array.length);
        System.out.println(tS2Array.length);
        System.out.println(tS3Array.length);

        //counts number of "prince"s in Hamlet
        int count = 0;
        System.out.println(testString1);

        //for each word in the array, check if it is prince or princes (if so, increment count)
        for (String x : tS1Array) {
            if (x.equalsIgnoreCase("prince") || x.equalsIgnoreCase("princes")) {
               count++;
            }
         }
        System.out.println(count);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}