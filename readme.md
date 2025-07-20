# 🧪 Selenium Framework

Selenium WebDriver framework using Page Object Model and powered by Cucumber Reports.

---

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Gradle 8+
- Google Chrome installed

---

### Clone the Project

```bash
git clone https://github.com/edwinchp/selenium-gradle.git
cd selenium-gradle
```


### Run some tests
```bash
gradle clean test --tests "runner.TestRunnerSmoke"
```


### Run some remote tests in LambdaTest platform
```bash
gradle clean test --tests "runner.TestRunnerSmoke" -Dbrowser=lambda-test -DLT_USERNAME=myusername -DLT_ACCESS_KEY=12345
```