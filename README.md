
Тестируем веб-сайт
https://planetazdorovo.ru/

Используемые технологии
Java, Selenide, Selenoid, Gradle, JUnit5, Allure Report, Allure TestOps, Github, Jenkins, Telegram, Slack, Jira.

Описание
Разработаны UI тесты с использованием Selenide.

Тесты запуcкаются из CI системы Jenkins

В результате запуска автотестов формируется отчет в Allure reports, Allure TestOps
Автоматически создаются тест-кейсы по шагам автоматизированных тестов

Уведомление с отчетом о прохождении тестов отправлено в Telegram, Slack

Скриншоты и видео приложены к пройденным тестам

# Allure TestOps

![image](https://user-images.githubusercontent.com/46926736/124672614-02faa580-dec0-11eb-87a0-e59d5d6d7277.png)

Allure TestOps запуски
![image](https://user-images.githubusercontent.com/46926736/124670696-09d3e900-debd-11eb-8f3e-06692ea57bcb.png)

Allure TestOps тест-кейсы
![image](https://user-images.githubusercontent.com/46926736/124671008-7949d880-debd-11eb-9605-6a2eb09fb834.png)

# Уведомления

telegram

![image](https://user-images.githubusercontent.com/46926736/124669670-73eb8e80-debb-11eb-827c-13fca663a180.png)

Slack

![image](https://user-images.githubusercontent.com/46926736/124670266-671b6a80-debc-11eb-8e75-f55c3de51c14.png)

# Ссылки
Jenkins
https://jenkins.autotests.cloud/job/c05-arina-ng-lesson11v3

Allure reports
https://allure.autotests.cloud/project/250/launches

# Пример для запуска

### Для удаленного запуска необходимо заполнить файл remote.properties или передать параметры в командной строке:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)

Run tests with filled remote.properties:
```bash
gradle clean test
```

Run tests with not filled remote.properties:
```bash
gradle clean test -DremoteDriverUrl=https://username:password@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dbrowser=chrome
```


