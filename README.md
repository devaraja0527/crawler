         			API Document for Code Challenge 
1.	WebCrawler lists links and also search word 
2.	Get Products Using 2 prams in path.
3.	Identify Non repeated character in String.
4.	Read/ Write content in File.
     To complete the challenge,I have below tech stack also I have covered most of Junit Test cases as well.
      Key Tech Stack:   
                  1.  Spring boot for Rest Controller Creation with Maven.
                  2.  Mockito for Junit Mocks
                  3.   jsoup library for WebCrawler.
	   4.  JSON for request and response.       

Web Crawler that lists and search word:
                  This API is uses to GET rest method to fetch list of links also to search word using WebCrawler, since special characters are not allowed in URL parameters for the request they are added in request body.
              List Links: url is mandatory parameter for below request
                 URL :  http://localhost:30001/crawler
                 Rest Method: GET
                       Request Body: {  "url" :"https://www.mkyong.com/"  }
                  Response: 
                          {
	"code": 200,
	"links": [{
		"link": "https:\/\/www.mkyong.com\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/all-tutorials-on-mkyong-com\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/tutorials\/java-8-tutorials\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/tutorials\/spring-boot-tutorials\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/tutorials\/maven-tutorials\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/contact-mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/spring-boot\/spring-boot-webflux-thymeleaf-reactive-example\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/spring-boot\/spring-boot-webflux-thymeleaf-reactive-example\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/linux\/an-introduction-to-kernel-live-patching-on-linux\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/linux\/an-introduction-to-kernel-live-patching-on-linux\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/pjacobs\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-how-to-run-windows-bat-file\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-how-to-run-windows-bat-file\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-how-to-list-all-files-in-a-directory\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-how-to-list-all-files-in-a-directory\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/python\/python-how-to-list-all-files-in-a-directory\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/python\/python-how-to-list-all-files-in-a-directory\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-processbuilder-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-processbuilder-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-files-walk-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-files-walk-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-how-to-read-a-file-into-a-list\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-how-to-read-a-file-into-a-list\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/python\/python-how-to-read-a-file-into-a-list\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/python\/python-how-to-read-a-file-into-a-list\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/git\/git-pull-refusing-to-merge-unrelated-histories\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/git\/git-pull-refusing-to-merge-unrelated-histories\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-blockingqueue-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-blockingqueue-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-check-if-a-string-contains-another-string\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-check-if-a-string-contains-another-string\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-semaphore-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-semaphore-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-sequence-generator-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-sequence-generator-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-executorservice-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-executorservice-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/intellij\/intellij-idea-how-to-show-method-signature\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/intellij\/intellij-idea-how-to-show-method-signature\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-scheduledexecutorservice-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-scheduledexecutorservice-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-fork-join-framework-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-fork-join-framework-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-fibonacci-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-fibonacci-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java8\/java-8-stream-iterate-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java8\/java-8-stream-iterate-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/git\/git-how-to-undo-the-last-commit\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/git\/git-how-to-undo-the-last-commit\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/git\/git-how-to-remove-files-from-staging-changes-to-be-committed\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/git\/git-how-to-remove-files-from-staging-changes-to-be-committed\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/git\/git-how-to-list-committed-files-that-are-going-to-push\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/git\/git-how-to-list-committed-files-that-are-going-to-push\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/jmh-java-forward-loop-vs-reverse-loop\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/jmh-java-forward-loop-vs-reverse-loop\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-jmh-benchmark-tutorial\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-jmh-benchmark-tutorial\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/maven\/maven-how-to-force-re-download-project-dependencies\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/maven\/maven-how-to-force-re-download-project-dependencies\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/maven\/maven-pmd-example\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/maven\/maven-pmd-example\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-global-variable-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/java\/java-global-variable-examples\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/maven\/maven-spotbugs-example\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/maven\/maven-spotbugs-example\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/maven\/mvn-site-java-lang-classnotfoundexception-org-apache-maven-doxia-siterenderer-documentcontent\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/maven\/mvn-site-java-lang-classnotfoundexception-org-apache-maven-doxia-siterenderer-documentcontent\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/author\/mkyong\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/page\/2\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/page\/3\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/page\/4\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/page\/5\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/page\/2\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/page\/62\/"
	}, {
		"link": "http:\/\/developer.android.com\/training\/index.html"
	}, {
		"link": "https:\/\/cloud.google.com\/appengine\/docs\/java\/"
	}, {
		"link": "http:\/\/docs.spring.io\/spring\/docs\/2.5.x\/reference\/index.html"
	}, {
		"link": "http:\/\/docs.spring.io\/spring\/docs\/3.2.x\/spring-framework-reference\/html\/"
	}, {
		"link": "http:\/\/docs.spring.io\/spring\/docs\/4.1.x\/spring-framework-reference\/html\/"
	}, {
		"link": "http:\/\/docs.oracle.com\/javaee\/5\/tutorial\/doc\/docinfo.html"
	}, {
		"link": "http:\/\/docs.oracle.com\/javaee\/6\/tutorial\/doc\/docinfo.html"
	}, {
		"link": "https:\/\/docs.oracle.com\/javaee\/7\/tutorial\/index.html"
	}, {
		"link": "http:\/\/docs.oracle.com\/javase\/6\/docs\/api\/overview-summary.html"
	}, {
		"link": "http:\/\/docs.oracle.com\/javase\/7\/docs\/api\/overview-summary.html"
	}, {
		"link": "http:\/\/docs.oracle.com\/javase\/8\/docs\/api\/overview-summary.html"
	}, {
		"link": "http:\/\/docs.oracle.com\/javase\/tutorial\/index.html"
	}, {
		"link": "https:\/\/javaserverfaces.java.net\/"
	}, {
		"link": "https:\/\/jsp.java.net\/"
	}, {
		"link": "http:\/\/search.maven.org\/"
	}, {
		"link": "https:\/\/docs.gradle.org\/current\/userguide\/userguide.html"
	}, {
		"link": "http:\/\/hibernate.org\/orm\/"
	}, {
		"link": "https:\/\/jax-ws.java.net\/"
	}, {
		"link": "https:\/\/jax-ws.java.net\/"
	}, {
		"link": "http:\/\/tomcat.apache.org\/tomcat-8.0-doc\/index.html"
	}, {
		"link": "https:\/\/jaxlondon.com\/?utm_source=mkyong.com&utm_medium=referral&utm_campaign=mediapartner"
	}, {
		"link": "http:\/\/www.javacodegeeks.com\/"
	}, {
		"link": "https:\/\/wordpress.org\/"
	}, {
		"link": "http:\/\/mkyong.com\/go\/liquidweb\/"
	}, {
		"link": "https:\/\/www.mkyong.com\/privacy-policy\/"
	}],
	"status": "OK"
}
              Search word in Website: url , searchWord and maxPagetoSearch are mandatory words for the below request.
                URL :  http://localhost:30001/searchcrawler
                 Rest Method: GET
                 Request Body: { 
	                    "url" :"https://www.google.com/",
	                     "searchWord" : "KIRAN",
	                       "maxPagetoSearch" :"5"
                           }

                 Response:
                      {"foundUrl":"https:\/\/www.mkyong.com\/","code":200,"status":"OK"}

