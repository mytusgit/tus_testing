Feature: Assert right scalene triangle
Scenario: Calculation by the parameter of two sides and one angle of a triangle
Given I open Triangle Calculator
When I clear all param
And I set value "90" for "A"
And I set value "8" for "side b"
And I set value "10" for "side a"
And I click button "Calculate"
Then The calculated result is "Right Scalene Triangle"