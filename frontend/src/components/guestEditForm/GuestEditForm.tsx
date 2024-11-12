// GuestEditForm.tsx
import "./GuestEditForm.css"
import {ChangeEvent, useState} from "react";
import {Guest} from "../../type/Guest";

type GuestEditFormProps = {
    guest: Guest;
    onSave: (updatedGuest: Guest) => void;
    onCancel: () => void;
};

export default function GuestEditForm({guest, onSave, onCancel}: GuestEditFormProps) {
    // Lokaler Zustand für die Eingabefelder
    const [editGroupName, setEditGroupName] = useState(guest.groupName || "");
    const [editArrivalDate, setEditArrivalDate] = useState(guest.arrivalDate || "");
    const [editDepartureDate, setEditDepartureDate] = useState(guest.departureDate || "");
    const [editFirstName, setEditFirstName] = useState(guest.firstName);
    const [editLastName, setEditLastName] = useState(guest.lastName);
    const [editBirthDate, setEditBirthDate] = useState(guest.birthDate || "");
    const [editNationality, setEditNationality] = useState(guest.nationality || "");
    const [editStreet, setEditStreet] = useState(guest.street || "");
    const [editCity, setEditCity] = useState(guest.city || "");
    const [editZip, setEditZip] = useState(guest.zip || 0);
    const [editEmail, setEditEmail] = useState(guest.email || "");
    const [editPhoneNumber, setEditPhoneNumber] = useState(guest.phoneNumber || "");
    const [editTravelDocumentNumber, setEditTravelDocumentNumber] = useState(guest.travelDocumentNumber || "");

    // Handler für das Ändern der Eingabefelder
    const handleInputChange = (e: ChangeEvent<HTMLInputElement>) => {
        const {name, value} = e.target;
        switch (name) {
            case "groupName":
                setEditGroupName(value);
                break;
            case "arrivalDate":
                setEditArrivalDate(value);
                break;
            case "departureDate":
                setEditDepartureDate(value);
                break;
            case "firstName":
                setEditFirstName(value);
                break;
            case "lastName":
                setEditLastName(value);
                break;
            case "birthDate":
                setEditBirthDate(value);
                break;
            case "nationality":
                setEditNationality(value);
                break;
            case "street":
                setEditStreet(value);
                break;
            case "city":
                setEditCity(value);
                break;
            case "zip":
                setEditZip(0);
                break;
            case "email":
                setEditEmail(value);
                break;
            case "phoneNumber":
                setEditPhoneNumber(value);
                break;
            case "travelDocumentNumber":
                setEditTravelDocumentNumber(value);
                break;
            default:
                break;
        }
    };

    // Speichern der Änderungen
    const handleSave = () => {
        onSave({
            ...guest,
            groupName: editGroupName,
            arrivalDate: editArrivalDate,
            departureDate: editDepartureDate,
            firstName: editFirstName,
            lastName: editLastName,
            birthDate: editBirthDate,
            nationality: editNationality,
            street: editStreet,
            city: editCity,
            zip: editZip,
            email: editEmail,
            phoneNumber: editPhoneNumber,
            travelDocumentNumber: editTravelDocumentNumber,
        });
    };

    return (
        <>
            <div className={"guestEditForm"}>
                <h3>Gast bearbeiten</h3>
                <div>
                    <label>Gruppen-/
                        Familienname: </label>
                    <input value={editGroupName} type="text" name="groupName" onChange={handleInputChange} required/>
                </div>

                <div>
                    <label>Anreise: </label>
                    <input value={editArrivalDate} type="date" name="arrivalDate" onChange={handleInputChange}
                           required/>
                </div>
                <div>
                    <label>Abreise: </label>
                    <input value={editDepartureDate} type="date" name="departureDate" onChange={handleInputChange}
                           required/>
                </div>

                <div>
                    <label>Vorname: </label>
                    <input value={editFirstName} type="text" name="firstName" onChange={handleInputChange} required/>
                </div>

                <div>
                    <label>Nachname: </label>
                    <input value={editLastName} type="text" name="lastName" onChange={handleInputChange} required/>
                </div>

                <div>
                    <label>Geburtstag: </label>
                    <input value={editBirthDate} type="date" name="birthDate" onChange={handleInputChange} required/>
                </div>

                <div>
                    <label>Nationalität: </label>
                    <input value={editNationality} type="text" name="nationality" onChange={handleInputChange}
                           required/>
                </div>

                <div>
                    <label>Straße: </label>
                    <input value={editStreet} type="text" name="street" onChange={handleInputChange} required/>
                </div>

                <div>
                    <label>Stadt: </label>
                    <input value={editCity} type="text" name="city" onChange={handleInputChange} required/>
                </div>

                <div>
                    <label>PLZ: </label>
                    <input value={editZip} type="number" name="zip" onChange={handleInputChange} required/>
                </div>

                <div>
                    <label>Email: </label>
                    <input value={editEmail} type="email" name="email" onChange={handleInputChange} required/>
                </div>

                <div>
                    <label>Telefonnummer: </label>
                    <input value={editPhoneNumber} type="tel" name="phoneNumber" onChange={handleInputChange} required/>
                </div>

                <div>
                    <label>Ausweisnummer: </label>
                    <input value={editTravelDocumentNumber} type="text" name="travelDocumentNumber"
                           onChange={handleInputChange} required/>
                </div>

                <button onClick={handleSave}>Speichern</button>
                <button onClick={onCancel}>Abbrechen</button>
            </div>
        </>
    );
}



