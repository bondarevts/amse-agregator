# Сборка / Build #

Рассматривались: [Apache Ant](http://ant.apache.org/) и [Apache Maven](http://maven.apache.org/). Выбран _Ant_, т.к. он удовлетворяет всем нашим требованиям, а описание _build_-файла, в отличии от Maven, представляет собой описание последовтаельных команд, что мне кажется более понятным и удобным =).

---

# Apache Ant #

---

## Установка ##
  1. Скачиваем последнюю версию с [официального сайта](http://ant.apache.org/bindownload.cgi), мы использовали [версию 1.8.1](http://www.sai.msu.su/apache//ant/binaries/apache-ant-1.8.1-bin.tar.gz).
```
wget -O apache-ant.tgz http://www.sai.msu.su/apache//ant/binaries/apache-ant-1.8.1-bin.tar.gz
```
  1. Распаковываем содержимое архива.
```
tar xzf apache-ant.tgz
```
  1. Теперь нужно добавить переменные окружения.
  * ANT\_HOME - путь к распакованной папке Ant'а (там где находятся папки bin, docs, lib, etc).
> Если мы установили Ant в **/usr/local/ant**, то:
```
export ANT_HOME=/usr/local/ant
```
  * JAVA\_HOME - путь к вашей Java Runtime Environment(JRE).
> Например так:
```
export JAVA_HOME=/usr/lib/jvm/java-6-openjdk
```
  * PATH - нужно добавить путь к папке **bin** Ant'а
```
export PATH=${PATH}:${ANT_HOME}/bin
```

---

## Использвоание ##
Если вы проделали все вышеперечисленное, то:
  1. Выкачиваете из svn trunk-ветку нашего проекта.
  1. И находясь в папке trunk, собираете простой командой:
```
ant
```
  1. Запускаете нужный компонент.
> Запустить майнер, на сборку с сайтов, чьи конфиг-файлы лежат в resources/miner:
```
ant run_miner
```
> Запустить кластеризатор, создаётся чистая база:
```
ant run_clusterizer
```
> Запустить индексатор на создание индекса чистой базы:
```
ant run_indexer
```
> Запустить сервер с GUI, http://localhost:8080/attractions.xml :
```
ant run_gui
```

---

  * Так же можно:
> Только скомпилировать:
```
ant compile
```
> Скомпилировать и создать исполняемые .jar архивы.
```
ant dist
```
> Скомпилировать и настроить gui.
```
ant gui
```
> Все вместе. (тоже самое что просто ant)
```
ant install
```
> Очистить папку от собранных бинарников:
```
ant clean
```
> Посмотреть хелп по запуску:
```
ant help
```