from sqlalchemy import Column, Integer, String, DateTime
from datetime import datetime

from app.database import Base


class Notification(Base):
    __tablename__ = "notifications"

    id = Column(Integer, primary_key=True, index=True)

    patient_id = Column(Integer, nullable=False)

    message = Column(String(500), nullable=False)

    notification_type = Column(String(50), nullable=False)

    status = Column(String(30), default="SENT")

    sent_at = Column(DateTime, default=datetime.utcnow)