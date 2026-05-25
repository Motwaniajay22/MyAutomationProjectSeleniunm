package com.tutorialsninja.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tutorialsninja.base.BaseTest;
import com.tutorialsninja.pageobjects.AccountPage;
import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.LoginPage;
import com.tutorialsninja.pageobjects.ProductDetailPage;
import com.tutorialsninja.pageobjects.ProductSearchPage;

public class RandomTest extends BaseTest {
	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;
	ProductSearchPage productsearchpage;
	ProductDetailPage productdetailpage;
	
	@Test
	public void verifyAddAndRemoveProduc() {
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();
		
		loginpage = new LoginPage(driver);
		loginpage.login(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		
		accountpage = new AccountPage(driver);
		accountpage.searchText("HP");
		accountpage.searchButton();
		
		productsearchpage = new ProductSearchPage(driver);
		productsearchpage.addToCartProductClick();
		
		productdetailpage = new ProductDetailPage(driver);
		productdetailpage.productDetailAddToCart();
		System.out.println(productdetailpage.successProductDetailMsg());
		
		
		
	}

}
