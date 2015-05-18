# Miner #
Являеться компонентом системы ответственным за сбор информации из Сети и ее сохранение в БД. Информация получаемая на выходе программы - унифицированные записи в Сырой БД.
Используемая технология: Web-Harvester.

### Как собирать и запускать Miner ###
Miner собирается ant-овским build файлом.
Полученному jar архиву скармливается директория где лежат конфиг файлы.

Чтобы добавить данные в базу нужно у себя в конфиг файле написать следующего вида строки:
```
<var-def name="returnValue">
  <text>Тип поля</text>
  <template>Данные-в-строку</template>
  ...
  ...
  
  <var-def name="addToDB">1</var-def>
</var-def>
```

_Типы полей:_ type, name, description, coordinates, images, keywords, date\_foundation, architect , cost, address, city\_name, country\_name, music, website, rooms.

Само поле _type_ может быть: `Country, City, ArchAttraction, NaturalAttraction, Cafe, Hotel, Museum, Entertainment, Shopping.`

Поля photos и keywords может содержать много значений, в этом случае перечислите их разделяя точкой с запятой.

Пример кода из конфиг файла который добавит структуру returnValue в базу:
```
<var-def name="returnValue">

  <text>type</text>
  <text>City</text>
					
  <text>name</text>
  <template>${CityName.toString()}</template>
					
  <text>photos</text>
  <template>${cityImages.toString()}</template>

  <text>decription</text>
  <template>${cityDescription.toString()}</template>

</var-def>
						
<var-def name="addToDB">
  1
</var-def>
```

Строки которые попадают в структуру могут содержать теги - это не критично, они все равно позднее убираются. - **!!!Deprecated!!!** - в описании(description) теги необходимые для разумного форматирования оставляем(например такие: `<b></b>, <i></i>, <br/>, <p></p>`) Штобы сохранилось хотябы разделение на абзацы..

В качестве примера можно посмотреть конфиг, собирающий описание и изображение всех городов с сайта http://www.luxe.ru/countries/ тут: http://code.google.com/p/amse-agregator/source/browse/trunk/resources/miner/luxconfig.xml