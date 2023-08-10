package ru.netology.BDD.page;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item");
    private String balanceStart = "баланс: ";
    private String balanceEnd = " р.";
    private SelenideElement replenishCard1 = cards.first().$("[data-test-id=action-deposit]");
    private SelenideElement replenishCard2 = cards.last().$("[data-test-id=action-deposit]");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public TransferPage card1Replenish() {
        replenishCard1.click();
        return new TransferPage();
    }

    public TransferPage card2Replenish() {
        replenishCard2.click();
        return new TransferPage();
    }

    public int getCard1Balance() {
        val text = cards.first().text();
        val start = text.indexOf(balanceStart);
        val end = text.indexOf(balanceEnd);
        val value = text.substring(start + balanceStart.length(), end);
        return Integer.parseInt(value);
    }

    public int getCard2Balance() {
        val text = cards.last().text();
        val start = text.indexOf(balanceStart);
        val end = text.indexOf(balanceEnd);
        val value = text.substring(start + balanceStart.length(), end);
        return Integer.parseInt(value);
    }
}