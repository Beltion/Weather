# Weather
Сучков Олег
Тестовое задание Android

Приожение состоит из 3-х экранов:
 - CityListActivity - отображает список погоды городов, добавленных пользователем за один день. Города храняться в Room.
 При запуске приложения для каждого города делается запрос на сервер для получения погоды за день. Запускается, когда:
    + пользователь стартует приложение, если это первый запуск приложения,
    то пользователь будет перенаправлен на FirstCityActivity
    + пользователь добавил город из экрана FirstCityActivity

 - FirstCityActivity - позволяет сохранять города - запускается, когда:
    + пользова сохраняет город

 - WeekCityActivity - отображает прогноз погоды на 6 дней,
 при нажатии на день открывается подробный прогдоз дня с интервалом в три часа. Запускается, когда:
    + пользователь кликает по городу на CityListActivity

 Запуск: переместить app-debug.apk из корня проекта на устройство, запустить файл, дождаться завершения установки

 Недочёты/неисправности:
    - дизайн недоделан
    - стили и строки не вынесены в values
    - не сделанно удаление сохранённого города из-за потраченного времени на баги
    - корутины не реализованы по Clean Architecture

    - WeekCityWeather
        + данные о прогнозе за неделю не мапяться и не выводятся
        на коммите "add day at hour list" (aa5bc678f9179e0c46f57295d5d4e470be519391) всё работало
    - FirstCityActivity
        + намудрил с корутинами
