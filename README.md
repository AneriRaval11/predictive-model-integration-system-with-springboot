# Predictive Model Integration System with Spring Boot & FastAPI

This project demonstrates a containerized microservice architecture that integrates **Java Spring Boot** and **Python FastAPI** for delivering machine learning predictions. The system is fully automated with **GitHub Actions CI/CD**, pushing Docker images to DockerHub.

---
<img width="3840" height="2471" alt="Untitled diagram _ Mermaid Chart-2025-07-27-095204" src="https://github.com/user-attachments/assets/66b01c64-d09e-4d2a-b994-aa57ee024ebf" />

## 🧠 Tech Stack

- **Java Spring Boot** – REST API backend to interact with users and forward data to the ML model
- **Python FastAPI** – Serves the trained machine learning model via an API
- **Scikit-learn (Logistic Regression)** – Used for binary classification
- **Docker & Docker Compose** – Containerizes both services for easy deployment
- **GitHub Actions** – Automates build and deployment pipelines
- **Swagger UI** – For API documentation and testing
- **Joblib** – For model serialization

---

## 📁 Project Structure

```
.
├── python-api/                 # FastAPI ML service
│   ├── main.py
│   ├── model.pkl
│   ├── requirements.txt
│   └── Dockerfile
├── springboot-api/            # Java Spring Boot service
│   ├── src/
│   ├── mvnw
│   └── Dockerfile
├── docker-compose.yml         # To run both services together
├── .github/workflows/         # CI/CD GitHub Actions config
│   └── main.yml
└── README.md
```

---

## ⚙️ How It Works

1. **Client** sends a POST request to the Spring Boot API with user input.
2. **Spring Boot** forwards the input (age and salary) to the FastAPI ML service.
3. **FastAPI** loads the logistic regression model and returns the prediction (0 or 1).
4. **Spring Boot** wraps and returns the result to the client in a clean response format.

---

## 🔁 Sample API Interaction

### Spring Boot Endpoint
**POST** `/api/predict`

#### Request Body
```json
{
  "age": 30,
  "estimatedSalary": 60000
}
```

#### Response
```json
{
  "prediction": 1
}
```

### FastAPI Endpoint (Internal)
**POST** `/predict`

#### Forwarded Request
```json
{
  "age": 30,
  "salary": 60000
}
```

#### Response
```json
{
  "prediction": 1
}
```

---

## 🐳 Dockerized Deployment

### Build Images (Locally)
```bash
# From root directory
docker-compose build
```

### Run Services
```bash
docker-compose up
```

- Java Backend: http://localhost:8080
- FastAPI ML: http://localhost:8000/docs (Swagger UI)

---

## 🔄 CI/CD with GitHub Actions

Every push to the `main` branch triggers a CI/CD pipeline:

- Builds Docker images for both `python-api` and `springboot-api`.
- Tags and pushes them to DockerHub:
  - `aneri11/fastapi_ml/python`
  - `aneri11/fastapi_ml/java`

Make sure to configure the following GitHub repository secrets:

| Secret Name       | Description                  |
|-------------------|------------------------------|
| `DOCKER_USERNAME` | Your DockerHub username      |
| `DOCKER_PASSWORD` | Your DockerHub access token  |

---

## 🔖 Prediction Meaning

- `prediction: 1` → User is likely to purchase
- `prediction: 0` → User is unlikely to purchase

---

## ✅ API Testing with Swagger

FastAPI includes auto-generated Swagger UI:

```bash
http://localhost:8000/docs
```

You can test predictions directly via the browser.

---

## 📦 Manual Setup (Optional)

### FastAPI
```bash
cd python-api
pip install -r requirements.txt
uvicorn main:app --reload
```

### Spring Boot
```bash
cd springboot-api
chmod +x mvnw
./mvnw clean package -DskipTests
java -jar target/*.jar
```

---

## 🐙 DockerHub Image Links

- [aneri11/fastapi_ml/java](https://hub.docker.com/r/aneri11/fastapi_ml/java)
- [aneri11/fastapi_ml/python](https://hub.docker.com/r/aneri11/fastapi_ml/python)

