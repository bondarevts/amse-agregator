Поиск производится с помощью библиотеки для java lucene 3.0.2

# Поиск #
**Поисковик** располагается в package `ru.amse.agregator.searcher`, класс `Searcher`.<br>

<h2>Использование</h2>
<b>Для работы необходим созданный индекс</b>

Подключить<br>
<pre><code>import ru.amse.agregator.storage.DBWrapper;<br>
import ru.amse.agregator.searcher.Searcher;<br>
</code></pre>
Для начала необходимо задать директорию с индексом с помощью <code>static</code> метода<br>
<pre><code>void setIndexDir(File indexDirectory);<br>
</code></pre>
где <code>indexDirectory</code> это папка, в которой ранее был создан индекс.<br>
После этого можно искать по индексу с помощью <code>static</code> метода<br>
<pre><code>ArrayList&lt;DBWrapper&gt; search(UserQuery query);<br>
</code></pre>
Интерфейс класса <code>UserQuery</code>:<br>
<pre><code>class UserQuery {<br>
    void UserQuery(String queryExpression);<br>
    void UserQuery(String queryExpression, Vector&lt;String&gt; labels);<br>
    void setQueryExpression(String queryExpression);<br>
    void setLabels(Vector&lt;String&gt; labels);<br>
    void addLabel(String label);<br>
    String getQueryExpression();<br>
    Vector&lt;String&gt; getLabels();<br>
}<br>
</code></pre>
где <code>queryEpxression</code> - это то, что ввел пользователь в область ввода, а <code>labels</code> - это массив дополнительных условий, которые он отметил на странице поиска.<br>
<br>
Исключения обрабатываются внутри класса, сообщения об ошибках выводятся в стандартный вывод.