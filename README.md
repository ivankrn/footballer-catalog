# Каталог футболистов 3.0

Тестовое задание Junior Java.

## Технологический стек

- Frontend: Angular
- Backend: Spring Boot, Hibernate

## Основные функции

- Просмотр добавленных в систему футболистов
- Добавление / редактирование данных о футболистах
- Добавление команд
- Отображение изменения данных о футболистах в реальном времени

## Установка и настройка

1. Клонируйте репозиторий:

```bash
git clone https://github.com/ivankrn/footballer-catalog.git
```

2. Установите зависимости для backend:
```bash
cd footballer-catalog-backend
mvn install
```

3. Установите зависимости для frontend:
```bash
cd footballer-catalog-frontend
npm install
```

4. В проекте в качестве базы данных испольуется H2. При запуске приложения база данных будет заполнена демонстрационными данными, находящимися в файле *footballer-catalog-backend/src/main/resources/data.sql*. Если вам необходимо дополнительно сконфигурировать приложение, то измените требуемые настройки в файле конфигурации *application.yml* в каталоге *footballer-catalog-backend/src/main/resources*.

5. Запустите backend:
```bash
cd footballer-catalog-backend
mvn spring-boot:run
```

6. Запустите frontend:
```bash
cd footballer-catalog-frontend
ng serve
```

7. Готово, теперь вы можете перейти по адресу <http://localhost:4200>, чтобы просмотреть каталог футболистов.
Также доступна документация OpenAPI по адресу <http://localhost:8080/swagger-ui/index.html>.