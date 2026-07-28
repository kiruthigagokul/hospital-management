from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session

from app.database import SessionLocal
from app import crud, schemas

router = APIRouter(
    prefix="/notifications",
    tags=["Notifications"]
)


def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()


@router.post("/", response_model=schemas.NotificationResponse)
def create_notification(
        notification: schemas.NotificationRequest,
        db: Session = Depends(get_db)):

    return crud.create_notification(db, notification)


@router.get("/", response_model=list[schemas.NotificationResponse])
def get_notifications(db: Session = Depends(get_db)):
    return crud.get_notifications(db)


@router.get("/{notification_id}",
            response_model=schemas.NotificationResponse)
def get_notification(notification_id: int,
                     db: Session = Depends(get_db)):

    notification = crud.get_notification(db, notification_id)

    if notification is None:
        raise HTTPException(status_code=404,
                            detail="Notification not found")

    return notification


@router.get("/patient/{patient_id}",
            response_model=list[schemas.NotificationResponse])
def get_notifications_by_patient(patient_id: int,
                                 db: Session = Depends(get_db)):

    return crud.get_notifications_by_patient(db, patient_id)


@router.delete("/{notification_id}")
def delete_notification(notification_id: int,
                        db: Session = Depends(get_db)):

    notification = crud.delete_notification(db, notification_id)

    if notification is None:
        raise HTTPException(status_code=404,
                            detail="Notification not found")

    return {"message": "Notification deleted successfully"}