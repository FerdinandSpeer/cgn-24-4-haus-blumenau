import {useEffect, useState} from "react";
import {Guest} from "../../type/Guest";
import "./GuestList.css";

type GuestListProps = {
    guests: Guest[];
    handleDeleteInGuestList: (index: number) => void;
};

export default function GuestList(props: GuestListProps) {
    const [guestList, setGuestList] = useState(props.guests);

    useEffect(() => {
        setGuestList(props.guests);
    }, [props.guests]);



    return (
        <div>
            <h2>Gäste Liste:</h2>
            <ol id="guestList">
                {guestList.map((guest, index) => (
                    <li key={index}>
                        {guest.firstName} {guest.lastName}
                        <button onClick={() => props.handleDeleteInGuestList(index)}>Löschen</button>
                    </li>
                ))}
            </ol>
        </div>
    );
}
