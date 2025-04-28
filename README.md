# CrudApp_NimapInfotech
This is a basic CRUD (Create, Read, Update, Delete) for Module categories and product  application built with Spring Boot and connected to a PostgreSQL database.
Categories
1) POST http://localhost:8080/api/categories
Req Body:
{
  "name": "Electronics"
}
Response :
{
    "message": "Category created successfully",
    "success": true,
    "data": {
        "id": 7,
        "name": "Electronics",
        "products": []
    }
}


2) GET http://localhost:8080/api/categories/{cat_id}
Response:
{
    "message": "Category found",
    "success": true,
    "data": {
        "id": 1,
        "name": "Electronics",
        "products": [
            {
                "id": 1,
                "name": "mobile",
                "price": 2002.0
            }
        ]
    }
}


3) GET http://localhost:8080/api/categories?page=0   (Pagination)
{
    "message": "Fetched all categories",
    "success": true,
    "data": {
        "totalPages": 2,
        "categories": [
            {
                "id": 1,
                "name": "Electronics",
                "products": [
                    {
                        "id": 1,
                        "name": "mobile",
                        "price": 2002.0
                    }
]
            },
            {
                "id": 2,
                "name": "Furniture",
                "products": []
            },
            {
                "id": 3,
                "name": "Clothes",
                "products": []
            },
            {
                "id": 4,
                "name": "Constume",
                "products": []
            },
            {
                "id": 5,
                "name": "Estate",
                "products": []
            }
        ],
        "currentPage": 0,
        "totalElements": 7
    }
}


4) PUT http://localhost:8080/api/categories/{cat_id}
Response:
{
    "message": "Category updated successfully",
    "success": true,
    "data": {
        "id": 2,
        "name": "Electronics",
        "products": []
    }
}


5) DEL http://localhost:8080/api/categories/{cat_id}
Response:
{
    "message": "Category deleted successfully",
    "success": true,
    "data": null
}


Products 
1) POST http://localhost:8080/api/products
Req Body:
{
  "name": "Laptop",
  "price": 40000,
  "category": {
    "id":1
  }
}
Response Body:
{
    "message": "Product created successfully",
    "success": true,
    "data": {
        "id": 2,
        "name": "Laptop",
        "price": 40000.0
    }
}


2)GET http://localhost:8081/api/products/{prod_id}  fetching with category details
Response:
{
    "message": "Product found",
    "success": true,
    "data": {
        "id": 1,
        "name": "mobile",
        "price": 20022.0,
        "category": {
            "id": 1,
            "name": "Electronics"
        }
    }
}

3) GET http://localhost:8081/api/products?page=0   (Pagination)
Response:
{
    "message": "Fetched all products",
    "success": true,
    "data": {
        "totalPages": 2,
        "currentPage": 0,
        "products": [
            {
                "id": 1,
                "name": "mobile",
                "price": 2002.0
            },
            {
                "id": 2,
                "name": "Laptop",
                "price": 120000.0
            },
            {
                "id": 3,
                "name": "Laptop",
                "price": 20000.0
            },
            {
                "id": 4,
                "name": "Tv",
                "price": 30000.0
            },
            {
                "id": 5,
                "name": "HM",
                "price": 50000.0
            }
        ],
        "totalElements": 6
    }
}


4)PUT http://localhost:8081/api/products/{prod_id}
Response:
{
    "message": "Product updated successfully",
    "success": true,
    "data": {
        "id": 1,
        "name": "Laptop",
        "price": 40000.0
    }
}

5)DEL http://localhost:8081/api/products/{prod_id}
Response
{
    "message": "Product deleted successfully",
    "success": true,
    "data": null
}


