- SQL
  - are relational and use structured tables with predefined schemas. Organized in rows and columns
  - Require a fixed schema, meaning the structure of the data, must be defined before data can be inserted.
  - ACID
    - Atomicity
    - Consistency
    - Isolation
    - Durability
  - Scalable with increase the server capacity(RAM, CPU)
  - Query Language

- MySQL
  - Non-relational and can store unstructured, semi-structured or structured data
    - key-value, documents, wide column stores, graphs
  - Schema-less: data can be inserted without a predefined structure, which offers flexibility for changing data models
  - CAP
    - availability 
    - partition tolerance
    - compromising consistency
  - horizontally scalable: distribute the database load across multiple servers
  - Different databases have different querying mechanisms depending


- When to use SQL:
  - data is structured and relationships between entities are well defined
  - data consistency and integrity are critical
  - complex queries, join and transaction
- When to use NoSQL
  - When you need to handle large volumes of unstructured or semi-structure data
  - when need to scale horizontally for big data or distributed system
  - when flexibility in schema design is required, like in dynamic environments

- Path Variable vs Request Parameter
  - Path Varibale: {id}
  - @GetMapping("/users/{id}")
  - @ResponseBody
```aiignore
@GetMapping("/users/{id}")
@ResponseBody
public String getUserById(@PathVariable String id) {
return "ID: " + id;
}
http://localhost:8080/spring-mvc-basics/users/{id}
http://localhost:8080/spring-mvc-basics/users/1234
----
ID: 1234
```

- Request/Query Parameter: ?key1=value1&key2=value2
```aiignore
@GetMapping("/foos")
@ResponseBody
public String getFooByIdUsingQueryParam(@RequestParam String id, String place) {
return "ID: " + id;
}
http://localhost:8080/spring-mvc-basics/foos?id=abc&place=NewYork
----
ID: abc, Placce: NewYork
```

- @ResponseBody: indicates that the return value of a method should be written directly to HTTP response body

- POST: Create & Save
- GET: READ
- PUT: Update/Replace the entire collection
- PATCH: modify the collection itself
- DELETE: delete the whole collection


- 1xx: informational responses
- 2xx: successful response
- 3xx: redirection
- 4xx: client Error
- 5xx: Server error
- Example: 
  - 200 OK
  - 201 Created
  - 400 Bad Request
  - 401 Unauthorized
  - 403 forbidden
  - 404 not found
  - 500 internal server error


- REST Resource Naming Guide/Convention:
  - Use Nouns to Represent Resources
  - Use Plural Nouns
  - Use HTTP Method
  - Resource Hierarchy Using forward slashes
  - use Path variable to identify resources
  - avoid verbs in resource names
  - user query parameters for filtering, sorting and pagination
  - user hyphens to separate words
  - lowercase resource names
  - avoid file extensions
  - Version your API in the URL


- try with resources:
  - implement the AutoCloseable interface
  - Or closeable
  - Automatic Resource Management: the resource is closed when the try block exits, either normally or through an exception
  - Multiple Resources: can declare multiple resources in the try with resources statement and separated by semicolons.






