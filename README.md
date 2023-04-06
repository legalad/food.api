# Food API ![icons8-spring-boot-48](https://user-images.githubusercontent.com/109519711/229430886-455159ed-6663-4076-8c3d-bb30689a6a8b.png) 
API dedicated to FoodApp ([FoodApp](https://github.com/legalad/FoodApp)) 

## Features

- JWT token auth
- JPA

## Endpoints
### General thoughts
API may return following responses:
- 200 OK,
- 400 Bad Request,
- 401 Unauthorized.

API returns JSON responses.
### Pantry @RequestMapping("/api/v1/auth/pantry")

 @GetMapping("/items") -> return array response:
 ```
 [
    {
        "id": number,
        "name": string,
        "barCode": string,
        "placeDate": number,
        "expireDate": number,
        "quantity": number,
        "unit": string,
        "ingredient": {
            "id": number,
            "name": string,
            "scientificName": string,
            "group": string,
            "subGroup": string
        }
    },
    {
       ...
    },
    {
       ...
    }
]
```
@GetMapping("/item/{id}") -> return single object:
```
{
    "id": number1,
    "name": string,
    "barCode": string,
    "placeDate": number,
    "expireDate": number,
    "quantity": number,
    "unit": string,
    "ingredient": {
        "id": number,
        "name": string,
        "scientificName": string,
        "group": string,
        "subGroup": string
    }
}
```
@PostMapping("/item") -> add new object in db, requires body:
```
{
    "name": string,
    "barCode": string,
    "placeDate": number,
    "expireDate": number,
    "quantity": number,
    "unit": string,
    "ingredientId": number,
    "userId": number
}
```
and returns created object (structure as well as @GetMapping("/item/{id}"))

@PutMapping("/item/{id}") -> update item, requires body same as in @PostMapping("/item") and returns created object (structure as well as @GetMapping("/item/{id}"))

@DeleteMapping("/item/{id}") -> returns created object (structure as well as @GetMapping("/item/{id}"))

### Register @RequestMapping("/api/v1/auth")

@PostMapping("/register") create new account, requires body:
```
{
    "firstname": "string,
    "lastname": string,
    "email": string,
    "password": string
}
```
if everything goes well returns JWT ex:
```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYWt1Yi5ub3dha0BtYWlsLmNvbSIsImlhdCI6MTY3NDEyNTQ2NSwiZXhwIjoxNjc0MTI2OTA1fQ.lHXJk6fb1QT6JzNQlTeu-79uWPHnln6WIN2LhoVVwic"
}
```

@PostMapping("/authenticate") authenticate your credentials, requires body:
```
{
    "email": string,
    "password": string
}
```
if everything goes well returns JWT

### Ingredient @RequestMapping("/api/v1/auth/data")
@GetMapping("/ingredient/{id}") -> returns single object:
```
{
        "id": number,
        "name": string,
        "scientificName": string,
        "group": string,
        "subGroup": string
 }
```
@GetMapping("/ingredients") -> returns array:
```
[
    {
        "id": number,
        "name": string,
        "scientificName": string,
        "group": string,
        "subGroup": string
    },
    {
        ...
    },
    {
       ...
    }
]
```
## Postman
See more: [postman collection](https://github.com/legalad/legalad/blob/main/food.api.postman_collection.json)
## Authors

- [@legalad](https://www.github.com/legalad)
