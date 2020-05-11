//package lab5.features.search;
//
//import lab5.steps.serenity.EndUserSteps;
//import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
//import net.serenitybdd.junit.runners.SerenityRunner;
//import net.thucydides.core.annotations.*;
//import net.thucydides.core.pages.Pages;
//import net.thucydides.junit.annotations.UseTestDataFrom;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.WebDriver;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("src/test/resources/WikiTestData.csv")
//public class SearchByKeywordStory {
//
//    @Managed(uniqueSession = true)
//    public WebDriver webdriver;
//
//    @ManagedPages(defaultUrl = "http://en.wiktionary.org/wiki/Wiktionary")
//    public Pages pages;
//
//    public String name;
//    public String definition;
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDefinition() {
//        return definition;
//    }
//
//    @Qualifier
//    public String getQualifier() {
//        return name;
//    }
//
//    @Steps
//    public EndUserSteps endUser;
//
//    @Issue("#WIKI-1")
//    @Test
//    public void searchingWikiByKeywordTestDDT() {
//        System.out.println("getName() = " + getName());
//        System.out.println("getDefinition() = " + getDefinition());
//        System.out.println("getQualifier() = " + getQualifier());
//        endUser.is_the_home_page();
//        endUser.looks_for(getName());
//        endUser.should_see_definition(getDefinition());
//    }
//}