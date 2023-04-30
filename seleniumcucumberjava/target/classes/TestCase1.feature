Feature: TestCase1



  Scenario Outline: Verify User Can Search with Partial Text
    Given Navigate to login screen
    When enter username: "<username>"
    And enter password: "<password>"
    And Click Login button
    And Click on PIM from side menu bar
    And Type "<EmployeeName>" in the Employee Name text input field
    And Click on green Search button
    Then The system will display results of records found

    Examples:
      | username | password | EmployeeName |
      | Admin | admin123 | ch             |

