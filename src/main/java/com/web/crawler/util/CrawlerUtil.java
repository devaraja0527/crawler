package com.web.crawler.util;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.io.IOException;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerUtil {

	  private Set<String> pagesVisited = new HashSet<String>();
	  private List<String> pagesToVisit = new LinkedList<String>();

	  private static final String USER_AGENT =
	            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	    private List<String> links = new LinkedList<String>();
	    private Document htmlDocument;
	    
	    
	  public String search(final String url, final String searchWord,final int maxpagesToSearch) throws IOException {
	     
		  String returnUrl = null;
		  
		  while(this.pagesVisited.size() < maxpagesToSearch) {
	          String currentUrl;
	          if(this.pagesToVisit.isEmpty()) {
	              currentUrl = url;
	              this.pagesVisited.add(url);
	          } else {
	              currentUrl = this.nextUrl();
	          }
	          crawl(currentUrl); 
	          boolean success = searchForWord(searchWord);
	          if(success)  {
	              System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
	              returnUrl = currentUrl;
	              break;
	          }
	          this.pagesToVisit.addAll(getLinks());
	      }
	      System.out.println("\n**Done** Visited " + this.pagesVisited.size() + " web page(s)");
	      return returnUrl;
	  }


	
	  private String nextUrl() {
	      String nextUrl;
	      do {
	          nextUrl = this.pagesToVisit.remove(0);
	      } while(this.pagesVisited.contains(nextUrl));
	      this.pagesVisited.add(nextUrl);
	      return nextUrl;
	  }
	  
	  public boolean crawl(String url) throws IOException
	    {
	            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
	            Document htmlDocument = connection.get();
	            this.htmlDocument = htmlDocument;
	            if(connection.response().statusCode() == 200)  {
	                System.out.println("\n**Visiting** Received web page at " + url);
	            }
	            if(!connection.response().contentType().contains("text/html")) {
	                System.out.println("**Failure** Retrieved something other than HTML");
	                return false;
	            }
	            Elements linksOnPage = htmlDocument.select("a[href]");
	            System.out.println("Found (" + linksOnPage.size() + ") links");
	            for(Element link : linksOnPage) {
	                this.links.add(link.absUrl("href"));
	            }
	            return true;
	    }


	
	    public boolean searchForWord(String searchWord)
	    {
	        // Defensive coding. This method should only be used after a successful crawl.
	        if(this.htmlDocument == null)
	        {
	            System.out.println("ERROR! Call crawl() before performing analysis on the document");
	            return false;
	        }
	        System.out.println("Searching for the word " + searchWord + "...");
	        String bodyText = this.htmlDocument.body().text();
	        return bodyText.toLowerCase().contains(searchWord.toLowerCase());
	    }


	    public List<String> getLinks()
	    {
	        return this.links;
	    }
}
