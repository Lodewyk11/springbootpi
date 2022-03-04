# springbootpi
This project uses Spring boot with Springfox Swagger to expose a service that toggles an LED on a Raspberry Pi.

This project will NOT run on a x86 architecture machine. Supported platforms include:
 - Raspberry Pi
 - BananaPi
 - Odroid


## Getting Started

This section will get you up and running with this project assuming that you a re using a Raspberry Pi 2 model B+

### Prerequisites and building

You will need a Raspberry Pi set up and connected and you should be able to ssh into it either using PuTTy in Windows or OpenSSH in Linux.

You will also need Maven installed.

Then navigate to the following maven command or run the equivelant command from your favourite IDE to build the project:

```
mvn clean install
```

### Copying to the Raspberry Pi and running

Assuming that you have built the project in the previous step. You should now have a jozijug.jar file in the /target directory. Copy the jozijug-1.0.0.jar file to the Raspberry Pi. You can use secure copy (scp) on Linux or WinSCP on Windows. Alternatively, you can set up FTTP between your PC and the Raspberry Pi.

SCP copy command in Linux. Assuming you are in the root directory of the repo, and are using the default credentials for the Raspberry Pi with the Pi having an IP address of <IP_address>:

```
cd target
scp jozijug-1.0.0.jar pi@<IP_address>/home/pi/jozijug-1.0.1.jar 
```

You can now SSH into the Raspberry Pi and start the Springboot container using the following command:

```
java -jar jozijug-1.0.0.jar
```
The server should start up and you should see the following in the terminal followed by more information:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.3.3.RELEASE)
```
You can now access the Swagger UI console at the following address through a web browser:

http://IP_ADDRESS:9001/swagger-ui.html

## Notes on the LED circuit
This code assumes that an LED is connected to the Pi4J pin ```GPIO_001```. Refer to the Pi4J  [pin numbering](http://pi4j.com/usage.html#Pin_Numbering) section in the usage page for more information on pin numbering schemes for your Pi model.
