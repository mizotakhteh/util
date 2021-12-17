# Util

## Initiate the Util Library

### 0. Spring CLI

Initiate the project using spring cli with these dependencies.

- **web**: Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

```sh
spring init \
    --build gradle \
    --java-version 17 \
    --dependencies web \
    --name util \
    --artifactId util \
    --groupId tk.decommerce \
    --force ./
```

### 1. Remove The Following Files & Folders

- `src/main/tk/decommerce/util/UtilApplication.java`
- `src/test/tk/decommerce/util/UtilApplicationTests.java`
- `src/main/resources`

### 2. Change `java` Plugin to `java-library` Plugin

```groovy
plugins {
//  id 'java'
    id 'java-library'
}
```

### 3. Add `maven-publish` Plugin

Add `maven-publish` plugin into `./build.gradle`.

```groovy
plugins {
    id 'maven-publish'
}

publishing {
    publications {
        library(MavenPublication) {
            artifact("build/libs/util-${version}-plain.jar") {
                extension "jar"
            }
        }
    }
    repositories {
        maven {
            url 'https://gitlab.com/api/v4/projects/31731660/packages/maven'
            name 'Gitlab'
            credentials(HttpHeaderCredentials) {
                name = 'Job-Token'
                value = System.getenv("CI_JOB_TOKEN")
            }
            authentication {
                header(HttpHeaderAuthentication)
            }
        }
    }
}
```
