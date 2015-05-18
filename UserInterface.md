**Будут использованы следующие технологии:**
  * html
  * xslt-преобразование
  * framework [XFrеsh](https://github.com/smarthoas/xfresh)

Мы больше не используем Tomcat.
GUI собирается на данный момент отдельным build-файлом build-gui.xml (Скоро объединим)
Прежде чем выполнить этот билд, выполните основной.
```
 ant
 ant -file build-gui.xml
```
После этого в папке build есть скрипт start.sh который запускает сервер на порту указанном в файле beans.xml
```
 ./start.sh
```
Открываем в браузере главную страницу проекта:
```
 localhost:8080/attractions.xml 
```

That's all.