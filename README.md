# Movies Catalog

## Problem

We need to view movies and be aware with each movie details like movie's name, overview, rating and so on

## Solution

We built an application that consisit of 2 screens the first is shown 3 lists of movies 
first list is sorted by popularity, second one is sorted by movies top rated and the third is sorted by the revenue 
by clicking on any movie it will navigate you to details screen that contains movie poster, name, overview, rating and release date

## ScreenShots

<p float="left" >

<img src="https://github.com/ahmedmed7t/Movies-Catalog/assets/37122820/5dba28dc-a822-49c4-944e-b971baad0828" width="250" height="500" hspace="20">

<img src="https://github.com/ahmedmed7t/Movies-Catalog/assets/37122820/f1e8ff0b-5ea1-42bf-95bb-e3d810af267d" width="250" height="500" hspace="20">
           
</p>

## Architecutre 

In this App i used MVVM Architecture so there are 5 layers
- View: represented in Activity that is responsable for showing UI elements
- ViewModel: responsable for the UI Logic and data resistance
- use case: responsable for business logic
- repository: decide which data source should we call to get a specific data 
- data source: getting data from the api

## Technologies
- Kotlin (programming language)
- co-routine (handle threading)
- View binding (dealing with views)
- Retrofit ( calling api )
- Dagger Hilt (dependency injection tool)
- Mockk (mock data in unit test)

