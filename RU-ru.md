# FITBAS API
## Описание
Это самое крутое API в мире для занятия фитнесом дома.

## Функции
* Получить список всех тренировок по расписанию на любой/все дни;
* Добавить любое упражнение в тренировку для любого дня;
* Получить список еды запланированного на любой/все дни и при желании отсортированного по приёму пищи;
* Добавить любую еду в список еды для любого дня и приёма пищи
* Удалить любую еду из списка еды по id
* 


### Project description and tasks

#### General description

Все пользователи системы подразделяются на три роли:

1. Гость
2. Пользователь
3. Администратор

Пользователи получают доступ к функциям ИС только после успешной авторизации.

// TODO дописать :)))

Функционал Гостя:
* Авторизация;
* Регистрация;

Функционал пользователя:
* Расписание (Дата и пользователь)
   * Создать новое расписание
   * Удалить расписание (все данные удаляются)
   * Изменить дату расписания
   * Просмотр всего расписания на определённый день

* Список еды (до 16 еды) (расписание)
   * Добавить еду на определённое расписание (добавить в список еду)
   * Добавить еду из одного расписания в другое расписание (добавить целый список еды)
   * Удалить определённую еду на определённое расписание (удалить из списка)
   * Удалить всю еду из определённого расписания (удалить все из списка)
   * Получить список кол-ва еды на определённое расписание (промежуток дней) (вывести список по дням)
   * Изменить кол-во порций на определённый день (изменить данные строки списка)

* Список упражнений (до 16 упражнений) (расписание и время)
   * Добавить упражнение на определённый список (добавить в список упражнение)
   * Добавить упражнение из одного списка в другой (добавить целый список упражнений)
   * Удалить определённое упражнение на определённый список (удалить из списка)
   * Удалить все упражнения из определённого списка (удалить все из списка)
   * Получить определённый список упражнений (Один список) (вывести список на весь день)
   * Изменить кол-во подходов на определённый день (изменить данные строки списка)

* Еда
  * Добавить "авторскую" еду (до 8 авторских)
  * Изменить данные определённой "авторской" еды
  * Удалить определённую "авторскую" еду
  * Просмотр список еды (Системной, Авторской, Другого пользователя)

* Рецепт
  * Добавить продукт в "авторскую" еду
  * Удалить продукт из "авторской" еды
  * Изменить кол-во продукта "авторской" еды
  * Просмотр продуктов в рецепте

* Продукты
  * Просмотр продуктов (Все, по категории, определённый)

* Упражнения
  * Просмотр упражнений (Все, по группе, определённый)

* Рекомендации
  * Получить список рекомендаций
  * Получить определённую рекомендацию
  * Получить случайную рекомендацию
  



Функционал администратора:
* Добавление нового упражнения;
* Изменение определенного упражнения
* Удаление определенного упражнения
*
* Назначение работников на смены;
* Просмотр всех заказов определенной смены.

Задача – реализовать REST API заданной структуры.


For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web)

### Guides
* [The following guides illustrate how to use some features concretely]()
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

Описание проекта и задач
Общее описание проекта
Все пользователи системы подразделяются на три группы:
1. Администраторы;
2. Официанты;
3. Повара.
   Пользователи получают доступ к функциям ИС только после успешной авторизации.
   Функционал администратора:
   ● Регистрация новых пользователей в системе;
   ● Назначение работников на смены;
   ● Просмотр всех заказов определенной смены.
   Функционал повара:
   ● Просмотр заказов, принятых от клиентов;
   ● Изменение статуса заказа на «готовится» и «готов».
   Функционал официанта:
   ● Создание нового заказа;
   ● Добавление и удаление позиций из заказа;
   ● Просмотр всех принятых им заказов за смену;
   ● Изменение статуса заказа на «отменен» и «оплачен».
   Ваша задача – реализовать REST API заданной структуры.
   В примерах будет использоваться переменная {{host}} которая обозначает адрес
   http://xxxxxx-m2.wsr.ru/, где xxxxxx - логин участника.

Общие требования к API
Api должно быть доступно с других доменов. Позаботьтесь о настройках правил CORS.
Все функции, кроме аутентификации доступны только авторизованным пользователям.
Идентификацию пользователя организуйте посредством Bearer Token.
При попытке доступа к защищенным авторизацией функциям системы во всех запросах
необходимо возвращать ответ следующего вида:
Status: 403
Content-Type: application/json
Body:
{
“error”: {
“code”: 403,
“message”: “Login failed”
}
}
При попытке доступа авторизованным пользователем к функциям недоступным для своей
группы во всех запросах необходимо возвращать ответ следующего вида:
Status: 403
Content-Type: application/json
Body:
{
“error”: {
“code”: 403,
“message”: “Forbidden for you”
}
}
В случае ошибок связанных с валидацией данных во всех запросах необходимо возвращать
следующее тело ответа:
{
“error”: {
“code”: <code>,
“message”: <message>,
“errors”: {
<key>: [ <error message>]
}
}
}
Обратите внимание, что вместо <code> и <message> необходимо указывать соответствующее
значение, определенное в описании ответа на соответствующий запрос. В свойстве error.errors
необходимо перечислить те свойства, которые не прошли валидацию, а в их значениях указать
массив с ошибками валидации.
Например если отправить пустой запрос на сервер, где проверяется следующая валидация:
● phone – обязательно поле
● password – обязательное поле
то тело ответа будет следующим:
{
“error”: {
“code”: 422,
“message”: “Validation error”,
“errors”: {
phone: [ “field phone can not be blank” ],
password: [ “field password can not be blank” ]
}
}
}
Примите во внимание, что code и message могут быть определены иначе, если в запросе
указано иное. В значениях свойств errors вы можете использовать любые сообщения об
ошибках (если не указана конкретная ошибка), но они должны описывать возникшую проблему.


Специфические требования к API
Аутентификация
Запрос для аутентификации пользователя в системе. При отправке запроса необходимо
передать объект с логином и паролем. Если клиент отправил корректные данные, то
необходимо вернуть сгенерированный токен, а иначе сообщение об ошибке