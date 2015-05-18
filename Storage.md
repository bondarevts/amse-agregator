# Хранилище #

---

**Архив с намайненной базой можно взять [тут](http://amse-agregator.googlecode.com/files/data17k_votpusk.ru.zip)**

---

## Установка и настройка MongoDB ##
### Сервер MongoDB ###
_Всё очень просто и сводится к обычной распаковке архива и запуску, но все же:_
  1. Скачиваем последнюю стабильную версию под свою систему с [официального сайта](http://www.mongodb.org/downloads) MongoDB. Мы используем версию [1.6.3-linux32bit](http://fastdl.mongodb.org/linux/mongodb-linux-i686-1.6.3.tgz).
```
wget -O mongo.tgz http://fastdl.mongodb.org/linux/mongodb-linux-i686-1.6.3.tgz
```
  1. Распаковываем содержимое архива.
```
tar xzf mongo.tgz
```
  1. Переходим в распакованный каталог _mongodb-linux-i686-1.6.3_
```
cd mongodb-linux-i686-1.6.3
```
  1. Создаем директорию, в которой будет храниться наша база.
```
mkdir data
```
  1. Запускаем сервер базы данных, указывая желаемую директорию с базой (параметр --dbpath)
```
./bin/mongod --dbpath data
```

### MongoDB & Java ###
Для взаимодействия с сервером MongoDB из нашей Java-программы, необходимо скачать [Java-драйвер](http://github.com/mongodb/mongo-java-driver/downloads).<br>
Мы пользуемся последней на данный момент версией - <del><a href='http://github.com/downloads/mongodb/mongo-java-driver/mongo-2.2.jar'>mongo-2.2.jar</a></del> <a href='http://github.com/downloads/mongodb/mongo-java-driver/mongo-2.3.jar'>mongo-2.3.jar</a> - New!<br>
<br>
Затем полученный .jar файл, нужно либо положить в ваш <i>classpath</i>, либо подключить его в вашей IDE.<br>
<br>
Например в <i>eclipse</i>, это можно сделать в параметрах вашего проекта:<br>
<blockquote><i>Project - Properties - Java Build Path - Libraries - Add External JARs</i>
<hr />
<h2>Типы объектов</h2></blockquote>

<h3>Страна - <code>Type: Country</code></h3>
<pre><code> Название - Name : String<br>
 Описание - Description : String<br>
 Фотографии - Photos : ArrayList&lt;String&gt; - ?<br>
 Ключевые слова - KeyWords : ArrayList&lt;String&gt;<br>
</code></pre>

<h3>Город - <code>Type: City</code></h3>
<pre><code> Название - Name : String<br>
 Описание - Description : String<br>
 Страна - Country : ObjectId<br>
 Ключевые слова - KeyWords : ArrayList&lt;String&gt;<br>
 Координаты - Coordinates : Point2D.Double - ?<br>
 Фотографии - Photos : ArrayList&lt;String&gt; - ?<br>
</code></pre>

<h3>Архитектурная Достопримечательность - <code>Type: ArchAttraction</code></h3>
<pre><code> Название - Name : String<br>
 Описание - Description : String<br>
 Ключевые слова - KeyWords : ArrayList&lt;String&gt;<br>
 Координаты - Coordinates : Point2D.Double - ?<br>
 Фотографии - Photos : ArrayList&lt;String&gt; - ?<br>
 Город - City : ObjectId - ?<br>
 Страна - Country : ObjectId - ?<br>
 Дата основания - Date : Date - ?<br>
 Архитектор - Architect : String - ?<br>
 Цена - Cost : String - ?<br>
 Адрес - Address : String - ?<br>
</code></pre>

<h3>Природная Достопримечательность - <code>Type: NaturalAttraction</code></h3>
<pre><code> Название - Name : String<br>
 Описание - Description : String<br>
 Ключевые слова - KeyWords : ArrayList&lt;String&gt;<br>
 Координаты - Coordinates : Point2D.Double - ?<br>
 Фотографии - Photos : ArrayList&lt;String&gt; - ?<br>
 Ближайший город - City : ObjectId - ?<br>
 Страна - Country : ObjectId - ?<br>
</code></pre>

<h3>Музей - <code>Type: Museum</code></h3>
<pre><code> Название - Name : String<br>
 Описание - Description : String<br>
 Ключевые слова - KeyWords : ArrayList&lt;String&gt;<br>
 Город - City : ObjectId<br>
 Страна - Country : ObjectId<br>
 Координаты - Coordinates : Point2D.Double - ?<br>
 Фотографии - Photos : ArrayList&lt;String&gt; - ?<br>
 Цена - Cost : String - ?<br>
 Адрес - Address : String - ?<br>
</code></pre>


<h3>Развлечения - <code>Type: Entertainment</code></h3>
<pre><code> Название - Name : String<br>
 Описание - Description : String<br>
 Ключевые слова - KeyWords : ArrayList&lt;String&gt;<br>
 Город - City : ObjectId<br>
 Страна - Country : ObjectId<br>
 Координаты - Coordinates : Point2D.Double - ?<br>
 Фотографии - Photos : ArrayList&lt;String&gt; - ?<br>
 Цена - Cost : String - ?<br>
 Адрес - Address : String - ?<br>
</code></pre>

<h3>Шопинг - <code>Type: Shopping</code></h3>
<pre><code> Название - Name : String<br>
 Описание - Description : String<br>
 Ключевые слова - KeyWords : ArrayList&lt;String&gt;<br>
 Город - City : ObjectId<br>
 Страна - Country : ObjectId<br>
 Координаты - Coordinates : Point2D.Double - ?<br>
 Фотографии - Photos : ArrayList&lt;String&gt; - ?<br>
 Цена - Cost : String - ?<br>
 Адрес - Address : String - ?<br>
</code></pre>

<h3>Отель - <code>Type: Hotel</code></h3>
<pre><code> Название - Name : String<br>
 Описание - Description : String<br>
 Ключевые слова - KeyWords : ArrayList&lt;String&gt;<br>
 Город - City : ObjectId<br>
 Страна - Country : ObjectId<br>
 Категория - Category : String - ? //Гостиница, 5* Отель и т.д.<br>
 Координаты - Coordinates : Point2D.Double - ?<br>
 Фотографии - Photos : ArrayList&lt;String&gt; - ?<br>
 Сайт - Website : String - ?<br>
 Тип Номеров - Rooms : String - ?<br>
</code></pre>

<h3>Кафе - <code>Type: Cafe</code></h3>
<pre><code> Название - Name : String<br>
 Описание - Description : String<br>
 Ключевые слова - KeyWords : ArrayList&lt;String&gt;<br>
 Город - City : ObjectId<br>
 Страна - Country : ObjectId<br>
 Категория - Category : String - ?<br>
 Координаты - Coordinates : Point2D.Double - ?<br>
 Фотографии - Photos : ArrayList&lt;String&gt; - ?<br>
 Сайт - Website : String - ?<br>
 Музыка - Music : String - ?<br>
</code></pre>

<hr />
<h2>Основные методы взаимодействия с базой</h2>
<i>Методы, предоставляющие возможность добавления, удаления и редактирования элементов базы.</i>

Все описанные методы являются <b>статическими</b> и принадлежат классу <code>DataBase</code>

<h4>Основные общедоступные статические константы:</h4>
<pre><code>//Адрес сервера MongoDB по умолчанию (localhost)<br>
DataBase.DB_SERVER_ADDRESS : String<br>
<br>
//Номер порта сервера MongoDB по умолчанию (27017)<br>
DataBase.DB_SERVER_PORT : int<br>
<br>
//Название главной(чистой) базы (mainDB)<br>
DataBase.MAIN_DB_NAME : String<br>
<br>
//Название сырой(грязной) базы (dirtyDB)<br>
DataBase.DIRTY_DB_NAME : String<br>
</code></pre>

<h4>Установка соединения с сервером MongoDB и подключение к <b>сырой</b> базе.</h4>
<pre><code>void DataBase.connectToDirtyBase();<br>
</code></pre>

<h4>Установка соединения с сервером MongoDB и подключение к <b>главной(чистой)</b> базе.</h4>
<pre><code>void DataBase.connectToMainBase();<br>
</code></pre>

<h4>Переключение на заданную базу.</h4>
<pre><code>void DataBase.switchBaseTo(String dbName);<br>
</code></pre>

<h4>Печать на стандартный вывод всего содержимого базы.</h4>
<pre><code>void DataBase.printAll();<br>
</code></pre>

<h4>Добавление в базу. Возвращает id добавленного в базу объекта.</h4>
<pre><code>ObjectId DataBase.add(DBWrapper storageObject);<br>
</code></pre>

<h4>Получение объекта из базы, по его id. Если объекта с указанным id не найдено, то возвращается null.</h4>
<pre><code>DBWrapper getDBObjectById(ObjectId id);<br>
</code></pre>

<h4>Получение списка из всех элементов базы</h4>
<pre><code>ArrayList&lt;DBWrapper&gt; getAllDBObjects();<br>
</code></pre>

<h4>Получение списка из городов имеющихся в базе</h4>
<pre><code>ArrayList&lt;DBWrapper&gt; getAllCities();<br>
</code></pre>

<h4>Получение списка из всех элементов базы, заданного типа</h4>
<pre><code>ArrayList&lt;DBWrapper&gt; getAllWithType(String type);<br>
</code></pre>

<h4>Получение id города, по его названию. Если город не найден, то возвращается null.</h4>
<pre><code>ObjectId DataBase.getCityIdByName(String cityName);<br>
</code></pre>

<hr />
<h2>Пример использования</h2>
<i>Пример использования вышеописанных методов и классов.</i>

Перед запуском программы, незабываем поднять у себя сервер базы по описанной выше схеме.<br>
<br>
<pre><code>//Подключаем все необходимые классы хранилища.<br>
import ru.amse.agregator.storage.ArchitectualAttraction;<br>
import ru.amse.agregator.storage.City;<br>
import ru.amse.agregator.storage.DataBase;<br>
<br>
import java.awt.geom.Point2D.Double2D;<br>
import java.util.ArrayList;<br>
import java.util.Date;<br>
import org.bson.types.ObjectId;<br>
<br>
public class Example {<br>
    public static void main(String[] args) {<br>
        // TODO Auto-generated method stub<br>
        DataBase.connectToDirtyBase();<br>
<br>
        //Создаём новый объект-контейнер.<br>
        DBWrapper someCity = new DBWrapper();<br>
        <br>
        //Обязательно указываем тип сущности!<br>
        someCity.setType(DBWrapper.TYPE_CITY);<br>
        <br>
        someCity.setName("Рим");<br>
        someCity.setPhoto("images/rim.jpg");<br>
        someCity.setCoordinates(new Point2D.Double(1220.32432,10.234324));<br>
        someCity.setDescription("Описание Рима");<br>
        //ключевые слова<br>
        ArrayList&lt;String&gt; stringsArray = new ArrayList&lt;String&gt;();<br>
        stringsArray.add("beautiful");<br>
        stringsArray.add("city");<br>
        stringsArray.add("rim");<br>
        stringsArray.add("Рим");<br>
        someCity.setKeyWordsArray(stringsArray);<br>
        <br>
        //Добавляем созданный город в базу и объекту автоматически доабвляется поле id<br>
        DataBase.add(someCity);<br>
        <br>
        //---------------<br>
        <br>
        //Создаём новую архитектурную достопримечательность.<br>
        DBWrapper someArchAttr = new DBWrapper();<br>
        <br>
        //Обязательно указываем тип сущности!<br>
        someArchAttr.setType(DBWrapper.TYPE_ARCH_ATTRACTION);<br>
        <br>
        someArchAttr.setName("Колизей");<br>
        <br>
        //Несколько фотографий.<br>
        ArrayList&lt;String&gt; photosArray = new ArrayList&lt;String&gt;();<br>
        photosArray.add("images/kolizey_im1.jpg");<br>
        photosArray.add("images/kolizey_im2.jpg");<br>
        photosArray.add("images/kolizey_im3.jpg");<br>
        photosArray.add("images/kolizey_im4.jpg");<br>
        someArchAttr.setPhotosArray(photosArray);<br>
        <br>
        //указываем город.<br>
        someArchAttr.setCityById(someCity.getId());<br>
        //someArchAttr.setCityByName("Рим"); - так тоже можно. но если известно id то лучше через него.<br>
        <br>
        someArchAttr.setCoordinates(new Point2D.Double(10.324234,1022.24234));<br>
        someArchAttr.setDescription("Kolizey description");<br>
        <br>
        //ключевые слова<br>
        ArrayList&lt;String&gt; keyWordsArray = new ArrayList&lt;String&gt;();<br>
        keyWordsArray.add("rim");<br>
        keyWordsArray.add("kolizey");<br>
        keyWordsArray.add("keyword3");<br>
        someArchAttr.setKeyWordsArray(keyWordsArray);<br>
        <br>
        someArchAttr.setAddress("Kolizey Street, 55");<br>
        someArchAttr.setArchitect("Kirill K.");<br>
        someArchAttr.setCost("100 $");<br>
        someArchAttr.setDate(new Date(1990,7,8));<br>
        <br>
        //добавляем в базу.<br>
        DataBase.add(someArchAttr);<br>
        <br>
        //Получаем все объекты базы:<br>
        ArrayList&lt;DBWrapper&gt; all = DataBase.getAllDBObjects();<br>
        for(DBWrapper obj : all){<br>
            System.out.println("type: " + obj.getType());<br>
            System.out.println("name:" + obj.getName());<br>
            System.out.println("id: " + obj.getId());<br>
            //........<br>
            System.out.println("-------------");<br>
        }<br>
        <br>
        System.out.println("-------------------------------");<br>
        <br>
        //Получаем все города:<br>
        ArrayList&lt;DBWrapper&gt; cities = DataBase.getAllCities();<br>
        for(DBWrapper city : cities){<br>
            System.out.println("type: " + city.getType());<br>
            System.out.println("name:" + city.getName());<br>
            System.out.println("coords: " + city.getCoords());<br>
            //........<br>
            System.out.println("-------------");<br>
        }<br>
        <br>
        System.out.println("-------------------------------");<br>
        <br>
        //Получаем все объекты указанного типа:<br>
        ArrayList&lt;DBWrapper&gt; objsWithSelectedType = DataBase.getAllWithType(DBWrapper.TYPE_ARCH_ATTRACTION);<br>
        for(DBWrapper obj : objsWithSelectedType){<br>
            System.out.println("type: " + obj.getType());<br>
            System.out.println("name:" + obj.getName());<br>
            System.out.println("architect: " + obj.getArchitect());<br>
            System.out.println("address: " + obj.getAddress());<br>
            //........<br>
            System.out.println("-------------");<br>
        }<br>
    }<br>
}<br>
</code></pre>

<hr />
<h2>=)</h2>
Незабываем писать о всех найденных ошибках и неточностях в комменты или личку.<br>
Также все что не понятно, тоже спрашивайте.<br>
<br>
<i>Классы хранилища еще будут неоднократно изменяться и расширяться, следите за обновлениями и используйте в своих частях последнюю версию.</i>