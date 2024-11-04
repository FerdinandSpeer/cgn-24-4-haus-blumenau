// GuestList.tsx
import {useEffect, useState} from "react";
import {Guest} from "../../type/Guest";
import GuestEditForm from "../guestEditForm/GuestEditForm.tsx";
import "./GuestList.css";

type GuestListProps = {
    guests: Guest[];
    handleDeleteInGuestList: (index: number) => void;
};

export default function GuestList(props: GuestListProps) {
    const [guestList, setGuestList] = useState(props.guests);
    const [currentGuestToEdit, setCurrentGuestToEdit] = useState<Guest | null>(null);

    useEffect(() => {
        setGuestList(props.guests);
    }, [props.guests]);

    function handleEditInGuestForm(guest: Guest) {
        setCurrentGuestToEdit(guest);
    }

    function handleSaveEdit(updatedGuest: Guest) {
        const updatedGuestList = guestList.map(guest =>
            guest === currentGuestToEdit ? updatedGuest : guest
        );
        setGuestList(updatedGuestList);
        setCurrentGuestToEdit(null);
    }

    function handleCancelEdit() {
        setCurrentGuestToEdit(null);
    }

    return (
        <div>
            <h2>Gäste Liste:</h2>
            <ol id="guestList">
                {guestList.map((guest, index) => (
                    <li key={index}>
                        {guest.firstName} {guest.lastName}
                        <button onClick={() => props.handleDeleteInGuestList(index)}>Löschen</button>
                        <button onClick={() => handleEditInGuestForm(guest)}>Bearbeiten</button>
                    </li>
                ))}
            </ol>

            {currentGuestToEdit && (
                <GuestEditForm
                    guest={currentGuestToEdit}
                    onSave={handleSaveEdit}
                    onCancel={handleCancelEdit}
                />
            )}
        </div>
    );
}
