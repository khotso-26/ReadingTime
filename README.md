# REST API Reading Time Application
The REST API Reading Time Application is a Java-based application built with Spring Boot. It allows users to retrieve estimated reading times for texts or documents.

## Features
- Calculate estimated reading time for a given text or document.
- Supports various formats: plain text, Markdown, HTML, etc.
- Configurable reading speed.
- RESTful API for easy integration with other applications.

## Prerequisites
Before running the application, ensure you have the following dependencies installed:
- Java Development Kit (JDK) 8 or higher
- Maven

## Installation
1. Clone the repository or download the source code.
2. Open a terminal and navigate to the project directory.
3. Run the following command to build the project:
```mvn clean install```
4. After a successful build, start the application:
```java -jar target/reading-time-api.jar```

## API Endpoints
### Calculate Reading Time

Endpoint: `/api.readingtime/v1`
Method: POST

### Request Payload:
json
`{
    "title" : "The big bang theory"
    "body": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
}`

Response:
`{
    "readingTime": {
        "minutes": 1,
        "seconds": 30
    }
}`

## Configuration
The application provides the ability to configure the reading speed (words per minute). By default, the reading speed is set to 200 words per minute.

To modify the reading speed, open the *application.properties* file and update the following property:
```app.reading-speed=200```

## Usage Examples
You can use any HTTP client to interact with the API endpoints. Here are a few examples using curl:

1. Calculate reading time for a text file:

``` curl -X POST -H "Content-Type: application/json" -d '{"text": "Lorem ipsum dolor sit amet."}' http://localhost:8080/api.readingtime/v1```

2. Calculate reading time for an HTML document:

``` curl -X POST -H "Content-Type: application/json" -d '{"text": "<h1>Lorem ipsum</h1><p>Dolor sit amet.</p>"}' http://localhost:8080/api.readingtime/v1```

## Contributing
Contributions are welcome! If you would like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push the branch to your fork.
4. Submit a pull request with a description of your changes.

## License
This project is licensed under the MIT License.

Feel free to customize the README file as per your specific application requirements and add any additional sections that might be relevant