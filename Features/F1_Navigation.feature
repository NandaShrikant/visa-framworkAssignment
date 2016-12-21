Feature: Application Navigation
Description: This feature will test application navigation

Background:
Given a user launches the application

@MenuSelect
Scenario Outline: select menu items
When a user selects "<menu item>" from the menu
Then the correct "<page>" is displayed
And the main menu is available

Examples:
| menu item 				| page 				|
| home 						| home 				|
| all products 				| product category 	|
| product category - iMacs 	| iMacs 			|
| product category - iPods 	| iPods 			|