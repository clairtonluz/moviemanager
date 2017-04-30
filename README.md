Movie Manager
=====================================

Setup database
--------------
```shell
psql -U postgres -d postgres -h localhost -W
```

```sql
CREATE USER moviemanager WITH PASSWORD 'moviemanager';
CREATE DATABASE moviemanager;
ALTER DATABASE moviemanager owner to moviemanager;
\q
```

Credentials default to login in system
--------------------------------------
user:admin
pass:admin

Executando o projeto
--------------------
Entra no diretório do projeto e executa o seguinte comando:

Linux:
```shel
    ./gradlew bootRun
```
Windows:
   ```shel
       gradlew.exe bootRun
   ```