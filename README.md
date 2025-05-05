# learn-micronaut Todo API

## 編譯 (Build)

```sh
gradlew build
```

## 測試 (Test)

```sh
gradlew test
```

## 執行 (local)

1. 請先啟動本機 Postgres，或用 docker-compose 啟動：
   ```sh
   docker-compose up db
   ```
2. 啟動 Micronaut 應用：
   ```sh
   ./gradlew run
   ```

## 執行 (docker-compose)

一次啟動 app + db：
```sh
docker-compose up --build
```

- app 服務會監聽 8080 port
- db 服務會監聽 5432 port

---

### Todo API

- `GET    /todos`         取得所有 todo
- `GET    /todos/{id}`    取得單一 todo
- `POST   /todos`         新增 todo
- `PUT    /todos/{id}`    更新 todo
- `DELETE /todos/{id}`    刪除 todo

---

### Postgres 資訊
- DB: tododb
- User: todo
- Password: todo
- Host: db (docker-compose 內)
- Port: 5432


