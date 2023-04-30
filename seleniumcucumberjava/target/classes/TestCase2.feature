Feature: TestCase2



  Scenario Outline: Verify User Can Add Pay Grades
    Given Navigate to login screen
    When enter username: "<userName>"
    And enter password: "<password>"
    And Click Login button
    And Click on Admin from side menu bar
    And Click Job dropdown
    And Click Pay Grades
    And Click green +Add button
    And Type "<payGradeName>" in the name input field
    And Click green Save button
    And Click green + Add button on the Currencies section
    And Select Indian Rupee from Current dropdown
    And Type Minimum Salary as "<miniSalary>"
    And Type Maximum Salary as "<maxiSalary>"
    And Click green Save button on Currencies section
    Then Verify user can observe the added records in the Currencies section "<miniSalary>" and "<maxiSalary>"

    Examples:
      | userName | password | payGradeName | miniSalary | maxiSalary |
      | Admin | admin123 | Indian Rupee  | 30000    |100000     |

