# Running Acceptance Tests

* To run the acceptance tests in a local server.

      ./gradlew clean test

* To run the acceptance tests in a custom server.

      ./gradlew clean test -Prest.service.url=http://server_name:8080 

# Generate Cucumber HTML Report

* To generate HTML awesome report.

      ./gradlew cucumber

* You can find the report under 

      build\reports\cucumber-html-reports
