package com.joaquinonsoft.fnmt.scraper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class FNMTShopCategoryScraperTest {

	@Test
	public void getCategoryURLs() {
		FNMTShopCategoryScraper scrapper = new FNMTShopCategoryScraper();
		List<String> links = scrapper.getCategoryURLs();
			
		assertNotNull(links);
		assertTrue(links.size() > 0);
		assertEquals("https://tienda.fnmt.es/fnmttv/fnmt/es/Productos/Monedas/c/1000?q=%3Arelevance%3Acategory%3A1200&text=", links.get(0));
	}
}
