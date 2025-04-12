<<<<<<< HEAD
# Midas
Project repo for the JPMC Advanced Software Engineering Forage program
=======
# Midas Core - Incentive API Integration

## Overview

This project demonstrates the integration of an **Incentive API** with the **Midas Core** financial application. The goal of the project is to manage user transactions, integrate incentive calculation logic from an external API, and update user balances accordingly. This application is built with **Spring Boot**, **REST APIs**, and **JPA** for seamless transaction management.

## Features

- **Transaction Management:** Handles financial transactions between users, ensuring correct balance updates.
- **Incentive API Integration:** Connects to an external API to calculate incentives for transactions and adds them to the recipient's balance.
- **REST API Communication:** Sends and receives transaction data through HTTP POST requests to the Incentive API.
- **Spring Boot & JPA:** Backend implemented with Spring Boot for effective transaction handling and persistence with JPA.
- **Transactional Integrity:** Ensures data consistency and maintains database integrity through Spring's transactional features.

## Technologies Used

- **Spring Boot** – Framework for building backend services
- **REST APIs** – Used for integrating with the Incentive API
- **JPA (Java Persistence API)** – For interacting with the database and managing transaction records
- **H2 Database** – In-memory database for storing transaction and user data
- **Maven** – Build automation tool for managing project dependencies
- **RestTemplate** – Used to call external REST APIs for incentive calculation

## Prerequisites

To run this project, you'll need the following:

- Java 8 or higher
- Maven
- Spring Boot
- H2 Database (configured in the application properties)

## Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/midas-core-incentive-api-integration.git
>>>>>>> a2e91e9cfdd0522a05f2cbe58de28b99e1fd170a
