# entity-snapshot-demo

This repo showcase how to keep property changes
as history

## Usecase

* The user should be able to create a profile
* The user should be able to update any profile properties
* The previous property changed during update should be tracked
* This track properties will be called histories and add to the profile table

### Example - Create Profile

```console
curl --location 'localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "James",
    "lastName": "Doe",
    "email": "james@me.com"
}'
```

> Database table

| id   | first_name | last_name | email        | histories |
|------|------------|-----------|--------------|-----------|
| UUID | James      | Doe       | james@me.com | []        |

### Example - Update Profile

```console
curl --location --request PUT 'localhost:8080/users/97edbc06-a8a5-43f4-9782-1b476184e968' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Fred",
    "lastName": "Deen",
    "email": "fred@me.com"
}'
```

> Database table

| id   | first_name | last_name | email       | histories                                                                                  |
|------|------------|-----------|-------------|--------------------------------------------------------------------------------------------|
| UUID | Fred       | Deen      | fred@me.com | [{"firstName":"James","lastName":"Doe","updated_at":1683985451900,"email":"james@me.com"}] |

