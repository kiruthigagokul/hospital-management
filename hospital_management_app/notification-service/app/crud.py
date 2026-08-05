from sqlalchemy.orm import Session
from app import models, schemas


def create_notification(db: Session, notification: schemas.NotificationRequest):

    db_notification = models.Notification(
        patient_id=notification.patient_id,
        message=notification.message,
        notification_type=notification.notification_type,
        status="SENT"
    )

    db.add(db_notification)
    db.commit()
    db.refresh(db_notification)

    return db_notification


def get_notifications(db: Session):
    return db.query(models.Notification).all()


def get_notification(db: Session, notification_id: int):
    return db.query(models.Notification)\
             .filter(models.Notification.id == notification_id)\
             .first()


def get_notifications_by_patient(db: Session, patient_id: int):
    return db.query(models.Notification)\
             .filter(models.Notification.patient_id == patient_id)\
             .all()


def delete_notification(db: Session, notification_id: int):

    notification = db.query(models.Notification)\
                     .filter(models.Notification.id == notification_id)\
                     .first()

    if notification:
        db.delete(notification)
        db.commit()

    return notification