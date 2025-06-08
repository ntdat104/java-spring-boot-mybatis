# java-spring-boot-mybatis

curl --location 'localhost:8080/api/transactions/search' \
--header 'Content-Type: application/json' \
--data '{
"statuses": ["COMPLETED", "PENDING"],
"page": 0,
"size": 5,
"sortBy": "id",
"sortOrder": "ASC",
"categories": ["FOOD", "SERVICES"]
}'

curl --location 'localhost:8080/api/transactions/detail/search' \
--header 'Content-Type: application/json' \
--data '{
"statuses": ["COMPLETED", "PENDING"],
"page": 0,
"size": 5,
"sortBy": "id",
"sortOrder": "ASC",
"categories": ["FOOD", "SERVICES"]
}'

curl --location 'localhost:8080/api/transactions/dynamic/search' \
--header 'Content-Type: application/json' \
--data '{
"rules": [
{
"field": "amount",
"operator": ">=",
"value": 50
},
{
"field": "amount",
"operator": "<=",
"value": 200
}
],
"page": 0,
"size": 10,
"sortField": "created_at",
"sortDirection": "ASC"
}'