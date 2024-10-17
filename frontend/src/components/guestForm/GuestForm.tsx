import "./GuestForm.css";
import {Guest} from "../../type/Guest.ts";
import axios from "axios";
import {FormEvent, useState} from "react";
import GuestList from "../guestList/GuestList.tsx";

export default function GuestForm() {

    const [newGuest, setNewGuest] = useState<Guest>();
    const [guestList, setGuestList] = useState<Guest[]>([]);

    function handleSubmit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();
        setGuestList(guestList => [...guestList, newGuest]);
        setNewGuest({
            firstName: "",
            lastName: " ",
            birthDate: " ",
            id: undefined,
            city: " ",
            email: " ",
            zip: 0,
            nationality: " ",
            phoneNumber: " ",
            street: " ",
            travelDocumentNumber: " "
        });
    }

    function createNewGuest() {
        axios.post("/guest", newGuest)
            .then(response => console.log(response))
            .catch(err => console.log(err))
    }

    function handleChange(e: FormEvent<HTMLInputElement>) {
        const {name, value} = e.currentTarget;
        setNewGuest(prevState => ({
            ...prevState,
            [name]: value
        }));
    }


    return (
        <>
            <h1> Gästeanmeldung </h1>
            <form id={"guestForm"} onSubmit={handleSubmit}>

                <label>Vorname: </label>
                <input value={newGuest?.firstName} type="text" id="firstName" name="firstName" required
                       onChange={handleChange}/>

                <label>Nachname: </label>
                <input value={newGuest?.lastName} type="text" id="lastName" name="lastName" required
                       onChange={handleChange}/>

                <label> Geburtstag: </label>
                <input value={newGuest?.birthDate} type="date" id="birthDate" name="birthDate" required
                       onChange={handleChange}/>

                <label>Nationalität: </label>
                <input value={newGuest?.nationality} type="text" id="nationality" name="nationality" required
                       onChange={handleChange}/>

                <label>Straße: </label>
                <input value={newGuest?.street} type="text" id="street" name="street" required onChange={handleChange}/>

                <label>Stadt: </label>
                <input value={newGuest?.city} type="text" id="city" name="city" required onChange={handleChange}/>

                <label>PLZ: </label>
                <input value={newGuest?.zip} type="number" id="zip" name="zip" required onChange={handleChange}/>

                <label>Email: </label>
                <input value={newGuest?.email} type="email" id="email" name="email" required onChange={handleChange}/>

                <label>Telefonnummer: </label>
                <input value={newGuest?.phoneNumber} type="tel" id="phoneNumber" name="phoneNumber" required
                       onChange={handleChange}/>

                <label>Ausweisnummer: </label>
                <input value={newGuest?.travelDocumentNumber} type="text" id="travelDocumentNumber"
                       name="travelDocumentNumber" required
                       onChange={handleChange}/>

                <button type="submit">Speichern</button>

            </form>
            <GuestList guests={guestList}/>
            <button>Abschicken</button>
        </>
    );
}

