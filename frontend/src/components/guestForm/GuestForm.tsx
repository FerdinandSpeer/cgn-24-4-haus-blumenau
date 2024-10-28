import "./GuestForm.css";
import {Guest} from "../../type/Guest.ts";
import axios from "axios";
import {FormEvent, useState} from "react";
import GuestList from "../guestList/GuestList.tsx";

type guestFormProps = {
    arrivalDate: string,
    departureDate: string,
}

export default function GuestForm(props: guestFormProps) {

    const [newGuest, setNewGuest] = useState({
        groupName: "",
        arrivalDate: props.arrivalDate,
        departureDate: props.departureDate,
        firstName: "",
        lastName: "",
        birthDate: "",
        nationality: "",
        street: "",
        city: "",
        zip: "",
        email: "",
        phoneNumber: "",
        travelDocumentNumber: ""
    });

    const [guestList, setGuestList] = useState<Guest[]>([]);

    function handleSubmit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();
        setGuestList(guestList => newGuest ? [...guestList, newGuest] : guestList);
        setNewGuest({
            arrivalDate: props.arrivalDate,
            departureDate: props.departureDate,
            groupName: "",
            firstName: "",
            lastName: "",
            birthDate: "",
            city: "",
            email: "",
            zip: "",
            nationality: "",
            phoneNumber: "",
            street: "",
            travelDocumentNumber: ""
        });
    }

    function createNewGuestGroup() {
        axios.post("/guestGroup", guestList)
            .then(response => console.log(response))
            .then(() => setGuestList([]))
            .then(() => alert("Anmeldung erfolgreich!"))
            .catch(err => console.log(err))
    }

    function handleChange(e: FormEvent<HTMLInputElement>) {
        const {name, value} = e.currentTarget;
        setNewGuest(prevState => ({...prevState, [name]: value} as Guest));}

    function handleDeleteInGuestList(index: number) {
    const updatedGuests = guestList.filter((_, i) => i !== index);
    setGuestList(updatedGuests);
}

    return (
        <div className={"BookingPage"}>
            <div className={"GuestForm"}>
                <h2>Daten eintragen:</h2>
                <form className={"guestForm"} onSubmit={handleSubmit}>

                    <div>
                        <label>Gruppen-/
                            Familienname: </label>
                        <input value={newGuest?.groupName} type="text" id="groupName" name="groupName" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Anreise: </label>
                        <input value={newGuest?.arrivalDate} type="date" id="arrivalDate" name="arrivalDate" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Abreise: </label>
                        <input value={newGuest?.departureDate} type="date" id="departureDate" name="departureDate" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Vorname: </label>
                        <input value={newGuest?.firstName} type="text" id="firstName" name="firstName" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Nachname: </label>
                        <input value={newGuest?.lastName} type="text" id="lastName" name="lastName" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Geburtstag: </label>
                        <input value={newGuest?.birthDate} type="date" id="birthDate" name="birthDate" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Nationalität: </label>
                        <input value={newGuest?.nationality} type="text" id="nationality" name="nationality" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Straße: </label>
                        <input value={newGuest?.street} type="text" id="street" name="street" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Stadt: </label>
                        <input value={newGuest?.city} type="text" id="city" name="city" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>PLZ: </label>
                        <input value={newGuest?.zip} type="number" id="zip" name="zip" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Email: </label>
                        <input value={newGuest?.email} type="email" id="email" name="email" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Telefonnummer: </label>
                        <input value={newGuest?.phoneNumber} type="tel" id="phoneNumber" name="phoneNumber" required
                               onChange={handleChange}/>
                    </div>

                    <div>
                        <label>Ausweisnummer: </label>
                        <input value={newGuest?.travelDocumentNumber} type="text" id="travelDocumentNumber"
                               name="travelDocumentNumber" required onChange={handleChange}/>
                    </div>

                    <button type="submit" className="primaryButton">Speichern</button>

                </form>
            </div>
            <div className={"GuestList"}>
                <GuestList guests={guestList} handleDeleteInGuestList={handleDeleteInGuestList}/>
                <button onClick={createNewGuestGroup} className="secondaryButton">Abschicken</button>
            </div>
        </div>
    );
}

