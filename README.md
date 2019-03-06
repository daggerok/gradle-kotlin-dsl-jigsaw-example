# java 9+ modules with jigsaw plugin
with Gradle Kotlin DSL build scripts (for some reasons not recognized in IDEA)

_make sure you have java 11 in your path_

```bash
jenv local 11.0
```

```bash
./gradlew clean installDist
bash ./app/build/install/app/bin/app
```