Get Products Using 2 Prams:
                  This API is uses to GET rest method to fetch products Information from the Database or File (Currently for testing stored test data in test-data/products.json) using products id and name as path prams in the URL.
                 URL :  http://localhost:30001/products/{id}/{name}
                 Rest Method: GET
                 Request Body: NONE
                 Example : http://localhost:30001/products/1/cheese
                Response: 
                          {
	                     "code": "200",
	                     "data": "{\"price\":2.5,\"name\":\"Cheese\",\"location\":\"Refrigerated foods\",\"id\":\"1\"}",
	                      "status": "200 OK"
                            }
Identify Non repeated Character in String:
                This API is uses to GET rest method to identify Non repeated character in an inputString passed in path prams of the URL.
                   URL :  http://localhost:30001/products/{inputString}
                 Rest Method: GET
                 Request Body: NONE
                 Example : http://localhost:30001/products/1/cheese
                Response:  {"foundChar":"d"}

Read / Write Content in File:
                This API is uses to GET/ POST rest methods to read file content and write content, since special characters’ not allowed in request URL all the request parameters used in request body.
      Read File:  path is mandatory filed to retrieve file information.
                  URL :  http://localhost:30001/readfile 
                 Rest Method: GET
                 Request Body: { "path":"D:/samplefile1.txt" }
                 Response: {
			"code": 200,
			"fileData": "Writing in to File where it is exits...!Writing in to File where it is exits...!Writing in to File where it is exits...!",
			"status": "OK" 
                              }
       Write File:  To write into file we needed both path and data parameters are mandatory in request body.
                   URL :  http://localhost:30001/writefile 
                 Rest Method: POST
                 Request Body: { "path":"D:/samplefile1.txt", "data":"Writing in to File where it is exits...!"}
                 Response:   {
			"code": 200,
			"message": "Writing to a File is Successful..!",
			"status": "OK"
}  



 
