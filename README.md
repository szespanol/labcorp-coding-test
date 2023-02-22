# Getting Started

### During start-up of the application, the following data will be initialized...
10 Hourly employees named as:
* Hourly1...Hourly10

10 Salaried employees named as:
* Salaried1...Salaried10

10 Hourly employees named as:
* Manager1...Manager10

###  URLs

To enter the worked days of employee:
* http://localhost:8080/vacation/worked-days
  * POST
    * JSON Request Body:  {
"name":"Hourly1",
"numberOfDays":"260"
}

To enter the vacation used by employee:
* http://localhost:8080/vacation/take-vacation
  * POST
      * JSON Request Body:  {
        "name":"Salaried10",
        "numberOfDays":"5"
        }
  
To get the status of all employees:
* http://localhost:8080/vacation/report
  * GET