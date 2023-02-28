package com.joaquinonsoft.fnmt.scraper;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FNMTShopCategoryScraper {
	private static final String FNMT_URL_BASE = "https://tienda.fnmt.es";
	private static final String FNMT_CATEGORIES_URL = FNMT_URL_BASE + "/fnmttv/fnmt/es/Productos/Monedas/c/1000";
	
	protected static final Log log = LogFactory.getLog(FNMTShopCategoryScraper.class);
	
	/**
	 * 
	 * @return
	 * @see https://jsoup.org/cookbook/extracting-data/example-list-links
	 * @see https://jsoup.org/cookbook/extracting-data/selector-syntax
	 */
	public List<String> getCategoryURLs(){
		List<String> urls = null;
		
        try {
			Document doc = Jsoup.connect(FNMT_CATEGORIES_URL).get();
			// direct <a> after <span class="facet__text">
			Elements eLinks = doc.select("span.facet__text > a[href]");
			
			if(eLinks != null && eLinks.size() > 0) {
				urls = new LinkedList<String>();
				
				for(Element link: eLinks) {
					urls.add(FNMT_URL_BASE + link.attr("href"));
				}
			}
		} catch (IOException e) {
			log.error("Error parsing FNMT shop categories: ",e);
		}

		
		return urls;
	}
}
