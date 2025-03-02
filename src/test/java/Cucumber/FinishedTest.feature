Feature: Visa Order

  Background:
    Given I am landed on visa page

  @FinishedTest
  Scenario Outline: Positive test of submitting the visa order
    Given Inserting from country <negaraAsal> and to country <negaraTujuan> and current date
    Given Enter first name <firstName> and last name <lastName> and Enter email <email> and phone number <phoneNumber> and with duration <visaDays> and entry type <entry> and Select visa type <visa> and Add notes <notes>
    Then I should see the confirmation message <expectedText>

    Examples:
      | negaraAsal | negaraTujuan | firstName | lastName | email             | phoneNumber | visaDays | entry    | visa       | notes          | expectedText                                                                                                                  |
      | Somalia    | Japan        | ismail    | ismail   | uE8oH@example.com | 08123456789 | 90       | multiple | study_visa | THIS IS A NOTE | We have received your visa details, and one of our representatives will contact you shortly. Your visa registration number is |