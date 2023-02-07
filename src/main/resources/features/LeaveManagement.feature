Feature: MIS - Leave Management

  Background: Login into MIS
    Given User is logged into MIS using username and password
      | username      | password    |
      | shubham.kumar | Gemini@1234 |

  Scenario Outline: Navigate to Leave Management > Comp Off tab
    When User is on MIS Home Page
    And User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" displays

    Examples:
      | parentTab        | childTab | tab      | heading                                                  |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Verify Date and Reason are mandatory fields for Comp Off
    When User is on MIS Home Page
    And User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then User clicks on submit button for "<tab>"
    And Verify mandatory "dropdown" field for "<date>"
    And Verify mandatory "textArea" field for "<reason>"

    Examples:
      | parentTab        | childTab | tab      | heading                                                  | date        | reason        |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request | CompOffDate | CompOffReason |

  Scenario Outline: Select Date from Comp Off Date dropdown
    When User is on MIS Home Page
    And User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then select compOff date <dateIndex> for "<date>" field

    Examples:
      | parentTab        | childTab | tab      | heading                                                  | dateIndex | date        |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 1         | CompOffDate |

  Scenario Outline: Enter Reason for Comp off
    When User is on MIS Home Page
    And User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then enter compOff reason "<reasonMessage>" for "<reason>" field

    Examples:
      | parentTab        | childTab | tab      | heading                                                  | reasonMessage         | reason        |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request | Sample Reason Message | CompOffReason |

  @7thFeb
  Scenario Outline: Enter Data and submit Comp off
    When User is on MIS Home Page
    And User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then select compOff date <dateIndex> for "<date>" field
    Then enter compOff reason "<reasonMessage>" for "<reason>" field
    Then User clicks on submit button for "<tab>"
    And verify popup with message "<alertType>" and "<successMessage>"

    Examples:
      | parentTab        | childTab | tab      | heading                                                  | dateIndex | date        | reasonMessage         | reason        | alertType | successMessage                 |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 1         | CompOffDate | Sample Reason Message | CompOffReason | Success   | Request processed successfully |

  @7thFeb
  Scenario Outline: Navigate to Leave Management > Apply tab
    When User is on MIS Home Page
    And User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" displays

    Examples:
      | parentTab        | childTab | tab   | heading                                                  |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  @7thFeb
  Scenario Outline: Verify fields are Auto Populated by default on Leave tab
    When User is on MIS Home Page
    And User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    And Verify auto populated "textField" field for "<primaryContact>"
    And Verify auto populated "textField" field for "<otherContact>"

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | primaryContact     | otherContact          |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | leaveContactNumber | leaveAltContactNumber |

  @7thFeb
  Scenario Outline: Verify From,Till and Reason fields are mandatory fields for Leave Tab
    When User is on MIS Home Page
    And User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    And Verify auto populated "textField" field for "<primaryContact>"
    And Verify auto populated "textField" field for "<otherContact>"
    Then User clicks on submit button for "<tab>"
    And Verify mandatory "calender" field for "<fromDate>"
    And Verify mandatory "calender" field for "<tillDate>"
    And Verify mandatory "textArea" field for "<reason>"

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate      | tillDate      | reason      | primaryContact     | otherContact          |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | leaveFromDate | leaveTillDate | leaveReason | leaveContactNumber | leaveAltContactNumber |

  @7thFeb
  Scenario Outline: Select From and Till Leave date from Leave Calendar
    When User is on MIS Home Page
    And User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then enter leave "<fromDate>" for "<fromDateField>" field
    Then enter leave "<toDate>" for "<toDateField>" field

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate   | fromDateField | toDate     | toDateField   |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/15/2023 | leaveFromDate | 03/16/2023 | leaveTillDate |

  @7thFeb
  Scenario Outline: Verify Total Working Days tooltip from Leave Tab
    When User is on MIS Home Page
    And User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" displays
    Then enter leave "<fromDate>" for "<fromDateField>" field
    Then enter leave "<toDate>" for "<toDateField>" field
    And click total working days tool tip
    And verify tooltip message "<tooltipMessage>"

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate   | fromDateField | toDate     | toDateField   | tooltipMessage                                             |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/15/2023 | leaveFromDate | 03/16/2023 | leaveTillDate | For ML total days will be considered as total working days |
