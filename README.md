bitcoinmonitor
==============

Monitors the bids in USD for bitcoin.

# Phase 1
* git clone git@github.com:cppwfs/bitcoinmonitor.git
* Go to the bitcoinmonitor directory
* Set JAVA_HOME environment variable to your java instance
* ./gradlew run -or- gradlew.bat run
* You should see Hello World

# Phase 2
* Let’s activate spring boot
* In your favorite editor open src/main/java/org/bitcoinmonitor/Main.java
* Remove the comment markers (//) from the lines of code beneath the “Phase 2” comment
* Save your changes
* ./gradlew run -or- gradlew.bat run
* Now you will have a file called bitcoin.txt available with both bitstamp and coinbase json data.

# Phase 3
1. Let’s activate Transformer
2. In your favorite editor open 
3.  src/main/java/org/bitcoinmonitor/Main.java 
4.  src/main/java/org/bitcoinmonitor/Transform.java
5.  Remove the comment markers (//) from the lines of code beneath the “Phase 3” comment
6.  Save your changes
7. In your favorite editor open 
8. src/main/resources/integration.xml
9. Remove the comment markers (<!-- -->) from the lines of code beneath the “Phase 3” comment
10. Now Let’s update the gateways so they will send their data to the transformer instead of the file outbound gateway.
11. For both the coinbasegateway and the bitstampgateway 
12. Set the reply-channel to the transformChannel
13. Save your changes
14. ./gradlew run -or- gradlew.bat run
15. Now bitcoin has the data in a common format.

# Setup Rabbit
## Windows Install
* Download/Install Earlang
 * http://www.erlang.org/download/otp_win32_R16B03-1.exe
* Download/Install RabbitMQ
 * http://www.rabbitmq.com/releases/rabbitmq-server/v3.2.3/rabbitmq-server-3.2.3.exe
* Select RabbitMQ Server from the menu
* Select RabbitMQ Command Prompt
* Type rabbitmq-plugins.bat enable rabbitmq_mqtt
* Right click run as admin on rabbitmq service – stop
* Right click run as admin  on rabbitmq service - start

## Mac Install
* Download
 * http://www.rabbitmq.com/releases/rabbitmq-server/v3.2.3/rabbitmq-server-mac-standalone-3.2.3.tar.gz
* untar/unzip rabbit to temp directory.  
* cd /rabbitmq_server-3.2.3/sbin
* Install MQTT
 * ./rabbitmq-plugins enable rabbitmq_mqtt
* Start Rabbit
 * ./rabbitmq-server start

# Phase 4

### Start MQTT Monitor

* Open another command window
* git clone git@github.com:cppwfs/mqttmonitor.git
* Go to the mqttmonitor directory
* ./gradlew run -or- gradlew.bat run

### Setup bitcoinmonitor to send data via MQTT

* Go back to the bitcoinmonitor directory
* In your favorite editor open 
* src/main/resources/integration.xml
* Remove the comment markers (<!-- - ->) from the lines of code beneath the “Phase 4” comment
* Set the transform output-channel from “files” to “mqttOut”

