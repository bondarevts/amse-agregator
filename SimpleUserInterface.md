## `TomCat` ##

_Пока нет интерфейса, попользуем томкат с сервлетами.._

### Установка ###

  1. Скачиваем с [офицального сайта](http://tomcat.apache.org/download-70.cgi) **apache tomcat** - [под линукс, версия 7](http://www.sai.msu.su/apache//tomcat/tomcat-7/v7.0.4-beta/bin/apache-tomcat-7.0.4.tar.gz).
```
wget -O tomcat7.tgz http://www.sai.msu.su/apache//tomcat/tomcat-7/v7.0.4-beta/bin/apache-tomcat-7.0.4.tar.gz
```
  1. Распаковываем содержимое архива.
```
tar xzf tomcat7.tgz
```
  1. Переходим в распакованную папку.
```
cd apache-tomcat-7.0.4
```
  1. Запускаем сервер tomcat
```
./bin/startup.sh
```
> По умолчанию сервер будет на порту 8080, т.е. теперь вы на него можете попасть так - http://localhost:8080/

  * Для остановки сервера выполните
```
./bin/shutdown.sh
```
  * Для рестарта соответсвенно **(перезапуск сервера необходим после каждого добавления/изменения файлов, иначе не увидите их.)**
```
./bin/shutdown.sh && ./bin/startup.sh
```

В папке **lib** находятся необходимые нам джава библиотечки, для написания сервлета.

## Servlet ##
Нужно будет подключить lib/servlet-api.jar к проекту.
Исходный код нашего сервлета берем тут - svn/trunk/tomcat/SimpleGui.java

Для запуска нашего сервлета на сервере tomcat, нужно положить всю папку из svn/trunk/tomcat/WEB-INF в webapps/ROOT/WEB-INF с полной заменой оригинала всего содержимого.

Не забываем перезапустить сервер:
```
./bin/shutdown.sh && ./bin/startup.sh
```

И теперь наш сервлет доступен по адресу http://localhost:8080/SimpleGui

Все это настраивается в файле WEB-INF/web.xml, а скомпилированный исполняемый(.class) файл сервлета лежит в папке WEB-INF/classes.

_Сейчас этот сервлет только принимает запрос от пользователя и ничего не делает, хочется прикрутить туда взаимодействие с поиском._