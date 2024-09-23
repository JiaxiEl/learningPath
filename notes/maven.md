# Maven

## Maven
  - Manage Dependencies
  - Build Project
  - Documentation
  - Reporting
  - Versioning and Compatibility


## Maven Liftcycle Phase
- validate: Check if the project structure is correct and that all necessary information is available
- compile: Complies the source code of the project. It takes the Java files from src/main/java directory and compiles them into bytecode, and placing the compiled class in the target/class directory
- test: the unit tests (src/test/java) are executed. It uses frameworks like Junit, TestNG
- package: This phase packages the compiled code into a distributable format, such as .jar or .war. It creates an executable artifact that can be shared or deployed
- verify: runs additional check to ensure the integrity and validity of the package. This could include integration test or other quality checks.
- install: installs the packaged artifact into the local Maven repository(~/.m2/repository)
- deploy: copies the final package to a remote repository, making it available to other developers or porjects.


## pom.xml
```
<groupId>com.example<groupId>
<artifactId>oms<artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>jar<packaging>
```
- groupId
- artifactId
- version
- packaging
- output:oms-1.0-SNAPSHOT.jar


## Maven Repositories:
- local repository:$HOME/.m2/repository
- settings.xml or pom.xml 


## Snapshot Repository:
- A snapshot version is a version that has not yet been released.


## Scope
- compile: Default scope, required for both compile and runtime
- provided: Required at the compile time 
- runtime: Required at runtime but not for compile
- test: Required only for compiling and running tests
- system: similar to provided, but the JAR is explicitly referenced vai systemPath
- import: Used Only in <dependencyManagement> to import a BOM


## Parent vs Child POM
- version management: Child project does not need to specify the explicit version
- ensure that all child projects use the same version and configuration for build plugins

**Plugin Management**:
```aiignore
<build>
  <pluginManagement>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
  </pluginManagement>
</build>

```
**Build Configuration**:
```aiignore
<build>
  <defaultGoal>install</defaultGoal>
  <resources>
    <resource>
      <directory>src/main/resources</directory>
    </resource>
  </resources>
</build>

```
**Property Management**:
```aiignore
<properties>
  <java.version>1.8</java.version>
  <maven.compiler.source>${java.version}</maven.compiler.source>
  <maven.compiler.target>${java.version}</maven.compiler.target>
</properties>

```

**Reporting Configuration**:
```
<reporting>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-report-plugin</artifactId>
      <version>2.22.0</version>
    </plugin>
  </plugins>
</reporting>

```
**Profiles**:
```aiignore
<profiles>
  <profile>
    <id>production</id>
    <properties>
      <env>prod</env>
    </properties>
    <build>
      <finalName>project-${env}</finalName>
    </build>
  </profile>
</profiles>

```
**Common Modules**:
```aiignore
<modules>
  <module>module-a</module>
  <module>module-b</module>
</modules>

```


**Properties**:
${mysql-connector.version} use the value confiured in properties