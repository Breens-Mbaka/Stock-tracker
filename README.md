# Project Name
> Stock Tracker
## Table of contents
* [Project description](#project-description)
* [DEMO](#demo)
* [Motivation](#motivation)
* [Features](#features)
* [Dependencies](#dependencies)
* [Setup](#setup)
* [Endpoints](#endpoints)
* [TODO](#todo)
* [Status](#status)

## Project Description 
Stock tracker is an Android app that tracks your favorite crypto-currency in realtime.

## DEMO
![signin](https://user-images.githubusercontent.com/72180010/113819199-a9c88c00-9781-11eb-8e1b-33ad28318fa6.png = 250*250)


## Motivation
The main drive behind the project was the opportunity to create an app where you can monitor your profits in realtime crypto-currency since I've been interested in knowing how crypto-currency works
.Also the goal of making an app from development to being published to Google Play store has been one of my dreams.

## Features
* User able to see a list of current valuable coins
* User is able to view coin prices live
* User is able to view price change
* User is able to add favorite coins to monitor

## Dependencies
This dependencies helped a lot in the creation of the Stock tracker app;

* Glide/AndroidSVG/GlideToVectorYou -> I used this to load svg images from the CoinRanking API
* Retrofit -> I used this to aid me in making http calls to the API.Making REST API calls were fast and with minimal code
* Firebase(Database,Authentication) -> I used this to store data in real time and sign in,sign up and sign out my users
* AirBnb Lottie -> To add some animations to my application
* CircleImageView -> To make my svg icon images to be circular
* ButterKnife -> Helped in binding views efficiently

## Setup
> Setup instructions
* Clone the repo to your local machine

```
git clone https://github.com/your_username_/Project-Name.git
```
* Get a free api key here

```
https://coinranking.com/page/cryptocurrency-api
```
* Enter Api key in gradle.properties

```
coinRankingApiKey = "yourApiKey"
```

* Configure your build config to have the key when building the app

```
buildTypes.each {
        it.buildConfigField 'COIN_RANKING_API_KEY', coinRankingApiKey
    }
``` 

## Endpoints
> THis are examples of endpoints you can call with CoinRankingApi.For more info on CoinRanking api visit [here](https://developers.coinranking.com/api/documentation/)

* Base URL
``
https://api.coinranking.com/v2
``

* Specific information about coin
``
GET /coin/:uuid
``

* Coin exchanges(where a specific coin can be trade)
``
GET /coin/:uuid/exchanges
``

* Coin history(lists prices and their timestamps)
``
GET /coin/:uuid/history
``

## TODO
> Features to be added in next version

* Add a chart showing the change in price with time
* Allow user to filter what time duration they want i.e 24hr,60 minutes,7 days,1 year

## Status
Project is: _in progress_
