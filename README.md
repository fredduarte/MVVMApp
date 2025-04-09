# Recipes

An Recipes is an Android application built using the **Model-View-ViewModel (MVVM)** architectural pattern.
It showcases the use of *The Meal DB* API to fetch and showcase a list of recipes.

## Features

- **HOME**: Displays a list of **recipes** fetched from The Meal DB API, separated by **categories**.
- **SEARCH**: Allows users to search for recipes by name. (_in Development_)
- **PERSISTENCE**: Added persistence using **Room** to store favorite recipes and recently searched. (_in Development_)

## Tech Stack

- **Kotlin**: Primary programming language.
- **Jetpack Compose**: For building declarative UIs.
- **Material 3**: For modern design and theming.
- **Navigation Component**: Uses Compose Destinations library.
- **Retrofit**: For network requests.
- **Coroutines**: For asynchronous programming.
- **Hilt**: For dependency injection.
- **Coil**: For image loading.

## Project Structure

- `data`: Contains data models and API-related classes.
    - `model`: Data models representing the structure of the data.
    - `repository`: Interfaces and classes for data access and manipulation.
    - `network`: Network-related classes, including Retrofit setup and API interfaces.
- `ui`: Includes UI components, screens, themes and widgets.
- `di`: Dependency injection modules.
- `graph`: Main Navigation graph for the app.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/fredduarte/MVVMApp.git