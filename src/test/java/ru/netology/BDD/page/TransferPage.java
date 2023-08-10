package ru.netology.BDD.page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.BDD.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement heading = $("[data-test-id='dashboard']");
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement cardFrom = $("[data-test-id='from'] input");
    private SelenideElement replenish = $("[data-test-id='action-transfer']");
    private SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    public TransferPage() { heading.shouldBe(Condition.visible); }

    public void transferCardToCard(DataHelper.CardInfo cardInfo, String sum) {
        amountField.setValue(sum);
        cardFrom.setValue(cardInfo.getCardFrom());
        replenish.click();
    }

    public String errorNotification() {
        errorNotification.shouldBe(Condition.visible);
        String text = errorNotification.getText();
        return text;
    }
}