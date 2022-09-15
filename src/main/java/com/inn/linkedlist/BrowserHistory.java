package com.inn.linkedlist;

/*
 * Leetcode 1472
 * https://leetcode.com/problems/design-browser-history/
 */

class Page {
	String url;
	Page nextPage;
	Page prevPage;

	public Page(String url) {
		super();
		this.url = url;
		this.nextPage = null;
		this.prevPage = null;
	}
}

class BrowserHis {

	Page firstPage;
	Page lastPage;
	Page crntPage;
	
	public BrowserHis(String homepage) {
		Page page = new Page(homepage);
		firstPage = page;
		lastPage = page;
		crntPage = page;
	}

	public void visit(String url) {
		Page page = new Page(url);
		crntPage.nextPage = page;
		page.prevPage = crntPage;
		
		crntPage = page;
		lastPage = page;
	}

	public String back(int steps) {
		int counter = 0;
		while(counter < steps) {
			if(crntPage == firstPage) {
				return crntPage.url;
			}
			crntPage = crntPage.prevPage;
			counter++;
		}
		return crntPage.url;
	}

	public String forward(int steps) {
		int counter = 0;
		while(counter < steps) {
			if(crntPage == lastPage) {
				return crntPage.url;
			}
			crntPage = crntPage.nextPage;
			counter++;
		}
		return crntPage.url;
	}
}

public class BrowserHistory {

	public static void main(String[] args) {
		BrowserHis browserHis = new BrowserHis("fb.com");
		browserHis.visit("leetcode.com");
		browserHis.visit("google.com");
		browserHis.visit("yahoo.com");
		browserHis.visit("epam.com");
		browserHis.visit("mail.com");
		
		System.out.println(browserHis.back(1));
		System.out.println(browserHis.back(1));
		System.out.println(browserHis.back(10));
		
		System.out.println("================");
		System.out.println(browserHis.forward(1));
		System.out.println(browserHis.forward(1));
		System.out.println(browserHis.forward(1));
		System.out.println(browserHis.forward(1));
		System.out.println(browserHis.forward(1));
		System.out.println(browserHis.forward(1));
	}

}
