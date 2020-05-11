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
////@UseTestDataFrom("src/test/resources/WikiTestData.csv")
//public class SearchByKeywordStoryDdt {
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
//    @Test
//    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
//        endUser.is_the_home_page();
//        endUser.looks_for("pear");
//        endUser.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
//    }
//
//    @Pending
//    @Test
//    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
//    }
//}
package lab5.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import lab5.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStoryDdt {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Issue("#WIKI-2")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("apple");
        anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");

    }

    @Test
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("pear");
        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
    }

//    @Pending @Test
//    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
//    }
}