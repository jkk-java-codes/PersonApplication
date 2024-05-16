# Java Interfaces

The code consists of three Java interfaces: `PersonInterface`, `LifeEventDataInterface`, and `SpokenLanguageInterface`.

## PersonInterface

The `PersonInterface` defines the properties and methods that a `Person` class should have. It includes getter and setter methods for attributes such as `id`, `firstName`, `lastName`, `identityNumber`, `lifeEventData`, `citizenship`, `spokenLanguage`, `children`, and `spouse`. Implementing this interface, new classes can define their own implementation of the `Person` behavior and ensuring adhering to the interface methods.

## LifeEventDataInterface

The `LifeEventDataInterface` defines the properties and methods related to life event data, such as the date and place of birth and death. The `setLifeEventData` method allows setting the life event data using a combination of date, place, and a `LifeEventType`. Implementing this interface, new classes can incorporate life event data functionality and provide implementation of the methods.

## SpokenLanguageInterface

The `SpokenLanguageInterface` defines the properties and methods related to spoken languages. Implementing this interface, new classes can incorporate functionality related to spoken languages and provide implementation of the methods.

## Person Class

The provided `Person` class implements the `PersonInterface` and provides a concrete implementation of the interface's methods. Additionally, it includes additional methods such as `validateStringInput` for input validation purposes.

# Person Controller API Documentation

The Person Controller API provides endpoints for managing persons in a person register. It allows users to perform CRUD (Create, Read, Update, Delete) operations on person records.

## Base URL

The base URL for accessing the Person Controller API is:
http://localhost:8080/api

## Endpoints

### Get Person by ID

Retrieves a person record by their unique identifier (ID).

- URL: `/person/{id}`
- Method: GET
- Parameters:
  - `id` (UUID): The unique identifier of the person.
- Response:
  - If the person is found:
    - Status Code: 200 (OK)
    - Body: JSON representation of the person object.
  - If the person is not found:
    - Status Code: 404 (Not Found)

### Get All Persons

Retrieves all person records.

- URL: `/persons`
- Method: GET
- Response:
  - Status Code: 200 (OK)
  - Body: JSON array containing all person objects.

### Search Persons

Searches for person records based on specified criteria.

- URL: `/search`
- Method: GET
- Parameters:
  - `name` (optional): The name to search for. It can be a first name, last name, or both.
  - `identityNumber` (optional): The identity number to search for.
- Response:
  - Status Code: 200 (OK)
  - Body: JSON array containing the search results, which are person objects matching the specified criteria.

### Create Person

Creates a new person record.

- URL: `/person`
- Method: POST
- Request Body: JSON representation of the person object to be created.
- Response:
  - Status Code: 201 (Created)
  - Body: JSON representation of the created person object, including the assigned unique identifier.

### Update Person

Updates an existing person record.

- URL: `/person/{id}`
- Method: PUT
- Parameters:
  - `id` (UUID): The unique identifier of the person to be updated.
- Request Body: JSON representation of the updated person object.
- Response:
  - If the person is found and successfully updated:
    - Status Code: 200 (OK)
    - Body: JSON representation of the updated person object.
  - If the person is not found:
    - Status Code: 404 (Not Found)

### Delete Person

Deletes an existing person record.

- URL: `/person/{id}`
- Method: DELETE
- Parameters:
  - `id` (UUID): The unique identifier of the person to be deleted.
- Response:
  - If the person is found and successfully deleted:
    - Status Code: 204 (No Content)
  - If the person is not found:
    - Status Code: 404 (Not Found)
