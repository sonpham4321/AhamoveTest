Feature: Register


Scenario: Register new account
Given go to sign up page
When fill out account information
Then complete register

Scenario: Login
Given Go to login page
Then login with phone name that already register

Examples:
|name                  |phoneNumber|email                       |code  |
|Pham Vu Lam Truong Son|0973591723 |sonphamlearning221@gmail.com|700000|