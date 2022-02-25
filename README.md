# Martian-Robots
The surface of Mars can be modelled by a rectangular grid around which robots are able to move according to instructions provided from Earth. This respository contains a program that determines each sequence of robot positions and reports the final position of the robot.

## Running the Program
### Prerequisites
* [OpenJDK Eclipse Temurin 17](https://adoptium.net/?variant=openjdk17&jvmVariant=hotspot)
* [Maven](https://maven.apache.org/download.cgi)
  * [Add Maven to PATH](https://stackoverflow.com/questions/45119595/how-to-add-maven-to-the-path-variable)

### Steps

1. Download and unzip source code
2. Open Command Prompt in project root
3. Run command `mvn clean package`
4. Run command `java -jar target\Martian-Robots-1.0-SNAPSHOT.jar`


### Next steps:
- Add more tests for scent logic at different edge positions
- Accept user input in main method
- Design interfaces for Robot and Grid and implement interfaces in specialised classes e.g., MarsRobot, MarsGrid, BigRobot
- Include instructions for Mac developers