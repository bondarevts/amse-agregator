Индексирование производится с помощью библиотеки для **java\_lucene\_3.0.2**<br />
Jar-файл лежит в папке `trunk/libs/`

# Индексирование #
**Индексатор** располагается в package `ru.amse.agregator.indexer`, класс `Indexer`.<br>

<h2>Использование</h2>
<b>Для работы требуется запущенная на компьютере база данных</b><br />
Подробнее про <a href='http://code.google.com/p/amse-agregator/wiki/Storage'>БД и хранилище</a><br />

Подключить<br>
<pre><code>import ru.amse.agregator.storage.*;<br>
import ru.amse.agregator.indexer.OriginalIndexer;<br>
import ru.amse.agregator.utils.ToolsForWorkWithFiles;<br>
</code></pre>
Если нужно создать индекс, используется <code>static</code> метод<br>
<pre><code>void makeNewIndex(File indexDirectory);<br>
</code></pre>
где <code>indexDirectory</code> это папка, в которой планируется размещать индекс. Если она не существует, то создается вместе со всеми необходимыми подпапками. Если создание невозможно, бросается <code>IOException</code>.<br>
<br>
<br>
Если нужно добавить новые записи в индекс, используется <code>static</code> метод<br>
<pre><code>void addToIndex(File indexDirectory);<br>
</code></pre>
где <code>indexDirectory</code> это папка, в которой уже может быть индекс. Если есть файлы индекса, то новые записи добавляются в индекс, иначе метод действует аналогично <code>makeNewIndex</code>.<br>
<br>
Генерируемые исключения:<br>
<ul><li><code>IOException</code> - функциями <code>makeNewIndex</code> и <code>addToIndex</code> в случае, если<br>
<ol><li>не удается создать директорию для индекса;<br>
</li><li>происходит ошибка при создании объекта типа <code>org.apache.lucene.store.NIOFSDirectory</code> в функции <code>index</code>;<br>
</li><li>происходит ошибка при добавлении нового документа <code>lucene</code> в объект типа <code>IndexWriter</code> в функции <code>indexObject</code>.