# В двух словах #

Удобный хинт для работы с mongoDB: используем у себя в проекте.

Для mongo-админки надо :
  * поставить apache2
  * поставить php5
  * поставить дополнения для php от mongo
  * скачать файлик **`moadmin.php`** [с официального сайта](http://www.phpmoadmin.com/) и положить его себе в **`/var/www/`**

## Обо всем по порядку ##

  1. Поставить себе все, что потребуется для админки:
```
sudo apt-get install php5 php5-dev php-pear apache2
```
  1. Поставить себе расширение php5 для mongoDB:
```
sudo pecl install mongo
```
  1. Подключить расширение mongo в php; для этого надо прописать строчку "extension=mongo.so" в конец файла php.ini:
```
sudo vim /etc/php5/apache2/php.ini
```
  1. Сохраняем, закрываем
  1. Выкачиваем файлик с php-шкой и кладем ее себе в **`/var/www/`**
```
wget -O moadmin.zip http://www.phpmoadmin.com/file/phpmoadmin.zip
unzip moadmin.zip
sudo mv moadmin.php /var/www/
```
  1. Перезапускаем сервер apache:
```
sudo /etc/init.d/apache2 restart 
```
  1. Радуемся жизни по адресу http://127.0.0.1/moadmin.php