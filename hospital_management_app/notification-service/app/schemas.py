from pydantic import BaseModel
from datetime import datetime


class NotificationRequest(BaseModel):
    patient_id: int
    message: str
    notification_type: str


class NotificationResponse(BaseModel):
    id: int
    patient_id: int
    message: str
    notification_type: str
    status: str
    sent_at: datetime

    class Config:
        from_attributes = True