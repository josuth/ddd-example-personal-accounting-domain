# ddd-example-personal-accounting-domain
A simple example of a model for a personal accounting application.

Maybe the terms are not very tight. It is an example of a very informal domestic accounting. The goal is to model following the principles of Domain Driven Design.

Ubicuous language:
- Budget: it is a group of entries which define the expected amounts to enter or spend
- CashFlow: it is a group of entries which define the movements of cash in one or several accounts.
- Account: the money is grouped in one or several accounts.

Entities:
- Budget
- CashFlow
- BudgetTracking

Object Values: 
- Account
- Category
- Entry
- EntryBudget
- EntryType

Aggregates:
- Budget -> (EntryBudget)
- CashFlow -> (Account, Entry)

Domain Services:
- BudgetTracking: calculate different compliance goals.


The rules of the domain are validated by the unit tests.
