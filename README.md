# Getting Started

### During start-up of the application, the following data will be initialized...
10 Hourly employees named as:
* Hourly[1]...Hourly[10]

10 Salaried employees named as:
* Salaried[1]...Salaried[10]

10 Hourly employees named as:
* Manager[1]...Manager[10]

### Sample URLs

To set worked days for Hourly1 employee to 260 days:
* http://localhost:8080/vacation/worked-days/employee/Hourly1?workedDays=260

To set vacations days for Hourly1 employee to 1:
* http://localhost:8080/vacation/take-vacation/employee/Hourly1?vacationDaysUsed=1

To Set 130 worked days for Hourly5 employee
* http://localhost:8080/vacation/worked-days/employee/Hourly5?workedDays=130

To Set 5 vacation days for Hourly5 employee
* http://localhost:8080/vacation/take-vacation/employee/Hourly5?vacationDaysUsed=5


Same pattern follows for Salaried and Manager employees:
* http://localhost:8080/vacation/worked-days/employee/Salaried10?workedDays=100
* http://localhost:8080/vacation/take-vacation/employee/Salaried5?vacationDaysUsed=4

* http://localhost:8080/vacation/worked-days/employee/Manager2?workedDays=200
* http://localhost:8080/vacation/take-vacation/employee/Manager7?vacationDaysUsed=3


### To get the status of each employee:
* http://localhost:8080/vacation/report
