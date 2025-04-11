## Setup

**Clone application**

```bash
git clone https://github.com/7ukas/kitm-work-rest-api.git
```

**Create MySQL database**
```bash
CREATE DATABASE work
```

**Adjust database credentials**

+ Open `src/main/resources/application.properties` and change `spring.datasource.username` and/or `spring.datasource.password` accordingly.

**Run application**

+ Application will start running at <http://localhost:8080>
+ For better experience use Swagger UI: <http://localhost:8080/swagger-ui/index.html>

## APIs

| Method | Url | Decription |
| ------ | --- | ---------- |
| GET    | /api/works | Get all work entries |
| GET    | /api/works/{id} | Get work entry by id |
| GET    | /api/works/sum/{workerName} | Get total amount of hours worked by worker's name |
| POST   | /api/works | Create new work entry |
| PUT    | /api/works/{id} | Update existing work entry by id |
| DELETE | /api/works/{id} | Remove work entry by id |
