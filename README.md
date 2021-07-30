# Oracle Generate Customer Reports
Given an input file containing multiple lines. Each line has Customer information separated by ",".
The project parse the data and generate reports.

## Compile, Run and Test
Compile the application:
* `./gradlew assemble`

Run the application:
* `./gradlew run`  (This takes SampleData.txt as default file) OR
* `./gradlew run --args="<fileName>"`

SampleData.txt file is available (at "src/main/resources" folder).

Test the application
* `./gradlew test`

### Libraries and Tools used for Development
* Java 1.8+
* Gradle
* JUnit 5
* Intellij

### Class information:
Customer:
* This class holds valid Customer information.

CustomerFieldType:
* This enum have Customer information field types.

CustomerDataMainApp:
* The main application which reads file, parse data and create Customers.

IReport:
* interface to generate the reports

UniqueCustomersPerContractId:
* Generates the report of unique customers per contract id.

UniqueCustomersPerGeoZone:
* Generates the report of unique customers per Geo Zone.

AvgBuildDurationPerGeoZone:
* Generates the report of average build duration per Geo Zone.

UniqueCustomersListPerGeoZone
* Generates the report of unique customers list per Geo Zone.

PrintUtil
* Print the information. As the challenge says use minimum libraries. Not using logger libraries.

FilterCustomer:
* Filters duplicate Customer records by given key.

### Further Improvements:
* Use the logger for logging.
* Generate reports in XML, JSON formats
* Rather than reading the file at once, read and parse it in parts for faster response.
* Make the report service as continuous running. So that, on file update new reports will be generated.
