from fastapi import FastAPI
from pydantic import BaseModel
import joblib
import numpy as np

app = FastAPI()

# Load trained model
model = joblib.load("purchase_model.pkl")

class UserData(BaseModel):
    age: float
    salary: float

@app.post("/predict")
def predict(data: UserData):
    features = np.array([[data.age, data.salary]])
    prediction = model.predict(features)
    return {"prediction": int(prediction[0])}
