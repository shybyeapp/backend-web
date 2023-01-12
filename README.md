# shybye-backend

see frontend here https://github.com/gabw13/shybye-frontend

## Usage

**macOS**

1. Install and setup PostgreSQL with homebrew
    1. `brew install postgresql`
    1. `/usr/local/opt/postgres@<version>/bin/createuser -s postgres`
    1. `brew services start postgresql@<version>`
    1. `createdb shybyedb`
    1. `psql shybyedb < ./shy_bye.sql`
1. Install and setup Java 11
    1. `brew install java11`
    1. `sudo ln -sfn /usr/local/opt/openjdk@11/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-11.jdk`
1. `brew install maven`
1. `mvn clean install`
1. `java -jar ./target/*.jar`
